import React, { useState, useEffect } from "react";
import Spinner from 'react-bootstrap/Spinner'

import {
  BrowserRouter as ReactRouter,
  Route as ReactRoute
} from "react-router-dom";

import { MainScreen } from "./mainscreen/mainscreen";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Header } from "./header/header";
import { Rules } from "./rules/rules";
import { AppDataResponse } from "../models/responses/appdata";


require("./app.scss");

export interface IAppProps {}

export const App: React.FC<IAppProps> = (
  props: IAppProps
) => {

  const
    [appData, setAppData] = useState<AppDataResponse>(),
    [fetching, setFetching] = useState<boolean>(true),
    [fetchError, setFetchError] = useState<boolean>(false);
  
useEffect(() => {
  fetchData();
}, []);
  
  
const fetchData = async () => {
  setFetching(true);
  try {
      const res: any = await axios.get(
        `/api/user`
      );

    setFetching(false);
    setAppData(res.data);
    setFetchError(false);
  } catch (err) {
    console.error(err);
    setFetching(false);
    setFetchError(true);
  }
};  
  
const getPlayScreen = (): JSX.Element => {
  return <MainScreen appdata={appData} />
};
  
const getRules = (): JSX.Element => {
  return <Rules />
};
  
  
const handleFetch = (): JSX.Element => {
  if (fetching)
    return <Spinner className="loading" animation="grow" />
  else
    return <p className="error">Error Fetching data</p>
}
  
  return (    
    <div>
      {fetching || fetchError
        ? handleFetch()
        :
      <ReactRouter>
        <Header />
        <ReactRoute
          exact
          path={["/", "/play"]}
          component={getPlayScreen} />       
        <ReactRoute path="/rules" component={getRules} />
    </ReactRouter>
      }
    </div>    
  );
};