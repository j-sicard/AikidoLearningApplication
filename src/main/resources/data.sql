-- Create database aikido_db if not exist --
CREATE DATABASE IF NOT EXISTS aikido_db;

-- Using database aikido_db --
USE aikido_db;

-- Create table questions --
CREATE TABLE IF NOT EXISTS questions (
    question_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    question_states VARCHAR(255),
    correction_of_the_answer_id BIGINT,
    FOREIGN KEY (correction_of_the_answer_id) REFERENCES correction_of_the_answers(correction_of_the_answer_id)
);

-- Insert data into table questions --
INSERT IGNORE INTO questions (question_id, question_states, correction_of_the_answer_id)
VALUES
(1, 'TACHI WAZA', 1),
(2, 'HANMIHANDACHI WAZA', 2),
(3, 'SUWARI WAZA', 3),
(4, 'USHIRO WAZA', 4);

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

-- Insert data into table question_response for each question --
INSERT IGNORE INTO question_response (question_id, response_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(3, 1),
(3, 2),
(3, 3),
(3, 4),
(4, 1),
(4, 2),
(4, 3),
(4, 4);

-- Create table correction_of_the_answers --
CREATE TABLE IF NOT EXISTS correction_of_the_answers (
    correction_of_the_answer_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    message_for_a_good_answer VARCHAR(255),
    message_for_wrong_answer VARCHAR(255)
);

-- Insert data into table correction_of_the_answers --
INSERT IGNORE INTO correction_of_the_answers (correction_of_the_answer_id, message_for_a_good_answer, message_for_wrong_answer)
VALUES
(1, 'Correcte, la réponse est bien : Tori et Uke travaillent en position debout.',
    'Incorrect, la réponse était : Tori et Uke travaillent en position debout.'),
(2, 'Correcte, la réponse est bien : Les techniques sont effectuées à partir de la position assise (Seiza) de Tori alors que Uke se tient debout.',
    'Incorrect, la réponse était : Les techniques sont effectuées à partir de la position assise (Seiza) de Tori alors que Uke se tient debout.'),
(3, 'Correcte, la réponse est bien : Uke et Tori travaillent en position assise.',
    'Incorrect, la réponse était : Uke et Tori travaillent en position assise.'),
(4, 'Correcte, la réponse est bien : Tori travaille à partir de derrière Uke.',
    'Incorrect, la réponse était : Tori travaille à partir de derrière Uke.');

-- Create table correction_response --
CREATE TABLE IF NOT EXISTS correction_response (
    correction_of_the_answer_id BIGINT,
    response_id BIGINT,
    FOREIGN KEY (correction_of_the_answer_id) REFERENCES correction_of_the_answers(correction_of_the_answer_id),
    FOREIGN KEY (response_id) REFERENCES response(response_id),
    PRIMARY KEY (correction_of_the_answer_id, response_id)
);

-- Insert data into correction_response --
INSERT IGNORE INTO correction_response (correction_of_the_answer_id, response_id)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);
