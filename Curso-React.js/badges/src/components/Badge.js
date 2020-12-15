import React, { Component } from "react";
import Gravatar from './Gravatar'
import confLogo from "../images/badge-header.svg";

import "./styles/Badge.css";

class Badge extends Component {
  render() {
    const { firstName, lastName, jotTitle, twitter, avatarUrl } = this.props;
    return (
      <div className="Badge">
        <div className="Badge__header">
          <img src={confLogo} alt="logo" />
        </div>
        <div className="Badge__section-name">
          <Gravatar
            className="Badge__avatar"
            email={this.props.email}
            alt="Avatar"
          />
          <h1>
            {firstName} <br /> {lastName}{" "}
          </h1>
        </div>
        <div className="Badge__section-info">
          <h3>{jotTitle} </h3>
          <div>@{twitter} </div>
        </div>
        <div className="Badge__footer">#platziConfi</div>
      </div>
    );
  }
}

export default Badge;
