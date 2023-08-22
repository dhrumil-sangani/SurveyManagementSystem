import React from 'react'
import { Route, Routes } from "react-router-dom";
import Login from './pages/Login';
import Dashboard from './pages/Dashboard';
import Organization from './pages/Organization';

const AppRoutes = () => {
  return (
    <Routes>
        <Route exact path="/" element={<Login />} />
        <Route exact path="/dashboard" element={<Dashboard />}></Route>
        <Route exact path="/organization" element={<Organization />}></Route>
        <Route exact path="/login" element={<Login />}></Route>
    </Routes>
  )
}

export default AppRoutes