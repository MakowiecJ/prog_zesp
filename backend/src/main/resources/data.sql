DROP TABLE IF EXISTS movies;
CREATE TABLE movies
(
	id                        UUID         NOT NULL DEFAULT RANDOM_UUID() PRIMARY KEY,
	title                     VARCHAR(200) NOT NULL,
	description               VARCHAR(4096),
	ads_duration              INTEGER      NOT NULL,
	movie_duration            INTEGER      NOT NULL,
	cleaning_service_duration INTEGER      NOT NULL,
	genre                     VARCHAR(200) NOT NULL,
	min_age                   INTEGER      NOT NULL,
	status                    VARCHAR(200) NOT NULL,
	poster_source             VARCHAR(2083),
	trailer_source            VARCHAR(2083),
	big_image_source          VARCHAR(2083)
);
INSERT INTO movies(title, genre, min_age, ads_duration, movie_duration, cleaning_service_duration, status, description,
									 big_image_source)
VALUES ('Avatar: Istota wody',
				'Sci-Fi',
				13,
				15,
				190,
				30,
				'GRANY',
				'Akcja filmu Avatar: Istota wody rozgrywa się ponad dziesięć lat po wydarzeniach z pierwszej części. To opowieść o rodzinie Jake’a i Neytiri oraz ich staraniach, by zapewnić bezpieczeństwo sobie i swoim dzieciom, mimo tragedii, których wspólnie doświadczają i bitew, które muszą stoczyć, aby przeżyć.* Drodzy widzowie w filmie Avatar: Istota wody znajduje się kilka scen z dynamicznymi efektami świetlnymi, które mogą powodować dyskomfort u widzów wrażliwych na światło i wpływać na osoby z epilepsją fotogenną.',
				'https://a.allegroimg.com/original/11d976/334547e342fbb91918a02f507c6e/Plakat-Avatar-Istota-wody-AVATAR-2-2022-100x70'),
			 ('Listy do M. 5',
				'Komedia Romantyczna',
				13,
				15,
				120,
				30,
				'GRANY',
				'"Listy do M." powracają z 5. częścią wigilijnej opowieści. W kolejnej odsłonie zobaczymy świąteczne perypetie ulubionych bohaterów. Z czym zmierzą się tym razem? Melowi jak zwykle nic nie wychodzi. Zbieg okoliczności sprawia, że staje się bohaterem mimo woli, a jego nie zawsze kryształowy charakter znowu zostaje wystawiony na próbę. Wojciech, który nie czuje wszechobecnej radosnej atmosfery, spotyka na swojej drodze kogoś, kto zmienia jego świąteczne plany. Z kolei Karina i Szczepan uwikłają się w walkę o spadek, który może poróżnić nawet najbliższych. Przekonają się czy z rodziną rzeczywiście dobrze wychodzi się tylko na zdjęciach. To oczywiście nie wszystko! W tej części pojawią się też nowi bohaterowie i ich zaskakujące historie. "Listy do M. 5" skupią się na uniwersalnych wartościach, takich jak miłość, bliskość czy życzliwość, które obecnie są najistotniejsze.',
				'https://fwcdn.pl/fpo/18/77/10011877/8031829.3.jpg'),
			 ('Dzika Noc',
				'Akcja',
				15,
				16,
				112,
				30,
				'GRANY',
				'Producenci filmów ”Nikt”, „John Wick”, „Deadpool 2” realizują dla studia Universal mroczny thriller „Dzika Noc”. Zobaczymy między innymi gwiazdę serialu "Stranger Things” Davida Harboura oraz zdobywcę nagrody Emmy- Johnego Leguizamo oraz innych: Edi Pattersona, Cam Gigandet Alexa Hassella i Beverly D''Angelo. Film wyreżyserowany będzie przez norweskiego reżysera Tommy''ego Wirkolę ("Hansel & Gretel: Łowca czarownic” na podstawie scenariusza Pata Caseya i Josha Millera (Sonic 2.Szybki jak błyskawica). Kiedy pewna, bogata rodzina zostaje zakładnikami w Wigilię, przestępcy nie są przygotowani na niespodziewanego bojownika. Święty Mikołaj (w tej roli David Harbour, serial Stranger Things) jest na miejscu i ma zamiar pokazać, dlaczego Mikołaj nie będzie taki święty.',
				'https://fwcdn.pl/fpo/60/21/10016021/8038694.3.jpg');


