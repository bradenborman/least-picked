INSERT INTO season (season_name)
VALUES ('Season 1');

INSERT INTO game_settings (active_season)
VALUES (1);

--

INSERT INTO players (email)
VALUES ('test@hotmail.com');

INSERT INTO players (email)
VALUES ('bradenborman00@gmail.com');

--

INSERT INTO pick_history (player_id, season_id, picked_day, option_selected)
VALUES (1, 1, '03/25/2020', 2);

INSERT INTO pick_history (player_id, season_id, picked_day, option_selected)
VALUES (2, 1, '03/25/2020', 2);

INSERT INTO pick_history (player_id, season_id, picked_day, option_selected)
VALUES (1, 1, '03/26/2020', 2);

INSERT INTO pick_history (player_id, season_id, picked_day, option_selected)
VALUES (2, 1, '03/26/2020', 2);

INSERT INTO pick_history (player_id, season_id, picked_day, option_selected)
VALUES (1, 1, '03/27/2020', 2);

INSERT INTO pick_history (player_id, season_id, picked_day, option_selected)
VALUES (2, 1, '03/27/2020', 2);

INSERT INTO pick_history (player_id, season_id, picked_day, option_selected)
VALUES (1, 1, '03/28/2020', 2);

INSERT INTO pick_history (player_id, season_id, picked_day, option_selected)
VALUES (2, 1, '03/28/2020', 2);