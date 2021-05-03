import React from "react";
import PropTypes from "prop-types";
import { Content, Footer } from "../styles/components";

import Header from "./header";

const Layout = ({ children }) => (
  <>
    <Header />
    <Content>
      <main>{children}</main>
      <Footer>
        © {new Date().getFullYear()} ♥︎ por
        <a href="#">Nestor</a>
      </Footer>
    </Content>
  </>
);
Layout.propTypes = {
  children: PropTypes.node.isRequired,
};

export default Layout;
