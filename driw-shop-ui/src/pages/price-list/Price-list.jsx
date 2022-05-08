import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import "./Price-list.css"
const PriceList = () => {
  let [rows, setRows] = useState([]);
  const location = useLocation();
  const pathName = location.pathname;
  let parts = pathName.split("/");
  const productId = parts[2];
  useEffect(() => {
    fetch(`http://localhost:8080/api/v1/product/${productId}/price-list`)
      .then((res) => res.json())
      .then((result) => {
        console.log(result);
        setRows(result);
      });
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);
  return (
    <>
      <div className="productList">
        <table>
          <tr className="tableRow">
            <th className="tableHead">Quantity</th>
            <th className="tableHead">Price</th>
          </tr>
          {rows.map((row) => (
            <tr className="tableRow">
              <th className="tableHead">{row.quantity}</th>
              <th className="tableHead">LKR {row.price}</th>
            </tr>
          ))}
        </table>
      </div>
    </>
  );
};

export default PriceList;
