import { IGameoption } from "../GameOptions";

export interface AppDataResponse {
    userEmail: string;
    options: Array<IGameoption>
}