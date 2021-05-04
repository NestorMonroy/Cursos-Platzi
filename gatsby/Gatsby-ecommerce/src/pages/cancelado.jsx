import React from "react";
import { SEO } from "../components";
import { Button, Purchase } from "../styles/components";
import { Link } from "gatsby";

export default function gracias() {
  return (
    <div>
      <SEO title="Compra Cancelada" />
      <Purchase>
        <h2>Cancelacion</h2>
        <span role="img" aria-label="emoji">
          :(
        </span>
        <Link to="/">
          <Button>Volver al Catálogo</Button>
        </Link>
      </Purchase>
    </div>
  );
}