DROP TABLE IF EXISTS cinemas;
CREATE TABLE cinemas
(
	id           UUID         NOT NULL DEFAULT RANDOM_UUID() PRIMARY KEY,
	street       VARCHAR(255) NOT NULL,
	postal_code  VARCHAR(255) NOT NULL,
	city         VARCHAR(255) NOT NULL,
	mail_address VARCHAR(255) NOT NULL,
	phone_number VARCHAR(255) NOT NULL
);
INSERT INTO cinemas (id, street, postal_code, city, mail_address, phone_number)
VALUES ('fd06eb55-41df-47ed-83e6-feadf772f50e', 'ul. Karmelicka 45', '31-038', 'Kraków', 'krakow@wawel.pl',
				'123321643'),
			 ('ead20929-eef5-4e75-9af9-3136d60c08b3', 'ul. Korfantego 123', '40-038', 'Katowice', 'katowice@wawel.pl',
				'368982615'),
			 ('4ee3b17d-6dad-4e84-9ecb-f22bbb33c2ad', 'ul. Oleska 45', '45-058', 'Opole', 'opole@wawel.pl', '118827625'),
			 ('3af27140-0ebc-471a-a6aa-3bd120dc1503', 'ul. Oławska 89', '50-115', 'Wrocław', 'wroclaw@wawel.pl', '898142765'),
			 ('b8dbb76f-92e3-400d-bd5f-2e743a61a178', 'ul. Słowackiego 67', '59-800', 'Lubań', 'luban@wawel.pl', '121224987');


DROP TABLE IF EXISTS screens;
CREATE TABLE screens
(
	id          UUID         NOT NULL DEFAULT RANDOM_UUID() PRIMARY KEY,
	cinema_id   UUID         NOT NULL,
	screen_name VARCHAR(255) NOT NULL,
	capacity    INT          NOT NULL,

	FOREIGN KEY (cinema_id) REFERENCES cinemas (id)
);
INSERT INTO screens (cinema_id, screen_name, capacity)
VALUES ('fd06eb55-41df-47ed-83e6-feadf772f50e', 'Sala 1', 161),
			 ('fd06eb55-41df-47ed-83e6-feadf772f50e', 'Sala 2', 161),
			 ('fd06eb55-41df-47ed-83e6-feadf772f50e', 'Sala 3', 161),
			 ('fd06eb55-41df-47ed-83e6-feadf772f50e', 'Sala 4', 161),

			 ('ead20929-eef5-4e75-9af9-3136d60c08b3', 'Sala 1', 161),
			 ('ead20929-eef5-4e75-9af9-3136d60c08b3', 'Sala 2', 161),
			 ('ead20929-eef5-4e75-9af9-3136d60c08b3', 'Sala 3', 161),
			 ('ead20929-eef5-4e75-9af9-3136d60c08b3', 'Sala 4', 161),

			 ('4ee3b17d-6dad-4e84-9ecb-f22bbb33c2ad', 'Sala 1', 161),
			 ('4ee3b17d-6dad-4e84-9ecb-f22bbb33c2ad', 'Sala 2', 161),
			 ('4ee3b17d-6dad-4e84-9ecb-f22bbb33c2ad', 'Sala 3', 161),
			 ('4ee3b17d-6dad-4e84-9ecb-f22bbb33c2ad', 'Sala 4', 161),

			 ('3af27140-0ebc-471a-a6aa-3bd120dc1503', 'Sala 1', 161),
			 ('3af27140-0ebc-471a-a6aa-3bd120dc1503', 'Sala 2', 161),
			 ('3af27140-0ebc-471a-a6aa-3bd120dc1503', 'Sala 3', 161),
			 ('3af27140-0ebc-471a-a6aa-3bd120dc1503', 'Sala 4', 161),

			 ('b8dbb76f-92e3-400d-bd5f-2e743a61a178', 'Sala 1', 161),
			 ('b8dbb76f-92e3-400d-bd5f-2e743a61a178', 'Sala 2', 161),
			 ('b8dbb76f-92e3-400d-bd5f-2e743a61a178', 'Sala 3', 161),
			 ('b8dbb76f-92e3-400d-bd5f-2e743a61a178', 'Sala 4', 161);


