import { StylesManager, Model } from "survey-core";
import "survey-core/defaultV2.min.css";
import { Survey } from "survey-react-ui";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { themeJson } from "../component/FormTheme/theme";
import CreateSurveySchema from "../component/Schema/CreateSurveySchema"; // Import your modified schema
import axios from "axios";

// StylesManager.applyTheme("modern");
const authToken = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoYXJkaWtAc3BlYy1pbmRpYS5jb20iLCJleHAiOjE2OTUzODMyNDUsImlhdCI6MTY5NTM2NTI0NX0.hfY5FNYSH-pS33GI-OqTC_0Us62rDHkZamuXc53R49BZffizw1Gm93j4p_TWLavozqxz4WOlFZq4GyL-4iCqnQ';

const getSurveyDetails = async (id) => {


    const response = await axios.get(`http://localhost:8081/api/surveys/SurveyDetails?id=${id}`, {
        headers: {
            Authorization: `Bearer ${authToken}`,
        },
    });
    return response.data;
};

const storeSurveyResponse = async (surveyResponse) => {
    try {
        const response = await axios.post(
            'http://localhost:8081/api/surveys/store',
            surveyResponse,
            {
                headers: {
                    Authorization: `Bearer ${authToken}`,
                    'Content-Type': 'application/json',
                },
            }
        );
        return response.data;
    } catch (error) {
        console.error('Error while storing survey response:', error);
        throw error; // Rethrow the error for further handling
    }
};

function SurveyFillingForm() {
    const [survey, setSurvey] = useState(null);
    const [isLoading, setIsLoading] = useState(true);
    const { id } = useParams();

    useEffect(() => {
        const fetchSurvey = async () => {
            const surveyDetails = await getSurveyDetails(id);
            setSurvey(new Model(surveyDetails));
            setIsLoading(false);
        };

        fetchSurvey();
    }, [id]);

    if (isLoading) {
        return <div>Loading survey...</div>;
    }

    survey.applyTheme(themeJson);
    survey.onComplete.add((sender, options) => {
        console.log('Survey data to be stored:', sender.data); // Log the survey data
        storeSurveyResponse(sender.data)
            .then((response) => {
                console.log('Response from server:', response); // Log the response from the server
            })
            .catch((error) => {
                console.error('Error while storing survey response:', error); // Log any errors
            });
    });

    return (
        <main id="main" className="main">
            <Survey model={survey} />
        </main>
    );
}

export default SurveyFillingForm;
