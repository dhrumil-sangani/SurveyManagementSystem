import { StylesManager, Model } from "survey-core";
import "survey-core/defaultV2.min.css";
import { Survey } from "survey-react-ui";
import { useState, useEffect } from "react";
import { themeJson } from "../component/FormTheme/theme";
import CreateSurveySchema from "../component/Schema/CreateSurveySchema"; // Import your modified schema

StylesManager.applyTheme("defaultV2");

function SurveyFillingForm() {
    const survey = new Model(CreateSurveySchema);
    survey.applyTheme(themeJson);
    survey.onComplete.add((sender, options) => {
        console.log(JSON.stringify(sender.data, null, 3));
    });
    return (
        <main id="main" className="main">
            <Survey model={survey} />
        </main>
    );
}

export default SurveyFillingForm;
