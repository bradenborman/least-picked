import React from "react";
import { Clipboard } from "../clipboard/clipboard";

require("./leaderboard.scss");

export interface ILeaderboardProps {}

export const Leaderboard: React.FC<ILeaderboardProps> = (
  props: ILeaderboardProps
) => {
  const names: Array<string> = [
    "Bront Thoenen",
    "Cory Loeffelman",
    "Cori Mead",
    "Jacob Meller",
    "Ken Little",
    "Rob Rush",
    "Pat Steuber",
    "So Crates",
    "Richard Hawkins",
    "Braden Borman"
  ];

  const getDots = (length: number) => {
    if (length > 17) return <span>..........................................</span>;
      return <span>....................................................</span>;
  };

  const createLeaderboardRows = (): JSX.Element[] | JSX.Element => {
    return names.map((option: string, index: number) => {
      return (
        <p className="score">
          {index + 1}) {option}
          {getDots(option.length)}
          <span className="score">29</span>
        </p>
      );
    });
  };

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