DROP TABLE IF EXISTS screenings;
CREATE TABLE screenings
(
	id               UUID         NOT NULL DEFAULT RANDOM_UUID() PRIMARY KEY,
	screen_id        UUID         NOT NULL,
	movie_id         UUID         NOT NULL,
	start_time       TIMESTAMP    NOT NULL,
	movie_type       VARCHAR(100) NOT NULL,
	movie_sound_type VARCHAR(50)  NOT NULL,
	FOREIGN KEY (screen_id) REFERENCES screens (id),
	FOREIGN KEY (movie_id) REFERENCES movies (id)
);


DROP TABLE IF EXISTS users;
CREATE TABLE users
(
	id       UUID         NOT NULL DEFAULT RANDOM_UUID() PRIMARY KEY,
	username VARCHAR(200) NOT NULL,
	password VARCHAR(200) NOT NULL,
	email    VARCHAR(200) NOT NULL
);
INSERT INTO users (id, username, password, email)
VALUES ('ecf59248-f3d2-479f-b14d-741eefd1b323', 'administrator',
				'$2a$10$uuXzvyevIXLJWmkA7WC2e.xM8xZZHJT0v3qdmcolz2Y3G.p2oEGjW', 'administrator@wawel.pl'),
			 ('1fa96887-a874-4df4-a58a-3c1b24bb2b8b', 'user1', '$2a$10$/XapBAlZcXurPdFgjlKkIOwCAr0WgTt5C09hq6xcQ/X.4GsWpfUQ.',
				'user1@gmail.com'),
			 ('9f62d284-c523-4855-b72a-49d5bb279b2f', 'user2', '$2a$10$/XapBAlZcXurPdFgjlKkIOwCAr0WgTt5C09hq6xcQ/X.4GsWpfUQ.',
				'user2@gmail.com'),
			 ('937907b8-4519-4734-9982-d9e36c8b7785', 'user3', '$2a$10$/XapBAlZcXurPdFgjlKkIOwCAr0WgTt5C09hq6xcQ/X.4GsWpfUQ.',
				'user3@gmail.com');


DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
	id   UUID         NOT NULL DEFAULT RANDOM_UUID() PRIMARY KEY,
	name VARCHAR(100) NOT NULL
);
INSERT INTO roles (id, name)
VALUES ('64900957-4772-42fb-a55c-c1c7de1d0cb4', 'administrator'),
			 ('5df86631-3419-4baf-a28d-5f9d33d7e8d4', 'customer');


DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles
(
	user_id UUID NOT NULL PRIMARY KEY,
	role_id UUID NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users (id),
	FOREIGN KEY (role_id) REFERENCES roles (id)
);
INSERT INTO user_roles (user_id, role_id)
VALUES ('ecf59248-f3d2-479f-b14d-741eefd1b323', '64900957-4772-42fb-a55c-c1c7de1d0cb4'),
			 ('1fa96887-a874-4df4-a58a-3c1b24bb2b8b', '5df86631-3419-4baf-a28d-5f9d33d7e8d4'),
			 ('9f62d284-c523-4855-b72a-49d5bb279b2f', '5df86631-3419-4baf-a28d-5f9d33d7e8d4'),
			 ('937907b8-4519-4734-9982-d9e36c8b7785', '5df86631-3419-4baf-a28d-5f9d33d7e8d4');