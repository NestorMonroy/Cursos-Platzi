import React from "react";
import { Link } from "gatsby";
import { graphql } from "gatsby";
import { SEO, Jumbo } from "../components";

export const query = graphql`
  query GET_DATA {
    allSite {
      edges {
        node {
          siteMetadata {
            description
          }
        }
      }
    }
  }
`;

const IndexPage = ({ data }) => {
  console.log(data);
  return (
    <>
      <SEO title="Home" />
      <Jumbo
        description={data.allSite.edges[0].node.siteMetadata.description}
      />
    </>
  );
};

export default IndexPage;
