DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS goalie;
DROP TABLE IF EXISTS appuser;
DROP TABLE IF EXISTS teammember;
DROP TABLE IF EXISTS team;

CREATE TABLE team
(teamid BIGSERIAL PRIMARY KEY,
teamname VARCHAR(30),
teamwins INT,
teamlosses INT);

INSERT INTO team (teamname, teamwins, teamlosses)
VALUES ('Mellunmäen Pinkka', '1', '1'),
        ('Tuiran Raitis', '1', '1');

CREATE TABLE teammember (
    memberid BIGSERIAL PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    jerseynumber INT,
    teamid BIGINT,
    membertype VARCHAR(255),
    goals INT,
    assists INT,
    points INT,
    saves INT,
    saveprc FLOAT,
    wins INT,
    losses INT,
    FOREIGN KEY (teamid) REFERENCES team(teamid)
    
);


INSERT INTO teammember (firstname, lastname, jerseynumber, membertype, goals, assists, points, teamid)
VALUES ('Mikko', 'Mikkonen', '27', 'Player', '3', '0', '3', '1'),
        ('Topi', 'Topinen', '13', 'Player', '0', '3', '3', '1'),
        ('Juho', 'Juhola', '91', 'Player', '0', '2', '2', '1'),
        ('Eero', 'Eerola', '33', 'Player', '1', '0', '1', '2'),
        ('Tommi', 'Tommila', '92', 'Player', '0', '1', '1', '2'),
        ('Jukka', 'Jukkala', '20', 'Player', '0', '0', '0', '2'); 



INSERT INTO teammember (firstname, lastname, jerseynumber, membertype ,saves, saveprc, wins, losses, teamid)
VALUES ('Pekka', 'Pekkanen' , '35', 'Goalie' ,'9', '90', '1', '1', '1'),
('Tuukka', 'Tuukkanen', '40', 'Goalie' ,'40', '88', '1', '1', '2');

CREATE TABLE appuser
(id BIGSERIAL PRIMARY KEY
, username VARCHAR(20) NOT NULL
, password_hash VARCHAR(250) NOT NULL
, role VARCHAR(100) NOT NULL);

INSERT INTO appuser (username, password_hash, role)
VALUES ('user', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'USER'),
        ('admin', '$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C', 'ADMIN');

SELECT * FROM teammember;
SELECT * FROM team;
SELECT * FROM appuser

