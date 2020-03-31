import React, { useState } from "react";

require("./about.scss");

export interface IAboutProps {}

export const About: React.FC<IAboutProps> = (
  props: IAboutProps
) => {

    return (
    <div className="about-wrapper">
            ABOUT PLACE HOLDER
    </div>
  );

};