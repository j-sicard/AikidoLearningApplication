-- Create Data base aikido_db if not exist --
CREATE DATABASE IF NOT EXISTS aikido_db;

-- Using database aikido_db --
USE aikido_db;

-- Create table questions --
CREATE TABLE IF NOT EXISTS questions (
    question_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    question_states VARCHAR(255),
    correct_answers VARCHAR(500)
);

-- Insert data into table questions --
INSERT IGNORE INTO questions (question_id, question_states, correct_answers)
VALUES
(1, 'TACHI WAZA', 'La bonne reponse est: Tori et Uke travaillent en position debout.'),
(2, 'HANMIHANDACHI WAZA', 'La bonne reponse est: Les techniques sont effectuées à partir de la position assise (Seiza) de Tori alors que Uke se tient debout.'),
(3, 'SUWARI WAZA', 'La bonne reponse est: Uke et Tori travaillent en position assise.'),
(4, 'USHIRO WAZA', 'La bonne reponse est: Tori travaille à partir de derrière Uke.');

-- Create table response --
CREATE TABLE IF NOT EXISTS response (
    response_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    response_states VARCHAR(255)
);

-- Insert data into table response --
INSERT IGNORE INTO response (response_id, response_states)
VALUES
(1, 'Tori et Uke travaillent en position debout.'),
(2, 'Les techniques sont effectuées à partir de la position assise (Seiza) de Tori alors que Uke se tient debout.'),
(3, 'Uke et Tori travaillent en position assise.'),
(4, 'Tori travaille à partir de derrière Uke.');

-- Create table question_response --
CREATE TABLE IF NOT EXISTS question_response (
    question_id BIGINT,
    response_id BIGINT,
    FOREIGN KEY (question_id) REFERENCES questions(question_id),
    FOREIGN KEY (response_id) REFERENCES response(response_id),
    PRIMARY KEY (question_id, response_id)
);

-- Insert data into table question_response for question id 1 --
INSERT IGNORE INTO question_response (question_id, response_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4);

-- Insert data into table question_response for question id 2 --
INSERT IGNORE INTO question_response (question_id, response_id)
VALUES
(2, 1),
(2, 2),
(2, 3),
(2, 4);

-- Insert data into table question_response for question id 3 --
INSERT IGNORE INTO question_response (question_id, response_id)
VALUES
(3, 1),
(3, 2),
(3, 3),
(3, 4);

-- Insert data into table question_response for question id 4 --
INSERT IGNORE INTO question_response (question_id, response_id)
VALUES
(4, 1),
(4, 2),
(4, 3),
(4, 4);
