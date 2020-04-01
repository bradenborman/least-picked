import React from "react";

require("./footer.scss");

export interface IFooterProps {}

export const Footer: React.FC<IFooterProps> = (
  props: IFooterProps
) => {

const preventDefault = (event: any) => event.preventDefault();

    return (
    <footer className="site-footer">
        <div className="container">
            <div className="row">
            <div className="col-sm-12 col-md-7">
                <h6>About</h6>
                        <p className="text-justify">
                            Least-Picked Challenge <i>is the most simple</i> game you can ever wish to play. 
                            Winners must be 18 years or older to win a prize. Accounts verified by Facebook.
                            Seasons are predetermined by creator. Rules are subject to change.
                
                </p>
            </div>
            <div className="col-xs-6 col-md-5">
                <h6>Quick Links</h6>
                <ul className="footer-links">
                <li><a href="/about">About Us</a></li>
                <li><a href="/contact">Contact Us</a></li>
                <li><a href="/privacy-policy">Privacy Policy</a></li>
                </ul>
            </div>
            </div>
            <hr />
        </div>
        <div className="container">
            <div className="row">
            <div className="col-md-8 col-sm-6 col-xs-12">
                        <p className="copyright-text">
                            Copyright &copy; Braden Borman Production   2020   
                        </p> 
            </div>
            <div className="col-md-4 col-sm-6 col-xs-12">
                <ul className="social-icons">
                <li><a className="facebook" href="https://www.facebook.com/bradenborman"><i className="fa fa-facebook"></i></a></li>
                <li><a className="twitter" href="https://twitter.com/middle_Borman"><i className="fa fa-twitter"></i></a></li>
                {/* <li><a className="dribbble" href="#"><i className="fa fa-dribbble"></i></a></li> */}
                <li><a className="linkedin" href="https://www.linkedin.com/in/bradyborman/"><i className="fa fa-linkedin"></i></a></li>   
                </ul>
            </div>
            </div>
        </div>
    </footer>
  );

};