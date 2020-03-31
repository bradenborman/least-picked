import React, { useState } from "react";
import { Link } from "react-router-dom";
import { Tabs, Tab } from "@material-ui/core";
import { AppView, AppViews, getActivePage } from "../../constants/pages";

require("./header.scss");

export interface IHeaderProps {}

export const Header: React.FC<IHeaderProps> = (
  props: IHeaderProps
) => {

  const [activeIndex, setActiveIndex] = useState<number>(
    getActivePage().index
  );

  const handleChange = (e: any, newIndex: number) => {
    setActiveIndex(newIndex);
  };

  const getTabs = (): JSX.Element[] => {
    return AppViews.map((page: AppView) => {
      return (
        <Tab key={page.name} label={page.name} component={Link} to={page.url} />
      );
    });
  };

  return (
    <div>
      <header className="header">
          <div className="header-wrapper">
        Least-Picked Challenge
          </div>      
      </header>
      <nav>
    <Tabs
        value={activeIndex}
        centered
        indicatorColor="primary"
        textColor="primary"
        onChange={(e, v) => handleChange(e, v)}
      >
        {getTabs()}
        </Tabs>
      </nav>
    </div>
  );

};