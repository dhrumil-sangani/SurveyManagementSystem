import React, { useEffect, useState } from "react";
import { Link,useLocation } from "react-router-dom";

const Sidebar = () => {

  const [menuClick,setMenuclick] = useState("");

  const location = useLocation();

  useEffect(()=>{
    setMenuclick(location.pathname)
  },[location])

  return (
    <aside id="sidebar" className="sidebar">
      <ul className="sidebar-nav" id="sidebar-nav">
        <li className="nav-item">
          <Link className={`nav-link ${menuClick !== "/dashboard" && "collapsed" }`} to="dashboard" onClick={()=>setMenuclick("dashboard")}>
            <i className="bi bi-grid"></i>
            <span>Dashboard</span>
          </Link>
        </li>

        <li className="nav-item">
          <Link className={`nav-link ${menuClick !== "/organization" && "collapsed" }`} to="organization" onClick={()=>setMenuclick("organization")}>
            <i className="bi bi-grid"></i>
            <span>Organization</span>
          </Link>
        </li>
        <li className="nav-item">
          <Link className={`nav-link ${menuClick !== "/user" && "collapsed" }`} to="user" onClick={()=>setMenuclick("user")}>
            <i className="bi bi-grid"></i>
            <span>User Management</span>
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link collapsed" to="surveyForm">
            <i className="bi bi-grid"></i>
            <span>Survey Form</span>
          </Link>
        </li>
      </ul>
    </aside>
  );
};

export default Sidebar;
