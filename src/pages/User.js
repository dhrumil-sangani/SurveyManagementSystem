import React, { useEffect, useState } from 'react'
import { ApiCall,deleteAPICall } from '../ApiCall'
import TableComponent from '../component/UI/TableComponent';
import swal from 'sweetalert';
import { Button } from 'react-bootstrap';
import ModalComponent from '../component/UI/ModalComponent';

export const User = () => {

    const [userData,setUserData] = useState([]);
    const [showModal,setShowModal] = useState(false);

    const handleClose = () => {
        setShowModal(false)
    }

    useEffect(()=>{
        async function getOrganizationData() {
          const response = await ApiCall("api/v1/users")
          setUserData(response.data)
        }
        getOrganizationData();
    },[])

    const deleteUser = (id) => {
        swal({
            title: "Are you sure, You want to Delete?",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
        .then(async(willDelete) => {
            if (willDelete) {
                const response = await deleteAPICall(`api/v1/user/${id}`);
                if(response.status == 200){
                    var data = userData.filter((user)=>{
                        return user.id !== id
                    })
                    setUserData(data)
                }
            } 
        });
    }

    var columns = [
        {
          dataField: "name",
          text: "Name",
          sort: true
        },
        {
            dataField: "email",
            text: "Email",
            sort: true
        },
        {
            dataField: "userStatus",
            text: "Status",
            formatter: (cell, row, rowIndex) => {
                console.log(row)
                return (
                  <div className='action-btns' >{row.status ? "Active" : "InActive"}</div>
                );
            }
        },
        {
            dataField: "Update",
            text: "Update",
            formatter: (cell, row, rowIndex) => {
              return (
                <Button className="btn btn-warning">Update</Button>
              );
            }
        },
        {
          dataField: "Delete",
          text: "Delete",
          formatter: (cell, row, rowIndex) => {
            return (
              <Button className="btn btn-danger" onClick={()=>deleteUser(row.id)}>Delete</Button>
            );
          }
        }
    ];

    return (
        <main id="main" className="main">
        <Button onClick={()=>setShowModal(true)}>Add User</Button>
        {
            userData.length > 0 && (
                <TableComponent columns={columns} rowData={userData}/>
            )
        }
        {
            showModal && (
                <ModalComponent showModal={showModal} handleClose={handleClose}/>
            )
        }
        </main>
    )
}
