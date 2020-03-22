import React, { useState, useEffect } from "react";
import { GameButton } from "./buttons/hbutton";
import { IGameoption } from "../../models/GameOptions";

require("./mainscreen.scss");

export interface IMainScreenProps {
    intdata: Array<IGameoption>
}

export const MainScreen: React.FC<IMainScreenProps> = (
  props: IMainScreenProps
) => {

    const [data, setData] = useState<Array<IGameoption>>(props.intdata)
    const [hasPicked, setHasPicked] = useState<boolean>(false)

    const handleChange = (id: number) => {
        if (!hasPicked) {
            const dataCopy: Array<IGameoption> = []
            for (var index = 0; index < data.length; index++) {
                if (data[index].id == id) {
                    data[index].isSelected = !data[index].isSelected
                }
                dataCopy.push(data[index])
            }
            setHasPicked(true)
            setData(dataCopy)
        }
    }

    const getOptions = (): JSX.Element[] | JSX.Element =>  {
        return data.map((option: IGameoption)=>{   
            return (<GameButton text={option.text} isSelected={option.isSelected} id={option.id} handleChange={handleChange} />)
        });   
    }

    const getHelpText = (): JSX.Element =>  {
        return (
            <div>
                {hasPicked ?
                    <p>Thank you for playing. You have already selcted today.</p> //<br />You may change.
                    :
                    <p>Please Select an option for the day.</p>
                }
            </div>
        )
    }
    

return (
    <div className="main-screen">
        {getOptions()}
        {getHelpText()}
    </div>
);
    
};