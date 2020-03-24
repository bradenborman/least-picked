import React from "react";
import { Paper } from "@material-ui/core";

import rules from '../../constants/rules.json'

require("./rules.scss");

export interface IRulesProps {
   
}

export const Rules: React.FC<IRulesProps> = (
  props: IRulesProps
) => {


  const getGameRules = (): JSX.Element[] => {
    return rules.rules.map((rule: string, index: number) => {
      return (
        <p key={index} className="rules-txt">{rule}</p>
      );
    });
  }
 
  return (
      <div className="rules">
      <Paper className="rules-paper">
        <p className="rules-heading">How to Play</p><hr />
        {getGameRules()}
        </Paper>
    </div>
  );

};