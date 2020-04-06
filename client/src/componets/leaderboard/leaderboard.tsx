import React, {useEffect, useState} from "react";
import { Clipboard } from "../clipboard/clipboard";
import { LeaderboardRow, LeaderboardResponse } from "../../models/responses/leaderboardreponse";
import axios from "axios";

require("./leaderboard.scss");

export interface ILeaderboardProps {}

export const Leaderboard: React.FC<ILeaderboardProps> = (
  props: ILeaderboardProps
) => {

  const [leaderboardData, setLeaderboardData] = useState<LeaderboardResponse>();
  const [fetching, setFetching] = useState<boolean>(true);
  const [fetchError, setFetchError] = useState<boolean>(false);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const res: any = await axios.get(`/api/leaders`);
      setFetching(false);
      setLeaderboardData(res.data);
      setFetchError(false);
    } catch (err) {
      console.error(err);
      setFetching(false);
      setFetchError(true);
    }
  };

  const getDots = (length: number) => {
    if (length > 17) return <span>..........................................</span>;
      return <span>....................................................</span>;
  };

  const createClipbaordHeadersAndLeaderboardRows = (): JSX.Element[] | JSX.Element | null => {      
    if (leaderboardData != null) {
      
      const rows = leaderboardData.topTenLeaders.map((leaderboardrow: LeaderboardRow, index: number) => {
        return (
          <p className="score">
            {leaderboardrow.rank}) {leaderboardrow.name}
            {getDots(leaderboardrow.name.length)}
            <span className="score">{leaderboardrow.score}</span>
          </p>
        );
      });

      const header = (
        <div className="seasonDetails">
          <span className="seasonNickname">"{leaderboardData.activeSeason.nickName}"</span>
          <div className="seasonRange">Season Range<br />{leaderboardData.activeSeason.startDate} - {leaderboardData.activeSeason.endDate}</div>
          <p className="daysLeft">           
            {leaderboardData.daysLeftInActiveSeason == 1 ? " Last day of the season!" : leaderboardData.daysLeftInActiveSeason + " days left." } 
          </p>
        </div>
      )
 
      return ( 
        <div>
          {header}
          {rows}
        </div>      
      )
    }


    return null;
  };


  const getLoadings = () => {
    return (
     <div className="spinner">
      <div className="spinner-a"></div>
      <div className="spinner-b"></div>
    </div>
    )
  }


  const getClipBoardContents = (): JSX.Element[] | JSX.Element | null => {
    if (leaderboardData != null)   
    {
      return createClipbaordHeadersAndLeaderboardRows()
    }
    else if(fetching)
      return getLoadings()
    else if(fetchError)
      return <p>Error Loading Data....</p>
    return null;
  }

  return (
    <div className="leaderboard">
      <Clipboard
        clipboardTitle="Leaderboard"
        pencilTxt="Least Picked Challenge"
      >
        <div className="scores">{getClipBoardContents()}</div>
      </Clipboard>
    </div>
  );
};
