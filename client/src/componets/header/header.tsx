import React from "react";

require("./header.scss");

export interface IHeaderProps {}

export const Header: React.FC<IHeaderProps> = (
  props: IHeaderProps
) => {


  return (
      <header className="header">
          <div className="header-wrapper">
              Least-Picked Challenge
          </div> 
      </header>
  );

};