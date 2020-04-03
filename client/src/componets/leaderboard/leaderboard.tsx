import React, {useEffect, useState} from "react";
import { Clipboard } from "../clipboard/clipboard";
import { LeaderboardRow } from "../../models/responses/leaderboardrow";
import axios from "axios";

require("./leaderboard.scss");

export interface ILeaderboardProps {}

export const Leaderboard: React.FC<ILeaderboardProps> = (
  props: ILeaderboardProps
) => {

  const [leaderboardData, setLeaderboardData] = useState<Array<LeaderboardRow>>();
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

  const createLeaderboardRows = (): JSX.Element[] | JSX.Element | null => {    
    
    if (leaderboardData != null)   
    return leaderboardData.map((leaderboardrow: LeaderboardRow, index: number) => {
      return (
        <p className="score">
          {leaderboardrow.rank}) {leaderboardrow.name}
          {getDots(leaderboardrow.name.length)}
          <span className="score">{leaderboardrow.score}</span>
        </p>
      );
    });
    else if(fetching)
      return getLoadings()
    else if(fetchError)
      return <p>Error Loading Data....</p>
    

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


  return (
    <div className="leaderboard">
      <Clipboard
        clipboardTitle="Leaderboard"
        pencilTxt="Least Picked Challenge"
      >
        <div className="scores">{createLeaderboardRows()}</div>
      </Clipboard>
    </div>
  );
};
