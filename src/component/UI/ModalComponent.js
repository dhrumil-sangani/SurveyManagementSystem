import React from 'react'
import Modal from "react-bootstrap/Modal";
import AddUser from '../Modal/AddUser';

const ModalComponent = (props) => {
    var showModal = props?.showModal;
    var isUpdate = props?.isUpdate;

    return (
        <Modal show={showModal} onHide={props.handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>
                    Add User
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <AddUser handleClose={props.handleClose} getUser={props.getUser} oldData={props.oldData} isUpdate={isUpdate}/>
            </Modal.Body>
        </Modal>
    )
}

export default ModalComponent