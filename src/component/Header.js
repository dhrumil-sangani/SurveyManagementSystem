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

                    <DropdownButton className="profile" title={state.userName}>
                        <Dropdown.Item eventKey="1" onClick={logout}>Logout</Dropdown.Item>
                        <Dropdown.Item eventKey="1" onClick={()=>navigate("/change-password")}>Change Password</Dropdown.Item>
                    </DropdownButton>
                </ul>
            </nav>
        </header>
    );
}

export default Header;
