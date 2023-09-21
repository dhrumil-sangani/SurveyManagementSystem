import React,{useContext} from 'react'
import { Route, Routes } from "react-router-dom";
import Login from './pages/Login';
import Dashboard from './pages/Dashboard';
import Organization from './pages/Organization';
import SurveyForm from './pages/SurveyForm';
import DynamicForm from './pages/DynamicForm';
import { UserContext } from './App';
import { User } from './pages/User';
import SurveyCreate from './pages/CreateSurvey';

const AppRoutes = () => {
  const { state, dispatch } = useContext(UserContext);

  return (
    <Routes>
        <Route exact path="/" element={state.user ? <Dashboard/> : <Login />} />
        <Route exact path="/dashboard" element={<Dashboard />}></Route>
        <Route exact path="/organization" element={<Organization />}></Route>
        <Route exact path="/user" element={<User />}></Route>
        <Route exact path="/login" element={<Login />}></Route>
        <Route exact path="/surveyForm" element={<SurveyForm />}></Route>
        <Route exact path="/createForm" element={<DynamicForm />} />
        <Route exact path="/surveyCreate" element={<SurveyCreate />} />
        
    </Routes>
  )
}

export default AppRoutes