import React from "react";

require("./clipboard.scss");

export interface IClipboardProps {
    children: any;
}

export const Clipboard: React.FC<IClipboardProps> = (
  props: IClipboardProps
) => {

  return (
    <div>
      <div className="clipboard-header">
        <div className="h2-wrapper">
            <h2>Leaderboard</h2>
        </div>
      </div>    
      <div className="clipboard">
      {/* <div className="clipboard-divider"></div> */}
        <div className="clipboard-paper">
          {props.children}
          </div>
      </div>
      <div className="clipboard-footer"></div>
      </div>
    );
    
};