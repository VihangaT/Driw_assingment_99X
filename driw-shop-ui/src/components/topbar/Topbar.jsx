import React from "react";
import "./topbar.css";
import { Link } from "react-router-dom";

export default function Topbar() {
  return (
    <div className="topbar">
      <div className="topbarWrapper">
        <div className="topLeft">
        <Link to="/" className="link">
        <span className="logo">DRIW</span>
        </Link>

        </div>
        <div className="topRight">
          <div className="topbarIconContainer">
          <Link to="/" className="link">
          <span className="title">Catelog</span>  
          </Link>
        
          </div>
          <div className="topbarIconContainer">
          <Link to="/calculator" className="link">
          <span className="title">Price Calculator</span>
          </Link>

          </div>
        </div>
      </div>
    </div>
  );
}
