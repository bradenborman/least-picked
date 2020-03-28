create table players
(
   player_id int NOT NULL AUTO_INCREMENT,
   email varchar(75) not null,
   primary key(player_id)
);

--Add start date to season maybe?

create table season
(
    season_id int NOT NULL AUTO_INCREMENT,
    season_name varchar(30) not null,
    primary key(season_id)
);

create table pick_history
(
    pick_id int NOT NULL AUTO_INCREMENT,
    player_id int NOT NULL,
    season_id int NOT NULL,
    picked_day varchar(10) NOT NULL,
    option_selected int NOT NULL,
    primary key(pick_id),
    is_graded boolean DEFAULT false,
    is_point boolean DEFAULT false,
    FOREIGN KEY (player_id) REFERENCES players(player_id),
    FOREIGN KEY (season_id) REFERENCES season(season_id)
);

create table game_settings
(
    game_id int NOT NULL AUTO_INCREMENT,
    active_season int NOT NULL,
    primary key(game_id),
    FOREIGN KEY (active_season) REFERENCES season(season_id)
);