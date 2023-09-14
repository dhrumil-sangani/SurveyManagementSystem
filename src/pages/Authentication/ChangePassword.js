import React from 'react'
import { Button, Form } from 'react-bootstrap'
import * as Yup from "yup";
import { useFormik } from "formik";
import { ApiCall } from '../../ApiCall';

const ChangePassword = () => {

    const userSchema = Yup.object({
        currentPassword: Yup.string().email("Password must be a valid email").required("Password is required"),
        newPassword: Yup.string()
            .min(8,"New Password must be at least 8 characters").max(20,"New Password must be at most 20 characters")
            .required('New Password is required')
            .matches(
                /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])/,
                "One Uppercase, One Lowercase, One Number and One Special Case Character"
            ),
        confirmNewPassword: Yup.string()
            .required("Confirm New Password is required")
            .oneOf(
                [Yup.ref("newPassword"), null],
                "New Password and confirm New Password must match"
            ),
      });

      const initialValues = {
        currentPassword: "",
        newPassword: "",
        confirmNewPassword: "",
      };
    
    const { values, errors, touched, handleBlur, handleChange, handleSubmit } = useFormik({
        initialValues: initialValues,
        validationSchema: userSchema,
        onSubmit: async (values, { resetForm }) => {
            const response = await ApiCall("api/v1/change-password",values);
            if(response.status == 200)
                resetForm();
        },
    });

    return (
        <main id="main" className="main">
            <div className="card p-4">
                <Form autoComplete="false" autoFocus={false} onSubmit={handleSubmit}>
                    <div className="row gy-4">
                        <Form.Group className="form-group full-fuied" >
                            <div className='col-md-6'>
                                <Form.Label>Current Password<span>*</span></Form.Label>
                                <Form.Control type="text" name="currentPassword" value={values.currentPassword} onChange={handleChange} className="form-control" placeholder="Current Password" />
                                {errors.currentPassword && touched.currentPassword && (
                                    <Form.Text className="text-danger">
                                    {errors.currentPassword}
                                    </Form.Text>
                                )}
                            </div>
                        </Form.Group>

                        <Form.Group className="form-group full-fuied" >
                            <div className='col-md-6'>
                                <Form.Label>New Password<span>*</span></Form.Label>
                                <Form.Control type="text" name="newPassword" value={values.newPassword} onChange={handleChange} className="form-control" placeholder="New Password" />
                                {errors.newPassword && touched.newPassword && (
                                    <Form.Text className="text-danger">
                                    {errors.newPassword}
                                    </Form.Text>
                                )}
                            </div>
                        </Form.Group>

                        <Form.Group className="form-group full-fuied" >
                            <div className='col-md-6'>
                                <Form.Label>Confirm New Password<span>*</span></Form.Label>
                                <Form.Control type="text" name="confirmNewPassword" value={values.confirmNewPassword} onChange={handleChange} className="form-control" placeholder="Confirm New Password" />
                                {errors.confirmNewPassword && touched.confirmNewPassword && (
                                    <Form.Text className="text-danger">
                                    {errors.confirmNewPassword}
                                    </Form.Text>
                                )}
                            </div>
                        </Form.Group>

                        <div className="col-md-12">
                            <Button type="submit">Change Password</Button>
                        </div>
                    </div>
                </Form>
            </div>
        </main>
    )
}

export default ChangePassword