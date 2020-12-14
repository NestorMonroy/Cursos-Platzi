import React, { Component } from "react";
import confLogo from "../images/badge-header.svg";

class Badge extends Component {
  render() {
    return (
      <div>
        <div>
          <img src={confLogo} alt="logo" />
        </div>
        <div>
          <img src="https://www.gravatar.com/avatar?d=identicon" alt="Avatar" />
          <h1>
            Nestor <br /> Monroy{" "}
          </h1>
        </div>
        <div>
          <p>Frontend</p>
        </div>
        <div>#platziConfi</div>
      </div>
    );
  }
}

export default Badge;
