import React, { useState, useEffect } from "react";

import { GameButton } from "./buttons/gamebutton";
import { IGameoption } from "../../models/GameOptions";
import { AppInfo } from "../appinfo/appinfo";
import { AppDataResponse } from "../../models/responses/appdata";

require("./mainscreen.scss");

export interface IMainScreenProps {
    appdata?: AppDataResponse;
}

export const MainScreen: React.FC<IMainScreenProps> = (
    props: IMainScreenProps
) => {

    const [data, setData] = useState<Array<IGameoption> | undefined>(props.appdata?.options)
    const [hasPicked, setHasPicked] = useState<boolean>(false)


    useEffect(() => {
        hangleSetDataAfterChangedPage()
    }, []);

    
    const hangleSetDataAfterChangedPage = (): void => {
        if(data != null)
            for (var index = 0; index < data.length; index++) {
                if (data[index].selected) {
                    setHasPicked(true)
                }
            }
    }
    
    const handleChange = (id: number) => {
        if (data != null) {
            if (!hasPicked) {
                const dataCopy: Array<IGameoption> = []
                for (var index = 0; index < data.length; index++) {
                    if (data[index].id == id) {
                        data[index].selected = !data[index].selected
                    }
                    dataCopy.push(data[index])
                }
                setHasPicked(true)
                setData(dataCopy)
            } else {
                const dataCopy: Array<IGameoption> = []
                for (var index = 0; index < data.length; index++) {
                    //remove already chosen
                    if (data[index].selected) {
                        data[index].selected = false
                    }
                    if (data[index].id == id) {
                        data[index].selected = !data[index].selected
                    }
                    dataCopy.push(data[index])
                    setData(dataCopy)
                }
            }
        }
    }

    const getOptions = (): JSX.Element[] | JSX.Element | null => {
        if (data != null) {
            return data.map((option: IGameoption, index: number) => {
                console.log("option")
                console.log(option)
                return (<GameButton text={option.text} isSelected={option.selected} id={option.id} handleChange={handleChange} key={index} />)
            });
        }
        return null
    }
 
    return (      
    <div className="main-screen">
            <div className="main-screen-wrapper">
                <AppInfo loggedIn={props.appdata?.userEmail} userspoints={30} />
                {getOptions()} 
                <p className="hint">* The current leader chose <b>option 3</b> for today's selection.</p>
        </div>
    </div>
);
        
};