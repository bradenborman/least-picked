import React from "react";

require("./gamebutton.scss");

export interface IGameButtonProps {
  id: number
  text: string;
  isSelected: boolean;
  handleChange: (id: number) => void
}

export const GameButton: React.FC<IGameButtonProps> = (
  props: IGameButtonProps
) => {

  const handleClick = () => {
    props.handleChange(props.id)
  }

  return (
    <div className="button" onClick={handleClick}>
        <div className={props.isSelected  ? "secondary-text-selected" : "secondary-text"}>SELECTED</div>
        <p className={props.isSelected ? "a-selected" : "a"}>{props.text}</p>
    </div>
    );
    
};