import React, { Component } from "react";
import confLogo from "../images/badge-header.svg";

import './styles/Badge.css'

class Badge extends Component {
  render() {
    return (
      <div className='Badge'>
        <div className='Badge__header'>
          <img src={confLogo} alt="logo" />
        </div>
        <div className='Badge__section-name' >
          <img className='Badge__avatar' src="https://www.gravatar.com/avatar?d=identicon" alt="Avatar" />
          <h1>
            Nestor <br /> Monroy{" "}
          </h1>
        </div>
        <div className='Badge__section-info' >
          <h3>Frontend</h3>
          <div>@NestorMonroy</div>
        </div>
        <div className='Badge__footer' >#platziConfi</div>
      </div>
    );
  }
}

export default Badge;
