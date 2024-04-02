import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import FooterCom from './components/FooterCom';
import HeaderCom from './components/HeaderCom';
import ListEmpComp from './components/ListEmpComp';
import AddEmp from './components/AddEmp';

function App() {
  return (
    <div>
      <Router>
      <HeaderCom/>
      <div className='container'>
        <Routes>
          <Route exact path='/' Component={ListEmpComp} ></Route>
               
          <Route path='/employees' Component={ListEmpComp}></Route>        
          <Route path='/add-employee' Component={AddEmp}></Route>
          <Route path='/edit-employee/:id' Component={AddEmp}></Route>
        </Routes>
      </div>
      <FooterCom/>
      </Router>
    </div>
  );
}

export default App;
