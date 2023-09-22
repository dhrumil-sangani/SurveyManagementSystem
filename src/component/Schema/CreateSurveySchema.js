const CreateSurveySchema = {
  title: "Survey 1",
  description: "Employee Satisfaction Survey",
  elements: [
    {
      type: "dropdown",
      name: "question1",
      title: "What's Your Region?",
      isRequired: true,
      choices: [
        {
          text: "Africa"
        },
        {
          text: "Asia"
        },
        {
          text: "Europe"
        },
        {
          text: "North America"
        },
        {
          text: "South America"
        }
      ]
    },
    {
      type: "radiogroup",
      name: "question2",
      title: "What is your favorite color?",
      isRequired: true,
      choices: [
        {
          value: "red",
          text: "Red"
        },
        {
          value: "blue",
          text: "Blue"
        },
        {
          value: "green",
          text: "Green"
        },
        {
          value: "yellow",
          text: "Yellow"
        }
      ]
    }
  ]
};

export default CreateSurveySchema;
