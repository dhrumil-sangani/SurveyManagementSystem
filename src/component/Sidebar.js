import React from "react";
import { Link } from "react-router-dom";

const Sidebar = () => {
  return (
    <aside id="sidebar" className="sidebar">
      <ul className="sidebar-nav" id="sidebar-nav">
        <li className="nav-item">
          <Link className="nav-link collapsed" to="dashboard">
            <i className="bi bi-grid"></i>
            <span>Dashboard</span>
          </Link>
        </li>

        <li className="nav-item">
          <Link className="nav-link " to="organization">
            <i className="bi bi-grid"></i>
            <span>Organization</span>
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link " to="user">
            <i className="bi bi-grid"></i>
            <span>User Management</span>
          </Link>
        </li>
        <li className="nav-item">
          <Link className="nav-link " to="surveyForm">
            <i className="bi bi-grid"></i>
            <span>Survey Form</span>
          </Link>
        </li>
      </ul>
    </aside>
  );
};

export default Sidebar;
