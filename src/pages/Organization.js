import React,{useEffect, useState} from 'react'
import axios from 'axios'
import TableComponent from '../component/UI/TableComponent';
import { ApiCall } from '../ApiCall';

const Organization = () => {

  const [organizationData,setOrganizationData] = useState([]);

  var columns = [
    {
      dataField: "name",
      text: "Name",
      sort: true
    },
    
    {
      dataField: "addUser",
      text: "Add User",
      formatter: (cell, row, rowIndex) => {
        return (
          <button>Add User</button>
          // <div className='action-btns' onClick={()=>deleteAssignment(row.id)}><img src={Redcross} /></div>
        );
      }
    }
  ];

  useEffect(()=>{
    async function getOrganizationData() {
      const response = await ApiCall("api/v1/organization")
      setOrganizationData(response)
      console.log(response,"res")
    }
    getOrganizationData();
  },[])

  return (
    <main id="main" className="main">
      {
        organizationData.length > 0 && (
          <TableComponent columns={columns} rowData={organizationData}/>
        )
      }
    </main>
  )
}

export default Organization