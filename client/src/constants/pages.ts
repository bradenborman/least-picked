import { useLocation } from "react-router";

export interface AppView {
    index: number;
    url: string;
    name: string;
  }
  
  export const AppViews: AppView[] = [
    {
      index: 0,
      url: "play",
      name: "Play"    
    },
    {
      index: 1,
      url: "leaderboard",
      name: "Leaderboard"
    },
    {
      index: 2,
      url: "rules",
      name: "Rules"
    }
];
  

export const getActivePage = (): AppView => {
    
    const location: any = useLocation();
   
    const path: string = location.pathname.substring(1);
   
  const page: AppView | undefined = AppViews.find(
      (appview: AppView) => appview.url === path
    );
  
    if (page !== undefined) {
      return page;
    }
  
    return AppViews[0];
  };