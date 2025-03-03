DELETE FROM user_role;
DELETE FROM users;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (user_id, description, calories, date_time)
VALUES (100000, 'обед', 600, '2022-12-31 23:59:59'),
       (100001, 'перекус', 400, '2022-12-31 13:15:57'),
       (100001, 'food', 800, '2022-12-31 22:15:12'),
       (100001, 'eatting', 900, '2022-12-31 19:54:50'),
       (100000, 'eda', 400, '2022-12-31 21:47:51'),
       (100000, 'eda2', 700, '2022-12-31 17:16:01'),
       (100000, 'eda3', 500, '2022-12-31 20:47:51'),
       (100000, 'eda4', 700, '2022-12-31 19:16:01');