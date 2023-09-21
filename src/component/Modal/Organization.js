import React from 'react'
import { Button, Form, Row, Col} from 'react-bootstrap'
import * as Yup from "yup";
import { useFormik } from "formik";
import { ApiCall, UpdateAPICall } from '../../ApiCall';

const Organization = (props) => {

    var isUpdate = props.isUpdate;
    var oldData = props.oldData;

    const userSchema = Yup.object({
        name : Yup.string().required("Name is required"),
        description : Yup.string().required("Description is required"),
    });

    const initialValues = {
        name : isUpdate ? oldData.name : "",
        description : isUpdate ? oldData.description : "",
    };

    const { values, errors, touched, handleChange, handleSubmit } =
    useFormik({
        initialValues: initialValues,
        validationSchema: userSchema,
        onSubmit: async (values, { resetForm }) => {
            values.status = 1;
            if(isUpdate){
                await UpdateAPICall(`api/v1/organization/${oldData.id}`,values)
            } else {
                await ApiCall("api/v1/organization",values)
            }
            props.getOrganization();
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
                    <Form.Control type="text" name="name" value={values.name} onChange={handleChange}/>
                    {errors.name && touched.name && (
                        <Form.Text className="text-danger">
                            {errors.name}
                        </Form.Text>                                                
                    )}
                </Col>
            </Form.Group>

            <Form.Group as={Row} className="mb-3" >
                <Form.Label column sm="2">
                    Description 
                </Form.Label>
                <Col sm="10">
                    <Form.Control as="textarea" name="description" value={values.description} onChange={handleChange} rows={3} />
                    {errors.description && touched.description && (
                        <Form.Text className="text-danger">
                            {errors.description}
                        </Form.Text>                                                
                    )}
                </Col>
            </Form.Group>
            <Button type="submit">Submit </Button>
        </Form>
    )
}

export default Organization