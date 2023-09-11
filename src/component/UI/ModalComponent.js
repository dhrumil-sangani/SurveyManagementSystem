import React from 'react'
import Modal from "react-bootstrap/Modal";
import AddUser from '../Modal/AddUser';

const ModalComponent = (props) => {
    var showModal = props?.showModal;
    return (
        <Modal show={showModal} onHide={props.handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>
                    Add User
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <AddUser/>
            </Modal.Body>
        </Modal>
    )
}

export default ModalComponent