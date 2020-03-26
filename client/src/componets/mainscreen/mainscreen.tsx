import React, { useState, useEffect } from "react";
import { GameButton } from "./buttons/gamebutton";
import { IGameoption } from "../../models/GameOptions";
import { AppInfo } from "../appinfo/appinfo";
import { Rules } from "../rules/rules";

require("./mainscreen.scss");

export interface IMainScreenProps {
    user: string;
    intdata: Array<IGameoption>;
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
        } else {
            const dataCopy: Array<IGameoption> = []
            for (var index = 0; index < data.length; index++) {
                //remove already chosen
                if (data[index].isSelected) {
                    data[index].isSelected = false
                }
                if (data[index].id == id) {
                    data[index].isSelected = !data[index].isSelected
                }    
                dataCopy.push(data[index])
                setData(dataCopy)
            }
        }
    }

    const getOptions = (): JSX.Element[] | JSX.Element =>  {
        return data.map((option: IGameoption, index: number)=>{   
            return (<GameButton text={option.text} isSelected={option.isSelected} id={option.id} handleChange={handleChange} key={index} />)
        });   
    }
 
    return (
    <div className="main-screen">
        <div className="main-screen-wrapper">
                <AppInfo loggedIn={props.user} userspoints={30} />
                {getOptions()} 
                <p className="hint">* The current leader chose <b>option 3</b> for today's selection.</p>
        </div>
    </div>
);
    
};