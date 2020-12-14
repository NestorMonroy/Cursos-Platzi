import React, { Component } from "react";
import logo from "../images/logo.svg";
import "./styles/Navbar.css";

class Navbar extends Component {
  render() {
    return (
      <div className="Navbar">
        <div className="container-fluid">
          <a className="Navbar__brand" href="/">
            <img className="Navbar__logo" src={logo} alt="Logo" />
            <span className="font-weight-light">Nestor</span>
            <span className="font-weight-bold">Conf</span>
          </a>
        </div>
      </div>
    );
  }
}

export default Navbar;
