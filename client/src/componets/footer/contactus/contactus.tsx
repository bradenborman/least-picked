import React, { useState } from "react";

require("./contactus.scss");

export interface IContactProps {}

export const Contact: React.FC<IContactProps> = (
  props: IContactProps
) => {

    return (
    <div className="contact-us-wrapper">
            Contact us HOLDER
    </div>
  );

};