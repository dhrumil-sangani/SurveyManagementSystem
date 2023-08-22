import React from 'react'
import { Link } from 'react-router-dom'

const Sidebar = () => {
  return (
    <aside id="sidebar" className="sidebar">
      <ul className="sidebar-nav" id="sidebar-nav">
          <li className="nav-item">
            <Link className="nav-link" to="dashboard">
              <i className="bi bi-grid"></i>
              <span>Dashboard</span>
            </Link>
          </li>

          <li className="nav-item">
            <Link className="nav-link" to="organization">
              <i className="bi bi-grid"></i>
              <span>Organization</span>
            </Link>
          </li>
      </ul>
    </aside>
  )
}

export default Sidebar