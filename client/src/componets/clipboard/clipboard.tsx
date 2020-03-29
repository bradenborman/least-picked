import React from "react";
import { Pencil } from "./pencil/pencil";

require("./clipboard.scss");

export interface IClipboardProps {
  children: any;
  clipboardTitle: string;
  pencilTxt: string;
}

export const Clipboard: React.FC<IClipboardProps> = (
  props: IClipboardProps
) => {
  return (
    <div>
      <div className="clipboard-header">
        <div className="h2-wrapper">
          <h2>{props.clipboardTitle}</h2>
        </div>
      </div>
      <div className="clipboard">
        {/* <div className="clipboard-divider"></div> */}
        <div className="clipboard-paper">{props.children}</div>
      </div>
      <div className="clipboard-footer">
        <Pencil pencilTxt={props.pencilTxt} />
      </div>
    </div>
  );
};
