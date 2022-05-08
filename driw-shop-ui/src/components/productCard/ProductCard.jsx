import React from "react";
import "./ProductCard.css";
import { Link } from "react-router-dom";
const Productcard = (props) => {
  return (
    <div class="container">
      <div class="card">
        <div class="info">
          <h2>{props.productName}</h2>
          <Link to={{
              pathname: "/pricelist/" + props.productId
            }} className="link">
            <button class="btn">Check Price Table</button>
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Productcard;
