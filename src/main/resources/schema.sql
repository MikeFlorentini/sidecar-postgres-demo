CREATE TABLE athlete
(
 athlete_id SERIAL PRIMARY KEY,
 name varchar(255) NOT NULL,
 sport varchar(255) NOT NULL,
 team varchar(255) NOT NULL
);

INSERT INTO athlete (name, sport, club) VALUES ('Lionel Messi', 'Soccer/Fußball', 'F.C. Barcelona');
