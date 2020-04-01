import React, { useState } from "react";

require("./contactus.scss");

export interface IContactProps {}

export const Contact: React.FC<IContactProps> = (
  props: IContactProps
) => {

    return (
    <div className="contact-us-wrapper">
         <h1 id="contact-us">Contact Us</h1>
          <p>If you have any questions about this Privacy Policy, You can contact us:</p>
          <ul>
                  <li>By email: bradenborman@hotmail.com</li>
          </ul>  
    </div>
  );

};