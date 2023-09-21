import React from 'react'
import Modal from "react-bootstrap/Modal";
import AddUser from '../Modal/AddUser';
import Organization from '../Modal/Organization';

const ModalComponent = (props) => {
    var showModal = props?.showModal;
    var isUpdate = props?.isUpdate;
    var type = props?.type;

    return (
        <Modal show={showModal} onHide={props.handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>
                    {isUpdate ? "Edit" : "Add"} {type}
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                {
                    type == "Organization" ? (
                        <Organization handleClose={props.handleClose} oldData={props.oldData} getOrganization={props.getOrganization} isUpdate={isUpdate}/>
                    ) : (
                        <AddUser handleClose={props.handleClose} getUser={props.getUser} oldData={props.oldData} isUpdate={isUpdate}/>
                    )
                }
            </Modal.Body>
        </Modal>
    )
}

export default ModalComponent