import React from "react";

require("./seasondetails.scss");

export interface ISeasonDetailsProps {
  daysTilNextSeason?: number;
  currentSeason?: string;
}

export const SeasonDetails: React.FC<ISeasonDetailsProps> = (
  props: ISeasonDetailsProps
) => {

  return (
    <div className="season-details">
      <p><span>{props.currentSeason}</span> | <span> {props.daysTilNextSeason} days until next season.</span></p>
    </div>
    );
    
};