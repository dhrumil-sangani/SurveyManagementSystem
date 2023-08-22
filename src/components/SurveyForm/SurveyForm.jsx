import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { SurveyCreatorWidget } from "./SurveyCreatorWidget";
import { SurveyListWidget } from "./SurveyListWidget";
import "../../styles/styles.css";

function SurveyForm() {
  return (
    <BrowserRouter>
      <Routes>
        <Route exact path="/createsurvey" component={SurveyListWidget} />
        <Route
          exact
          path="/editsurvey/:id"
          component={SurveyCreatorWidget}
        />
      </Routes>
    </BrowserRouter>
  );
}

export default SurveyForm;
