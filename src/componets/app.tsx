import React from "react";
import { MainScreen } from "./mainscreen/mainscreen";
import { IGameoption } from "../models/GameOptions";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Header } from "./header/header";


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

  return (
    <div>
      <Header />
      <MainScreen intdata={initData} />
    </div>
  );

};