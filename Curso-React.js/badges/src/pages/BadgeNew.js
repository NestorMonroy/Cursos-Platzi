import React, { Component } from "react";
import Navbar from "../components/NavBar";
import header from "../images/badge-header.svg";
import Badge from "../components/Badge";
import "./styles/BadgeNew.css";

class BadgeNew extends Component {
  render() {
    return (
      <div>
        <Navbar />
        <div className="BadgeNew__hero">
          <img className="img-fluid" src={header} alt="Logo" />
        </div>
        <div className="container">
          <div className="row">
            <div className="col">
              <Badge
                firstName="Nestor"
                lastName="Monroy"
                jotTitle="Frontend"
                twitter="NestorMonroy"
                avatarUrl="https://www.gravatar.com/avatar?d=identicon"
              />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default BadgeNew;
