
export interface LeaderboardRow {
  
    rank: number;
    name: string;
    score: number;

}

export interface Season {
    startDate: string;
    endDate: string;
    nickName: string;
}

export interface LeaderboardResponse {
  
    topTenLeaders: Array<LeaderboardRow>;
    activeSeason: Season;
    daysLeftInActiveSeason: number;

}
