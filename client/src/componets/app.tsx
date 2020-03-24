import React, { useState } from "react";
import {
  BrowserRouter as ReactRouter,
  Route as ReactRoute
} from "react-router-dom";

import { MainScreen } from "./mainscreen/mainscreen";
import { IGameoption } from "../models/GameOptions";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Header } from "./header/header";
import { Rules } from "./rules/rules";


require("./app.scss");

export interface IAppProps {}

export const App: React.FC<IAppProps> = (
  props: IAppProps
) => {


  const initData: Array<IGameoption> = [
    { id: 1, text: "Option 1", isSelected: false },
    { id: 2, text: "Option 2", isSelected: false },
    { id: 3, text: "Option 3", isSelected: false }
]

  
const getPlayScreen = (): JSX.Element => {
  return <MainScreen intdata={initData} />
};
  
const getRules = (): JSX.Element => {
  return <Rules />
};
  
  return (    
    <ReactRouter>
        <Header />
        <ReactRoute
          exact
          path={["/", "/play"]}
          component={getPlayScreen} />       
        <ReactRoute path="/rules" component={getRules} />
    </ReactRouter>
  );

};