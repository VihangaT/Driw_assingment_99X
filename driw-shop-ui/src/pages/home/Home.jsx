import React from "react";
import "./Home.css";
import { useEffect, useState } from "react";
import axios from "axios";
import Productcard from "../../components/productCard/ProductCard";

const Home = () => {
  const [products, setProducts] = useState([]);
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
  return (
    <div className="container">
          {products.map((product) => (
            <Productcard key={product.productId} productId={product.productId} productName={product.productName} cartonPrice={product.cartonPrice} />
          ))}      
    </div>
  );
};

export default Home;
