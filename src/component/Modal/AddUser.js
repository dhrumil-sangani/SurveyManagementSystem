import React from 'react'
import { Col, Form, Row, Button } from 'react-bootstrap'
import * as Yup from "yup";
import { useFormik } from "formik";
import { ApiCall, UpdateAPICall } from '../../ApiCall';

const AddUser = (props) => {

    var isUpdate = props.isUpdate;
    var oldData = props.oldData;

    const userSchema = Yup.object({
        name : Yup.string().required("Name is required").matches(/^[A-Za-z0-9 ]+$/, "Only Alphabets, Number and Space are allowed for this field"),
        email: Yup.string().email("Email must be a valid email").required("Email is required"),
        mobileNumber : Yup.string().max(10,"Mobile Number must be maximum of 10 digits").matches(/^\d+$/, 'Mobile Number field should have digits only').required("Mobile Number is required"),
        password: Yup
            .string()
            .min(8,"Password must be at least 8 characters").max(20,"Password must be at most 20 characters")
            .required('Password is required')
            .matches(
                /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])/,
                "One Uppercase, One Lowercase, One Number and One Special Case Character"
            ),
    });

    const initialValues = {
        name : isUpdate ? oldData.name : "",
        email : isUpdate ? oldData.email : "",
        mobileNumber : isUpdate ? oldData.mobileNumber : "",
        password : isUpdate ? oldData.password : "",
    };

    const { values, errors, touched, handleBlur, handleChange, handleSubmit } =
    useFormik({
        initialValues: initialValues,
        validationSchema: userSchema,
        onSubmit: async (values, { resetForm }) => {
            values.status = 1;
            if(isUpdate){
                await UpdateAPICall(`api/v1/user/${oldData.id}`,values)
            } else {
                await ApiCall("api/v1/create-user",values)
            }
            props.getUser();
            props.handleClose();
            resetForm();
        },
    });

    return (
        <Form autoComplete="false" onSubmit={handleSubmit}>
            <Form.Group as={Row} className="mb-3" >
                <Form.Label column sm="2">
                    Name
                </Form.Label>
                <Col sm="10">
                    <Form.Control type="text" name="name" value={values.name} onChange={handleChange} placeholder="Name" />
                    {errors.name && touched.name && (
                        <Form.Text className="text-danger">
                            {errors.name}
                        </Form.Text>                                                
                    )}
                </Col>
            </Form.Group>

            <Form.Group as={Row} className="mb-3" >
                <Form.Label column sm="2">
                    Email
                </Form.Label>
                <Col sm="10">
                    <Form.Control type="email" name="email" value={values.email} onChange={handleChange} placeholder="email@example.com" />
                    {errors.email && touched.email && (
                        <Form.Text className="text-danger">
                            {errors.email}
                        </Form.Text>                                                
                    )}
                </Col>
            </Form.Group>

            <Form.Group as={Row} className="mb-3" >
                <Form.Label column sm="2">
                    Mobile Number
                </Form.Label>
                <Col sm="10">
                    <Form.Control type="text" name="mobileNumber" value={values.mobileNumber} onChange={handleChange} placeholder="+91 8945562321" />
                    {errors.mobileNumber && touched.mobileNumber && (
                        <Form.Text className="text-danger">
                            {errors.mobileNumber}
                        </Form.Text>                                                
                    )}
                </Col>
            </Form.Group>

            <Form.Group as={Row} className="mb-3" >
                <Form.Label column sm="2">
                    Password
                </Form.Label>
                <Col sm="10">
                    <Form.Control type="password" name="password" value={values.password} onChange={handleChange} readOnly={isUpdate?true:false} placeholder="Password" />
                    {errors.password && touched.password && (
                        <Form.Text className="text-danger">
                            {errors.password}
                        </Form.Text>                                                
                    )}
                </Col>
            </Form.Group>
            <Button type="submit">Submit </Button>
        </Form>
    )
}

export default AddUser