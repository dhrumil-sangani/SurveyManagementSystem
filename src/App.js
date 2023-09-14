import React,{createContext, useEffect, useReducer} from 'react'
import './App.css';
import Header from './component/Header';
import Sidebar from './component/Sidebar';
import AppRoutes from './AppRoutes';
import {reducer,initialState} from './reducer/useReducer'
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


export const UserContext = createContext();

function App() {

    const [state,dispatch] = useReducer(reducer,initialState);

    useEffect(()=>{
        var user = JSON.parse(localStorage.getItem("user"));
        if(user != null){
            dispatch({type: "USER",payload: JSON.stringify(user)});
            dispatch({type: "USERNAME",payload: user.user.name})
        }
    },[])

    return (
        <>
            <ToastContainer theme="dark" autoClose={3000}/>
            <UserContext.Provider value={{state,dispatch}}>
                {
                    state.user && (
                        <>
                            <Header/>
                            <Sidebar/>  
                        </>
                    )
                }
                
                <AppRoutes/>
            </UserContext.Provider>
        </>
    );
}

export default App;


