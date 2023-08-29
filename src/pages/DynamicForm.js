import React from 'react';
import { Formik, FieldArray, Field } from 'formik';
import Select from 'react-select';


const initialValues = {
  questions: [
    {
      text: '',
      type: 'text',
      options: ['']
    }
  ]
};

const questionTypes = ['text', 'radio', 'checkbox', 'dropdown'];

const DynamicForm = () => {
  const handleTypeChange = (index, setFieldValue) => (selectedType) => {
    setFieldValue(`questions.${index}.type`, selectedType.value);
    setFieldValue(`questions.${index}.options`, ['']);
  };

  return (
    <Formik
      initialValues={initialValues}
      onSubmit={values => {
        console.log(values);
      }}
    >
      {({ values, setFieldValue }) => (
        <form className="dynamic-form">
          <FieldArray name="questions">
            {({ push, remove }) => (
              <div>
                {values.questions.map((question, index) => (
                  <div key={index} className="question">
                    <Field
                      name={`questions.${index}.text`}
                      placeholder="Enter your question"
                      className="field"
                    />
                    <Field
                      name={`questions.${index}.type`}
                      render={({ field }) => (
                        <Select
                          {...field}
                          options={questionTypes.map(type => ({ value: type, label: type.toUpperCase() }))}
                          onChange={handleTypeChange(index, setFieldValue)}
                          defaultValue={{ value: 'text', label: 'TEXT' }}
                          className="react-select-container"
                          classNamePrefix="react-select"
                        />
                      )}
                    />
                    {question.type !== 'text' && (
                      <FieldArray name={`questions.${index}.options`}>
                        {({ push: pushOption, remove: removeOption }) => (
                          <div>
                            {question.options.map((option, optionIndex) => (
                              <div key={optionIndex}>
                                <Field
                                  name={`questions.${index}.options.${optionIndex}`}
                                  className="field"
                                />
                                <button
                                  type="button"
                                  onClick={() => removeOption(optionIndex)}
                                  className="remove-option-button"
                                >
                                  Remove Option
                                </button>
                              </div>
                            ))}
                            <button
                              type="button"
                              onClick={() => pushOption('')}
                              className="add-option-button"
                            >
                              Add Option
                            </button>
                          </div>
                        )}
                      </FieldArray>
                    )}
                    <button
                      type="button"
                      onClick={() => remove(index)}
                      className="remove-question-button"
                    >
                      Remove Question
                    </button>
                  </div>
                ))}
                <button
                  type="button"
                  onClick={() => push({ text: '', type: 'text', options: [''] })}
                  className="add-question-button"
                >
                  Add New Question
                </button>
              </div>
            )}
          </FieldArray>
          <button type="submit" className="submit-button">
            Submit
          </button>
        </form>
      )}
    </Formik>
  );
};

export default DynamicForm;
