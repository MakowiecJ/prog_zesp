DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
    id   serial not null primary key,
    name VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id       serial not null primary key,
    username VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL,
    email    VARCHAR(200) NOT NULL
);

DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles
(
    user_id serial not null,
    role_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

DROP TABLE IF EXISTS cinema;
CREATE TABLE cinema
(
    id           serial not null primary key,
    city         VARCHAR(255) NOT NULL,
    address      VARCHAR(255) NOT NULL,
    phone_number INT          NOT NULL
);

INSERT INTO cinema (city, address, phone_number)
VALUES ('KRAKOW', 'ul. Karmelicka 45', 123321643),
       ('KATOWICE', 'ul. Korfantego 123', 368982615),
       ('OPOLE', 'ul. Oleska 45', 118827625),
       ('WROCLAW', 'ul. Oławska 89', 898142765),
       ('LUBAN', 'ul. Słowackiego 67', 121224987);

DROP TABLE IF EXISTS repertoire;
CREATE TABLE repertoire
(
    id        serial not null primary key,
    cinema_id BIGINT NOT NULL,
    date      DATE   NOT NULL,
    FOREIGN KEY (cinema_id) REFERENCES cinema (id)
);
INSERT INTO repertoire (cinema_id, date)
VALUES (1, '2024-06-05'),
       (2, '2024-06-05'),
       (3, '2024-06-05'),
       (4, '2024-06-05'),
       (5, '2024-06-05'),
       (1, '2024-06-06'),
       (2, '2024-06-06'),
       (3, '2024-06-06'),
       (4, '2024-06-06'),
       (5, '2024-06-06'),
       (1, '2024-06-07'),
       (2, '2024-06-07'),
       (3, '2024-06-07'),
       (4, '2024-06-07'),
       (5, '2024-06-07'),
       (1, '2024-06-08'),
       (2, '2024-06-08'),
       (3, '2024-06-08'),
       (4, '2024-06-08'),
       (5, '2024-06-08'),
       (1, '2024-06-09'),
       (2, '2024-06-09'),
       (3, '2024-06-09'),
       (4, '2024-06-09'),
       (5, '2024-06-09'),
       (1, '2024-06-10'),
       (2, '2024-06-10'),
       (3, '2024-06-10'),
       (4, '2024-06-10'),
       (5, '2024-06-10'),
       (1, '2024-06-11'),
       (2, '2024-06-11'),
       (3, '2024-06-11'),
       (4, '2024-06-11'),
       (5, '2024-06-11'),
       (1, '2024-06-12'),
       (2, '2024-06-12'),
       (3, '2024-06-12'),
       (4, '2024-06-12'),
       (5, '2024-06-12'),
       (1, '2024-06-13'),
       (2, '2024-06-13'),
       (3, '2024-06-13'),
       (4, '2024-06-13'),
       (5, '2024-06-13'),
       (1, '2024-06-14'),
       (2, '2024-06-14'),
       (3, '2024-06-14'),
       (4, '2024-06-14'),
       (5, '2024-06-14'),
       (1, '2024-06-15'),
       (2, '2024-06-15'),
       (3, '2024-06-15'),
       (4, '2024-06-15'),
       (5, '2024-06-15'),
       (1, '2024-06-16'),
       (2, '2024-06-16'),
       (3, '2024-06-16'),
       (4, '2024-06-16'),
       (5, '2024-06-16'),
       (1, '2024-06-17'),
       (2, '2024-06-17'),
       (3, '2024-06-17'),
       (4, '2024-06-17'),
       (5, '2024-06-17'),
       (1, '2024-06-18'),
       (2, '2024-06-18'),
       (3, '2024-06-18'),
       (4, '2024-06-18'),
       (5, '2024-06-18'),
       (1, '2024-06-19'),
       (2, '2024-06-19'),
       (3, '2024-06-19'),
       (4, '2024-06-19'),
       (5, '2024-06-19'),
       (1, '2024-06-20'),
       (2, '2024-06-20'),
       (3, '2024-06-20'),
       (4, '2024-06-20'),
       (5, '2024-06-20'),
       (1, '2024-06-21'),
       (2, '2024-06-21'),
       (3, '2024-06-21'),
       (4, '2024-06-21'),
       (5, '2024-06-21'),
       (1, '2024-06-22'),
       (2, '2024-06-22'),
       (3, '2024-06-22'),
       (4, '2024-06-22'),
       (5, '2024-06-22'),
       (1, '2024-06-23'),
       (2, '2024-06-23'),
       (3, '2024-06-23'),
       (4, '2024-06-23'),
       (5, '2024-06-23'),
       (1, '2024-06-24'),
       (2, '2024-06-24'),
       (3, '2024-06-24'),
       (4, '2024-06-24'),
       (5, '2024-06-24'),
       (1, '2024-06-25'),
       (2, '2024-06-25'),
       (3, '2024-06-25'),
       (4, '2024-06-25'),
       (5, '2024-06-25'),
       (1, '2024-06-26'),
       (2, '2024-06-26'),
       (3, '2024-06-26'),
       (4, '2024-06-26'),
       (5, '2024-06-26'),
       (1, '2024-06-27'),
       (2, '2024-06-27'),
       (3, '2024-06-27'),
       (4, '2024-06-27'),
       (5, '2024-06-27'),
       (1, '2024-06-28'),
       (2, '2024-06-28'),
       (3, '2024-06-28'),
       (4, '2024-06-28'),
       (5, '2024-06-28'),
       (1, '2024-06-29'),
       (2, '2024-06-29'),
       (3, '2024-06-29'),
       (4, '2024-06-29'),
       (5, '2024-06-29'),
       (1, '2024-06-30'),
       (2, '2024-06-30'),
       (3, '2024-06-30'),
       (4, '2024-06-30'),
       (5, '2024-06-30');

DROP TABLE IF EXISTS movies;
CREATE TABLE movies
(
    id               serial not null primary key,
    title            VARCHAR(200)  NOT NULL,
    genre            VARCHAR(200)  NOT NULL,
    min_age          INTEGER       NOT NULL,
    duration         INTEGER       NOT NULL,
    status           VARCHAR(200)  NOT NULL,
    poster_source    text,
    trailer_source   text,
    big_image_source text,
    description      VARCHAR(5000) NOT NULL
);

INSERT INTO roles (name)
VALUES ('ROLE_ADMIN'), ('role_admin');
INSERT INTO roles (name)
VALUES ('ROLE_USER'), ('role_user');

INSERT INTO users (username, password, email)
VALUES ('admin', '$2a$10$uuXzvyevIXLJWmkA7WC2e.xM8xZZHJT0v3qdmcolz2Y3G.p2oEGjW', 'admin@gmail.com'),
       ('user', '$2a$10$/XapBAlZcXurPdFgjlKkIOwCAr0WgTt5C09hq6xcQ/X.4GsWpfUQ.', 'user@gmail.com'),
       ('user2', '$2a$10$/XapBAlZcXurPdFgjlKkIOwCAr0WgTt5C09hq6xcQ/X.4GsWpfUQ.', 'user2@gmail.com'),
       ('user3', '$2a$10$/XapBAlZcXurPdFgjlKkIOwCAr0WgTt5C09hq6xcQ/X.4GsWpfUQ.', 'user3@gmail.com'),
       ('user4', '$2a$10$/XapBAlZcXurPdFgjlKkIOwCAr0WgTt5C09hq6xcQ/X.4GsWpfUQ.', 'user4@gmail.com'),
       ('user5', '$2a$10$/XapBAlZcXurPdFgjlKkIOwCAr0WgTt5C09hq6xcQ/X.4GsWpfUQ.', 'user5@gmail.com');

INSERT INTO user_roles(user_id, role_id)
VALUES (1, 1), (1, 2),
       (2, 3), (2, 4);

INSERT INTO movies(title, genre, min_age, duration, trailer_source, status, description)
VALUES ('Avatar: Istota wody', 'Sci-Fi', 13, 193, 'https://www.youtube.com/watch?v=1bjubsSfAUc', 'GRANY',
        'Akcja filmu Avatar: Istota wody rozgrywa się ponad dziesięć lat po wydarzeniach z pierwszej części. To opowieść o rodzinie Jake’a i Neytiri oraz ich staraniach, by zapewnić bezpieczeństwo sobie i swoim dzieciom, mimo tragedii, których wspólnie doświadczają i bitew, które muszą stoczyć, aby przeżyć.* Drodzy widzowie w filmie Avatar: Istota wody znajduje się kilka scen z dynamicznymi efektami świetlnymi, które mogą powodować dyskomfort u widzów wrażliwych na światło i wpływać na osoby z epilepsją fotogenną.'),
       ('Listy do M. 5', 'Komedia Romantyczna', 13, 117, 'https://www.youtube.com/watch?v=IiXxXeY_MiU', 'GRANY',
        '"Listy do M." powracają z 5. częścią wigilijnej opowieści. W kolejnej odsłonie zobaczymy świąteczne perypetie ulubionych bohaterów. Z czym zmierzą się tym razem? Melowi jak zwykle nic nie wychodzi. Zbieg okoliczności sprawia, że staje się bohaterem mimo woli, a jego nie zawsze kryształowy charakter znowu zostaje wystawiony na próbę. Wojciech, który nie czuje wszechobecnej radosnej atmosfery, spotyka na swojej drodze kogoś, kto zmienia jego świąteczne plany. Z kolei Karina i Szczepan uwikłają się w walkę o spadek, który może poróżnić nawet najbliższych. Przekonają się czy z rodziną rzeczywiście dobrze wychodzi się tylko na zdjęciach. To oczywiście nie wszystko! W tej części pojawią się też nowi bohaterowie i ich zaskakujące historie. "Listy do M. 5" skupią się na uniwersalnych wartościach, takich jak miłość, bliskość czy życzliwość, które obecnie są najistotniejsze.'),
       ('Dzika Noc', 'Akcja', 16, 112, 'https://www.youtube.com/watch?v=nbPBgbBfXS4', 'GRANY', 'Producenci filmów ”Nikt”, „John Wick”, „Deadpool 2” realizują dla studia Universal mroczny thriller „Dzika Noc”.

Zobaczymy między innymi gwiazdę serialu "Stranger Things” Davida Harboura oraz zdobywcę nagrody Emmy- Johnego Leguizamo oraz innych: Edi Pattersona, Cam Gigandet Alexa Hassella i Beverly D''Angelo.

Film wyreżyserowany będzie przez norweskiego reżysera Tommy''ego Wirkolę ("Hansel & Gretel: Łowca czarownic” na podstawie scenariusza Pata Caseya i Josha Millera (Sonic 2.Szybki jak błyskawica).

Kiedy pewna, bogata rodzina zostaje zakładnikami w Wigilię, przestępcy nie są przygotowani na niespodziewanego bojownika. Święty Mikołaj (w tej roli David Harbour, serial Stranger Things) jest na miejscu i ma zamiar pokazać, dlaczego Mikołaj nie będzie taki święty.');

DROP TABLE IF EXISTS reviews;
CREATE TABLE reviews
(
    id          serial not null primary key,
    movie_id    BIGINT NOT NULL,
    user_id     BIGINT NOT NULL,
    rating      INT    NOT NULL,
    review_text VARCHAR(5000),
    FOREIGN KEY (movie_id) REFERENCES movies (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO reviews (movie_id, user_id, rating, review_text)
VALUES (1, 2, 5, 'Great movie!'),
       (2, 3, 4, 'Really enjoyed it!'),
       (3, 4, 3, 'It was okay.'),
       (1, 5, 2, 'Not my favorite.'),
       (2, 6, 1, 'Hated it!');

DROP TABLE IF EXISTS screen;
CREATE TABLE screen
(
    id          serial not null primary key,
    cinema_id   BIGINT       NOT NULL,
    screen_name VARCHAR(255) NOT NULL,
    capacity    INT          NOT NULL,
    FOREIGN KEY (cinema_id) REFERENCES cinema (id)
);
INSERT INTO screen (cinema_id, screen_name, capacity)
VALUES (1, 'SALA1', 161),
       (1, 'SALA2', 161),
       (1, 'SALA3', 161),
       (1, 'SALA4', 161),
       (2, 'SALA1', 161),
       (2, 'SALA2', 161),
       (2, 'SALA3', 161),
       (2, 'SALA4', 161),
       (3, 'SALA1', 161),
       (3, 'SALA2', 161),
       (3, 'SALA3', 161),
       (3, 'SALA4', 161),
       (4, 'SALA1', 161),
       (4, 'SALA2', 161),
       (4, 'SALA3', 161),
       (4, 'SALA4', 161),
       (5, 'SALA1', 161),
       (5, 'SALA2', 161),
       (5, 'SALA3', 161),
       (5, 'SALA4', 161);


DROP TABLE IF EXISTS screenings;
CREATE TABLE screenings
(
    id               serial not null primary key,
    repertoire_id    BIGINT         NOT NULL,
    screen_id        BIGINT         NOT NULL,
    movie_id         BIGINT         NOT NULL,
    start_time       TIME           NOT NULL,
    movie_type       VARCHAR(100)   NOT NULL,
    movie_sound_type VARCHAR(50)    NOT NULL,
    seats            VARCHAR(12000) NOT NULL,
    FOREIGN KEY (repertoire_id) REFERENCES repertoire (id),
    FOREIGN KEY (screen_id) REFERENCES screen (id),
    FOREIGN KEY (movie_id) REFERENCES movies (id)
);
INSERT INTO screenings (repertoire_id, screen_id, movie_id, start_time, movie_type, movie_sound_type, seats)
VALUES (1, 1, 1, '10:00:00', 'D2', 'DUBBING',
        '[["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","ZAJETE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE"]]'),
       (51, 1, 1, '10:00:00', 'D2', 'DUBBING',
        '[["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","ZAJETE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE"]]'),
       (51, 1, 2, '10:00:00', 'D2', 'DUBBING',
        '[["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","ZAJETE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE"]]'),
       (56, 1, 1, '10:00:00', 'D2', 'DUBBING',
        '[["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","ZAJETE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE"]]'),
       (56, 1, 2, '10:00:00', 'D2', 'DUBBING',
        '[["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","ZAJETE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE"]]'),
       (66, 1, 1, '10:00:00', 'D2', 'DUBBING',
        '[["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","ZAJETE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE"]]'),
       (71, 1, 1, '10:00:00', 'D2', 'DUBBING',
        '[["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","ZAJETE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE"]]'),
       (56, 2, 2, '10:00:00', 'D2', 'DUBBING',
        '[["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","ZAJETE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","ZAJETE","ZAJETE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","NIE_ISTNIEJE","NIE_ISTNIEJE","NIE_ISTNIEJE","WOLNE","WOLNE"],["WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE","WOLNE"]]');


DROP TABLE IF EXISTS tickets;
CREATE TABLE tickets
(
    id           serial not null primary key,
    user_id      BIGINT,
    screening_id BIGINT      NOT NULL,
    seat_row     INT         NOT NULL,
    seat_number  INT         NOT NULL,
    ticket_type  VARCHAR(50) NOT NULL,
    FOREIGN KEY (screening_id) REFERENCES screenings (id)
);

INSERT INTO tickets (user_id, screening_id, seat_row, seat_number, ticket_type)
VALUES (2, 1, 0, 8, 'ULGOWY'),
       (2, 2, 2, 8, 'NORMALNY'),
       (2, 1, 0, 9, 'NORMALNY'),
       (2, 1, 0, 10, 'SENIOR'),
       (3, 2, 4, 8, 'NORMALNY'),
       (4, 1, 4, 3, 'NORMALNY'),
       (5, 2, 4, 5, 'NORMALNY'),
       (6, 1, 2, 8, 'NORMALNY'),
       (3, 1, 4, 8, 'NORMALNY');

