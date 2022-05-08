import React from "react";
import "./PriceCalculator.css";
import { useEffect, useState } from "react";
import axios from "axios";

const Pricecalculator = () => {
  const [products, setProducts] = useState([]);
  const [price, setPrice] = useState([]);
  useEffect(() => {
    axios
      .get("http://localhost:8080/api/v1/product")
      .then((response) => {
        setProducts(response.data);
        console.log(products);
      })
      .catch((err) => {
        setProducts([]);
        console.error(err);
      });

    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  function handleSubmit(e) {
    e.preventDefault();
    const { productName, noOfCartons, singleUnites } = e.target.elements;


    let product = products.filter(
      (product) => product.productId === parseInt(productName.value)
    );
    let quantity =
      parseInt(noOfCartons.value) * parseInt(product[0].itemsPerCarton) +
      parseInt(singleUnites.value);
    axios
      .get(
        `http://localhost:8080/api/v1/product/${parseInt(
          productName.value
        )}/price?quantity=${quantity}`
      )
      .then((response) => {
        setPrice(response.data);
        console.log(price);
      })
      .catch((err) => {
        setPrice([]);
        console.error(err);
      });
  }
  return (
    <>
      <div className="container">
        <form className="form-inline" onSubmit={handleSubmit} action="POST">
          <select name="productName" id="productName">
            {products.map((product) => (
              // eslint-disable-next-line jsx-a11y/anchor-is-valid
              <option key={product.productId} value={product.productId}>
                {product.productName}
              </option>
            ))}
          </select>
          <input
            type="number"
            id="noOfCartons"
            placeholder="No of Cartons"
            name="noOfCartons"
          ></input>
          <input
            type="number"
            id="singleUnites"
            placeholder="No of Single Unites"
            name="singleUnites"
          ></input>
          <button type="submit">Calculate Price</button>
        </form>
      </div>
      <div class="card">
        <h1>{price.price}</h1>
      </div>
    </>
  );
};

export default Pricecalculator;
