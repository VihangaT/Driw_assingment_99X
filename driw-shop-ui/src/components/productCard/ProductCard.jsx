import React from "react";
import "./ProductCard.css";

const Productcard = (props) => {
  return (
<div class="container">
	<div class="card">
		<div class="info">
			<h2>{props.productName}</h2>
			<button class="btn">Check Price Table</button>
		</div>
	</div>
</div>



  );
};

export default Productcard;
