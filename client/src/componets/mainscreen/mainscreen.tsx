import React, { useState, useEffect } from "react";

import { GameButton } from "./buttons/gamebutton";
import { IGameoption } from "../../models/GameOptions";
import { AppInfo } from "../appinfo/appinfo";
import { AppDataResponse } from "../../models/responses/appdata";
import axios from "axios";
import { SeasonDetails } from "./seasondetails/seasondetails";
import { Checkmark } from "../misc/checkmark/checkmark";

require("./mainscreen.scss");

export interface IMainScreenProps {
  appdata?: AppDataResponse;
}

export const MainScreen: React.FC<IMainScreenProps> = (
  props: IMainScreenProps
) => {
  const [data, setData] = useState<Array<IGameoption> | undefined>(
    props.appdata?.options
  );

  const [hasPicked, setHasPicked] = useState<boolean>(false);
  const [activeId, setActiveId] = useState<number | undefined>(
    props.appdata?.activeOption
  );
  const [prevActive, setPrevActive] = useState<number | undefined>(
    props.appdata?.activeOption
  );

  const [showFeedback, setShowFeedback] = useState<boolean>(false);

  useEffect(() => {
    hangleSetDataAfterChangedPage();
  }, []);

  useEffect(() => {
    if (activeId != null && prevActive != null && activeId != prevActive) {
      updateSelection();
    }
  }, [activeId]);

  const updateSelection = async () => {
    try {
      const res: any = await axios.post(`/api/updateSelected`, {
        userEmail: props.appdata?.userEmail,
        newSelected: activeId
      });
      console.log(res);
      setShowFeedback(true);
    } catch (err) {
      console.error(err);
    }
  };

  const hangleSetDataAfterChangedPage = (): void => {
    if (data != null)
      for (var index = 0; index < data.length; index++) {
        if (data[index].selected) {
          setActiveId(index + 1);
          setPrevActive(index + 1);
          setHasPicked(true);
        }
      }
  };

  const handleChange = (id: number) => {
    setShowFeedback(false); //clear out incase clicks stack
    if (data != null) {
      setPrevActive(activeId);
      setActiveId(id);

      if (!hasPicked) {
        const dataCopy: Array<IGameoption> = [];
        for (var index = 0; index < data.length; index++) {
          if (data[index].id == id) {
            data[index].selected = !data[index].selected;
          }
          dataCopy.push(data[index]);
        }
        setHasPicked(true);
        setData(dataCopy);
      } else {
        const dataCopy: Array<IGameoption> = [];
        for (var index = 0; index < data.length; index++) {
          //remove already chosen
          if (data[index].selected) {
            data[index].selected = false;
          }
          if (data[index].id == id) {
            data[index].selected = !data[index].selected;
          }
          dataCopy.push(data[index]);
          setData(dataCopy);
        }
      }
    }
  };

  const statusUpdater = (): JSX.Element | null => {
    if (showFeedback && hasPicked)
      return (
        <div className="statusUpdater-wrapper">
          <Checkmark />
        </div>
      );

    return null;
  };

  const getOptions = (): JSX.Element[] | JSX.Element | null => {
    if (data != null) {
      return data.map((option: IGameoption, index: number) => {
        console.log("option");
        console.log(option);
        return (
          <GameButton
            text={option.text}
            isSelected={option.selected}
            id={option.id}
            handleChange={handleChange}
            key={index}
          />
        );
      });
    }
    return null;
  };

  return (
    <div className="main-screen">
      <div className="main-screen-wrapper">
        {props.appdata?.usersFirstTime ? (
          <p className="firstTimeTag">Welcome to the game</p>
        ) : null}
        {statusUpdater()}
        <AppInfo appdata={props.appdata} />
        {getOptions()}
        <p className="hint">
          * The current leader chose <b>option 3</b> for today's selection.
        </p>
      </div>
    </div>
  );
};
