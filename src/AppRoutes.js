import React from 'react'
import { Route, Routes } from "react-router-dom";
import Login from './pages/Login';
import Dashboard from './pages/Dashboard';
import Organization from './pages/Organization';
import SurveyForm from './pages/SurveyForm';
import DynamicForm from './pages/DynamicForm';

const AppRoutes = () => {
  return (
    <Routes>
        <Route exact path="/" element={<Login />} />
        <Route exact path="/dashboard" element={<Dashboard />}></Route>
        <Route exact path="/organization" element={<Organization />}></Route>
        <Route exact path="/login" element={<Login />}></Route>
        <Route exact path="/surveyForm" element={<SurveyForm />}></Route>
        <Route exact path="/createForm" element={<DynamicForm />} />
    </Routes>
  )
}

export default AppRoutes