import React from "react";
import { AppDataResponse } from "../../models/responses/appdata";
require("./appinfo.scss");

export interface IAppInfoProps {
  appdata?: AppDataResponse;
}

export const AppInfo: React.FC<IAppInfoProps> = (props: IAppInfoProps) => {
  return (
    <div className="app-info">
      <p>
        <span className="detail">User logged in:</span>{" "}
        {props.appdata?.userName}
      </p>
      <p>
        <span className="detail">My Season's score: </span>{" "}
        {props.appdata?.userScore}
      </p>
    </div>
  );
};
