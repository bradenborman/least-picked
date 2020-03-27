import React from "react";

require("./leaderboard.scss");

export interface ILeaderboardProps {

}

export const Leaderboard: React.FC<ILeaderboardProps> = (
  props: ILeaderboardProps
) => {

  return (
    <div>
      <div className="leader-board-header">
        <div className="h2-wrapper">
            <h2>Leaderboard</h2>
        </div>
      </div>    
      <div className="clipboard">
      <div className="clipboard-divider"></div>
        <div className="clipboard-paper">
          
          </div>
      </div>
      <div className="clipboard-footer"></div>
      </div>
    );
    
};