import React from "react";
require("./appinfo.scss");

export interface IAppInfoProps {
    loggedIn: string;
    userspoints: number;
}

export const AppInfo: React.FC<IAppInfoProps> = (
  props: IAppInfoProps
) => {


  return (
    <div className="app-info">
          <p><span className="detail">User logged in:</span> {props.loggedIn}</p>
          <p><span className="detail">My score: </span> {props.userspoints}</p>
    </div>
  );

};