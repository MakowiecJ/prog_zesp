package com.wawel.controllers;

import com.wawel.common.City;
import com.wawel.request.*;
import com.wawel.response.GetRepertoireResponse;
import com.wawel.response.GetScreeningResponse;
import com.wawel.response.GetUserInfoResponse;
import com.wawel.service.movies.MoviesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private MoviesService service;

//    @GetMapping("/users/{userId}")
//    public GetUserInfoResponse getUserInfo(@PathVariable final Long userId) {
//        return service.getUserInfo(userId);
//    }

//    @PostMapping("/tickets/buy")
//    public ResponseEntity<String> buyTickets(@RequestBody final BuyTicketsRequest request) {
//        return service.buyTickets(request);
//    }

}
