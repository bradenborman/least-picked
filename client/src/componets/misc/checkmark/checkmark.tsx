import React from "react";

require("./checkmark.scss");

export interface ICheckmarkProps {
  pxSize?: string;
}

export const Checkmark: React.FC<ICheckmarkProps> = (
  props: ICheckmarkProps
) => {
  const checkmark_stlye = {
    width: props.pxSize != null ? props.pxSize : "50px",
    height: props.pxSize != null ? props.pxSize : "50px"
  };

  /*
    NOTE: This child element is incharge of hiding its self. Made it this way because if on parent use settime 
    - when clicks are stacked, set timeout will clear the later clicked 
*/

  return (
    <div className="checkmark-wrapper">
      <svg
        className="checkmark"
        style={checkmark_stlye}
        xmlns="http://www.w3.org/2000/svg"
        viewBox="0 0 52 52"
      >
        <circle
          className="checkmark__circle"
          cx="26"
          cy="26"
          r="25"
          fill="none"
        />
        <path
          className="checkmark__check"
          fill="none"
          d="M14.1 27.2l7.1 7.2 16.7-16.8"
        />
      </svg>
    </div>
  );
};
