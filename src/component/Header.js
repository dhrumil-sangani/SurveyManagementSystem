import React, { useContext, useState, useEffect } from "react";
import {DropdownButton ,Dropdown ,ButtonGroup} from 'react-bootstrap';
import { useNavigate } from "react-router-dom";
import swal from "sweetalert";
import { UserContext } from "../App";

function Header() {

    const { state, dispatch } = useContext(UserContext);
    const navigate = useNavigate();

    const [userName,setUserName] = useState("");

    const logout = () => {
        swal({
            title: "Are you sure, You want to Logout?",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
        .then(async(willDelete) => {
            if (willDelete) {
                dispatch({ type: "USER", payload: null });
                localStorage.clear();
                navigate("/");
            } 
        });
    }

    return (
        <header id="header" className="header fixed-top d-flex align-items-center">
            <div className="d-flex align-items-center justify-content-between">
                <a href="index.html" className="logo d-flex align-items-center">
                    <img src="assets/img/logo.png" alt="" />
                    <span className="d-none d-lg-block">Survey Management </span>
                </a>
                <i className="bi bi-list toggle-sidebar-btn"></i>
            </div>

            <nav className="header-nav ms-auto">
                <ul className="d-flex align-items-center">
                    <li className="nav-item d-block d-lg-none">
                        <a className="nav-link nav-icon search-bar-toggle " href="asdsa">
                            <i className="bi bi-search"></i>
                        </a>
                    </li>

                    <DropdownButton id="dropdown-basic-button" title={state.userName}>
                        <Dropdown.Item eventKey="1" onClick={logout}>Logout</Dropdown.Item>
                        <Dropdown.Item eventKey="1" onClick={()=>navigate("/change-password")}>Change Password</Dropdown.Item>
                    </DropdownButton>

                    {/* <li className="nav-item dropdown pe-3">
                        <a
                            className="nav-link nav-profile d-flex align-items-center pe-0"
                            href="asd"
                            data-bs-toggle="dropdown"
                        >
                        <img
                            src="assets/img/profile-img.jpg"
                            alt="Profile"
                            className="rounded-circle"
                        />
                        <span className="d-none d-md-block dropdown-toggle ps-2">
                            K. Anderson
                        </span>
                        </a>

                        <ul className="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                            <li className="dropdown-header">
                                <h6>Kevin Anderson</h6>
                                <span>Web Designer</span>
                            </li>
                            <li>
                                <hr className="dropdown-divider" />
                            </li>

                            <li>
                                <a
                                className="dropdown-item d-flex align-items-center"
                                href="users-profile.html"
                                >
                                <i className="bi bi-person"></i>
                                <span>My Profile</span>
                                </a>
                            </li>
                        <li>
                            <hr className="dropdown-divider" />
                        </li>

                        <li>
                            <a
                            className="dropdown-item d-flex align-items-center"
                            href="users-profile.html"
                            >
                            <i className="bi bi-gear"></i>
                            <span>Account Settings</span>
                            </a>
                        </li>
                        <li>
                            <hr className="dropdown-divider" />
                        </li>

                        <li>
                            <a
                            className="dropdown-item d-flex align-items-center"
                            href="pages-faq.html"
                            >
                            <i className="bi bi-question-circle"></i>
                            <span>Need Help?</span>
                            </a>
                        </li>
                        <li>
                            <hr className="dropdown-divider" />
                        </li>

                        <li>
                            <a
                            className="dropdown-item d-flex align-items-center"
                            href="asd"
                            >
                            <i className="bi bi-box-arrow-right"></i>
                            <span>Sign Out</span>
                            </a>
                        </li>
                        </ul>
                    </li> */}
                </ul>
            </nav>
        </header>
    );
}

export default Header;
