import { IGameoption } from "../GameOptions";

export interface AppDataResponse {
  userEmail: string;
  userName: string;
  options: Array<IGameoption>;
  userScore: number;
  usersFirstTime: boolean;
  activeOption: number;
}
