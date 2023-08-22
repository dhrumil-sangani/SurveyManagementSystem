import logo from './logo.svg';
import './App.css';
import Header from './component/Header';
import Sidebar from './component/Sidebar';
import Login from './pages/Login';
import AppRoutes from './AppRoutes';


function App() {
  return (
    <div className="App">
      <Header/>
      <Sidebar/> 
      <AppRoutes/>
      {/* <Login/>   */}
    </div>
  );
}

export default App;
