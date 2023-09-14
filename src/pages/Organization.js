import React from 'react'

const Organization = () => {
  return (
    <div class="container">
        <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
                        <div class="d-flex justify-content-center py-4">
                            <a href="index.html" class="logo d-flex align-items-center w-auto">
                                <img src="assets/img/logo.png" alt="" />
                                <span class="d-none d-lg-block">Organization List</span>
                            </a>
                        </div>
                        <div class="card mb-3">
                            <div class="card-body">
                                <div class="pt-4 pb-2">
                                    <h5 class="card-title text-center pb-0 fs-4">Create Organization</h5>
                                </div>
                                <form class="row g-3 needs-validation" novalidate>
                                    <div class="col-12">
                                        <label for="name" class="form-label">Organization Name</label>
                                        <div class="input-group has-validation">
                                        <input type="text" name="name" class="form-control" id="name" required />
                                        <div class="invalid-feedback">Please enter your organization name.</div>
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <label for="yourdescription" class="form-label">Description</label>
                                        <textarea type="text" name="description" class="form-control" id="description" required> </textarea>
                                        <div class="invalid-feedback">Please enter description</div>
                                    </div>
                                    
                                    <div class="col-12">
                                        <button class="btn btn-primary w-100" type="submit">Submit</button>
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

export default Organization