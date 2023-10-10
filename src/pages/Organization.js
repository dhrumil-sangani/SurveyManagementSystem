import React,{useEffect, useState} from 'react'
import TableComponent from '../component/UI/TableComponent';
import { ApiCall, deleteAPICall } from '../ApiCall';
import { Button } from 'react-bootstrap';
import ModalComponent from '../component/UI/ModalComponent';
import swal from 'sweetalert';

const Organization = () => {

    const [organizationData,setOrganizationData] = useState([]);
    const [showModal,setShowModal] = useState(false);
    const [isUpdate,setIsUpdate] = useState(false);
    const [editData,setEditData] = useState([]);

    const handleClose = () => {
        setShowModal(false);
        setIsUpdate(false);
    }

    const getOrganization = async() => {
        const response = await ApiCall("api/v1/organizations")
        setOrganizationData(response.data)
    }

  const deleteOrganization = (id) => {
    swal({
        title: "Are you sure, You want to Delete?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
    .then(async(willDelete) => {
      if (willDelete) {
        const response = await deleteAPICall(`api/v1/organization/${id}`);
        if(response.status == 200){
            setOrganizationData((oldData)=>{
                return oldData.filter((org)=>{
                return org.id !== id;
                })
            })
        }
      } 
    });
  }

    const editOrganization = (data) => {
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
            dataField: "Update",
            text: "Update",
            formatter: (cell, row, rowIndex) => {
                return (
                    <Button className="btn btn-warning" onClick={()=>editOrganization(row)}>Update</Button>
                );
            }
        },
        {
            dataField: "Delete",
            text: "Delete",
            formatter: (cell, row, rowIndex) => {
                return (
                    <Button className="btn btn-danger" onClick={()=>deleteOrganization(row.id)}>Delete</Button>
                );
            }
        }
    ];

    useEffect(()=>{
        async function getOrganizationData() {
            const response = await ApiCall("api/v1/organizations")
            setOrganizationData(response.data)
        }
        getOrganizationData();
    },[])

    return (
        <main id="main" className="main">
            <Button onClick={()=>setShowModal(true)}>Add Organization</Button>
            <TableComponent columns={columns} rowData={organizationData}/>
            {
                showModal && (
                    <ModalComponent showModal={showModal} getOrganization={getOrganization} oldData={editData} handleClose={handleClose} isUpdate={isUpdate} type="Organization"/>
                )
            }
        </main>
    )
}

export default Organization