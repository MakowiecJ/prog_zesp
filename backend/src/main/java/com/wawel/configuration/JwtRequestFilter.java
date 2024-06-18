//package com.wawel.configuration;
//
//import io.jsonwebtoken.ExpiredJwtException;
//import lombok.AllArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@AllArgsConstructor
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//    private final UserDetailsService userDetailsService;
//    private final JwtUtil jwtUtil;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws ServletException, IOException {
//
//        final String authorizationHeader = request.getHeader("Authorization");
//
//        String username = null;
//        String jwt = null;
//
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            jwt = authorizationHeader.substring(7);
//            try {
//                username = jwtUtil.extractUsername(jwt);
//            } catch (ExpiredJwtException e) {
//                String isRefreshToken = request.getHeader("isRefreshToken");
//                String requestURL = request.getRequestURL().toString();
//                if (isRefreshToken != null && isRefreshToken.equals("true") && requestURL.contains("refreshtoken")) {
//                    allowForRefreshToken(e, request);
//                } else {
//                    request.setAttribute("exception", e);
//                }
//            }
//        }
//
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//
//            if (jwtUtil.validateToken(jwt, userDetails)) {
//                List<SimpleGrantedAuthority> authorities = ((List<?>) jwtUtil.extractAllClaims(jwt).get("roles"))
//                        .stream()
//                        .map(role -> new SimpleGrantedAuthority((String) role))
//                        .toList();
//
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, authorities);
//                usernamePasswordAuthenticationToken
//                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            }
//        }
//        chain.doFilter(request, response);
//    }
//
//    private void allowForRefreshToken(ExpiredJwtException ex, HttpServletRequest request) {
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//                null, null, null);
//        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//        request.setAttribute("claims", ex.getClaims());
//    }
//}
