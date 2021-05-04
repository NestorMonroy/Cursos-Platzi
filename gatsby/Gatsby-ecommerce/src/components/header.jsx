import React from "react";
import { Link } from "gatsby";
import PropTypes from "prop-types";
import { MenuItem, StyledHeader } from "../styles/components";
import { CartContext } from "../Context";

const Header = ({ siteTitle }) => {
  const { cart } = React.useContext(CartContext);

  return (
    <StyledHeader>
      <Link to="/">
        <img
          src="https://i.postimg.cc/6q3pg48v/Logo.png"
          alt="logoplatziswag"
        />
      </Link>
      <nav>
        <ul>
          <MenuItem margin>
            <Link to="/">Productos</Link>
          </MenuItem>
          <MenuItem>
            <Link to="/cart">
              <span>
                <img
                  src="https://i.postimg.cc/L6wpMxLt/cart.png"
                  alt="cartlogo"
                />
              </span>
              {cart.length}
            </Link>
          </MenuItem>
        </ul>
      </nav>
    </StyledHeader>
  );
};

Header.propTypes = {
  siteTitle: PropTypes.string,
};

Header.defaultProps = {
  siteTitle: ``,
};

export default Header;
