import React, { useEffect, useState } from 'react'
import { ApiCall,deleteAPICall,dateConverter } from '../ApiCall'
import TableComponent from '../component/UI/TableComponent';
import swal from 'sweetalert';
import { Button } from 'react-bootstrap';
import ModalComponent from '../component/UI/ModalComponent';

export const User = () => {

    const [userData,setUserData] = useState([]);
    const [showModal,setShowModal] = useState(false);
    const [editData,setEditData] = useState([]);
    const [isUpdate,setIsUpdate] = useState(false);

    const handleClose = () => {
        setShowModal(false);
        setIsUpdate(false);
    }

    const getUser = async() => {
        const response = await ApiCall("api/v1/users")
        setUserData(response.data)
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
                    setUserData((oldData)=>{
                        return oldData.filter((user)=>{
                            return user.id !== id;
                        })
                    })
                }
            } 
        });
    }

    const editUser = (data) => {
        setEditData(data);
        setShowModal(true);
        setIsUpdate(true);
    }

    var columns = [
        {
            dataField: "No",
            text: "No",
            formatter: (cell, row, rowIndex) => {
                return (
                    <>{rowIndex+1}</>
                );
            }
        },
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
                return (
                  <div className='action-btns' >{row.status ? "Active" : "InActive"}</div>
                );
            }
        },
        {
            dataField: "createdAt",
            text: "Created Date",
            sort: true,
            formatter: (cell, row, rowIndex) => {
              return (
                dateConverter(row.createdAt)
              );
            }
        },
        {
            dataField: "Update",
            text: "Update",
            formatter: (cell, row, rowIndex) => {
              return (
                <Button className="btn btn-warning" onClick={()=>editUser(row)}>Update</Button>
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
                    <ModalComponent showModal={showModal} getUser={getUser} oldData={editData} handleClose={handleClose} isUpdate={isUpdate} type="User"/>
                )
            }
        </main>
    )
}
