import React from "react";

require("./app.scss");

export interface IAppProps {}

export const App: React.FC<IAppProps> = (
  props: IAppProps
) => {

  return (
      <div>
          Test
      </div>
  );
};
