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
    return rules.howToPlay.map((rule: string, index: number) => {
      return (
        <p key={index} className="rules-txt">{rule}</p>
      );
    });
  }

  const getSloppyRules = (): JSX.Element[] => {
    return rules["contest-rules"].map((rule: string, index: number) => {
      const parsedRule = rule.split(":");
      return (
        <p key={index} className="context-rules"><span className="rule-header">{parsedRule[0]}:</span>{parsedRule[1]}</p>
      );
    });
  }
 
  return (
      <div className="rules">
      <Paper className="rules-paper">
        <p className="rules-heading">How to Play</p><hr />
        {getGameRules()}
      </Paper>
      <Paper className="sloppy-rules">
        <h2>Contest Rules:</h2>
        {getSloppyRules()}
      </Paper>
    </div>
  );

};