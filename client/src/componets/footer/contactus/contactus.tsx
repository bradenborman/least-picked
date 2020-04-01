import React, { useState } from "react";

require("./contactus.scss");

export interface IContactProps {}

export const Contact: React.FC<IContactProps> = (
  props: IContactProps
) => {

    return (
    <div className="contact-us-wrapper">
         <h1 id="contact-us">Contact Us</h1>
          <ul>
                  <li>By email: bradenborman@hotmail.com</li>
                  <li>By phone: (573) 826-1903</li>
          </ul>
    </div>
  );

};