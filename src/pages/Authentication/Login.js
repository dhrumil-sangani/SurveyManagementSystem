import React,{useContext} from 'react'
import * as Yup from "yup";
import { useFormik } from "formik";
import { Form } from 'react-bootstrap';
import { Link,useNavigate } from 'react-router-dom';

import { ApiCall } from '../../ApiCall';
import { UserContext } from '../../App';

const Login = () => {

    const navigate = useNavigate();

    const { state, dispatch } = useContext(UserContext);

    const userSchema = Yup.object({
        email: Yup.string().email("Email must be a valid email").required("Email is required"),
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
        email: "",
        password: "",
    };

    const { values, errors, touched, handleBlur, handleChange, handleSubmit } =
    useFormik({
        initialValues: initialValues,
        validationSchema: userSchema,
        onSubmit: async (values, { resetForm }) => {
            const response =await ApiCall("auth/login",values)
            localStorage.setItem("token", response.data.jwtToken);
            localStorage.setItem("user", JSON.stringify(response.data));
            dispatch({type:"USERNAME",payload:response.data.user.name})
            dispatch({type: "USER",payload: response.data});
            navigate("/dashboard");
            resetForm();
        },
    });
    
    return (
        <div className="container">
            <section className="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
                <div className="container">
                    <div className="row justify-content-center">
                        <div className="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
                            <div className="d-flex justify-content-center py-4">
                                <a href="index.html" className="logo d-flex align-items-center w-auto">
                                    <img src="assets/img/logo.png" alt="" />
                                    <span className="d-none d-lg-block">Survey Management</span>
                                </a>
                            </div>
                            <div className="card mb-3">
                                <div className="card-body">
                                    <div className="pt-4 pb-2">
                                        <h5 className="card-title text-center pb-0 fs-4">Login to Your Account</h5>
                                        <p className="text-center small">Enter your username & password to login</p>
                                    </div>
                                    <form className="row g-3 needs-validation" onSubmit={handleSubmit}>
                                        <div className="col-12">
                                            <label htmlFor="yourUsername" className="form-label">Email</label>
                                            {/* <span className="input-group-text" id="inputGroupPrepend">@</span> */}
                                            <input type="text" name="email" value={values.email} onChange={handleChange} autoComplete="off" className="form-control" />
                                            {errors.email && touched.email && (
                                                <Form.Text className="text-danger">
                                                    {errors.email}
                                                </Form.Text>                                                
                                            )}
                                        </div>
                                        <div className="col-12">
                                            <label htmlFor="yourPassword" className="form-label">Password</label>
                                            <input type="password" name="password" value={values.password} onChange={handleChange} autoComplete="off" className="form-control" />
                                            {errors.password && touched.password && (
                                                <Form.Text className="text-danger">
                                                    {errors.password}
                                                </Form.Text>                                                
                                            )}
                                        </div>
                                        <div className="col-12">
                                            <div className="form-check">
                                            <input className="form-check-input" type="checkbox" name="remember" value="true" id="rememberMe" />
                                            <label className="form-check-label" htmlFor="rememberMe">Remember me</label>
                                            </div>
                                        </div>
                                        <div className="col-12">
                                            <button className="btn btn-primary w-100" type="submit">Login</button>
                                        </div>                        
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    )
}

export default Login