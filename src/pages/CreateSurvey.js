import React, { useEffect, useState } from "react";
import { Survey } from "survey-react-ui";
const SurveyCreate = () => {
  const [survey, setSurvey] = useState(null);

  // Define your survey data
  const surveyJSON = {
    title: "Survey Example",
    pages: [
      {
        title: "Survey Page",
        questions: [
          {
            type: "dropdown",
            name: "question1",
            title: "Pick a region...",
            isRequired: true,
            choices: ["Africa"],
          },
        ],
      },
    ],
  };

  useEffect(() => {
    // Create a model from the survey data and set up an event listener for the survey completion
    const surveyModel = new Survey.Model(surveyJSON);
    surveyModel.onComplete.add(onSurveyComplete);

    // Set the survey model to the state
    setSurvey(surveyModel);
  }, []);

  const onSurveyComplete = (survey) => {
    // Handle the survey completion data here
    const surveyData = survey.data;
    console.log("Survey data:", surveyData);

    // You can send the survey data to your server or perform any other actions as needed
  };

  return (
    <main id="main" className="main">
      <div className="survey-container">
        <h2>{surveyJSON.title}</h2>
        {survey && <Survey.Survey model={survey} />}
      </div>
    </main>
  );
};

export default SurveyCreate;
