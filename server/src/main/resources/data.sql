INSERT INTO season (season_name)
VALUES ('Season 1');

INSERT INTO game_settings (active_season)
VALUES (1);

--

INSERT INTO players (email)
VALUES ('test1@hotmail.com');

INSERT INTO players (email)
VALUES ('test2@hotmail.com');

INSERT INTO players (email)
VALUES ('test3@hotmail.com');

INSERT INTO players (email)
VALUES ('test4@hotmail.com');

INSERT INTO players (email)
VALUES ('test5@hotmail.com');


INSERT INTO players (email)
VALUES ('test6@hotmail.com');
--


INSERT INTO pick_history (player_id, season_id, picked_day, option_selected)
VALUES (1, 1, '03/28/2020', 1);

INSERT INTO pick_history (player_id, season_id, picked_day, option_selected)
VALUES (2, 1, '03/28/2020', 1);

INSERT INTO pick_history (player_id, season_id, picked_day, option_selected)
VALUES (3, 1, '03/28/2020', 2);

INSERT INTO pick_history (player_id, season_id, picked_day, option_selected)
VALUES (4, 1, '03/28/2020', 2);

INSERT INTO pick_history (player_id, season_id, picked_day, option_selected)
VALUES (5, 1, '03/28/2020', 2);
