import React from "react";

require("./pencil.scss");

export interface IPencilProps {
  pencilTxt: string;
}

export const Pencil: React.FC<IPencilProps> = (props: IPencilProps) => {
  return (
    <div className="pencil">
      <div className="top"></div>
      <div className="left"></div>
      <div className="center">
        <span className="pencilTxt">{props.pencilTxt}</span>
      </div>
      <div className="right"></div>
      <div className="bottom"></div>
    </div>
  );
};
