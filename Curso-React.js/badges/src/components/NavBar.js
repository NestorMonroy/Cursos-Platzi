import React, { Component } from "react";
import { Link } from "react-router-dom";
import logo from "../images/logo.svg";
import "./styles/Navbar.css";

class Navbar extends Component {
  render() {
    return (
      <div className="Navbar">
        <div className="container-fluid">
          <Link className="Navbar__brand" to="/">
            <img className="Navbar__logo" src={logo} alt="Logo" />
            <span className="font-weight-light">Nestor</span>
            <span className="font-weight-bold">Conf</span>
          </Link>
        </div>
      </div>
    );
  }
}

export default Navbar;