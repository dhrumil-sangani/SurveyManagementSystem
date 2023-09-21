import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

export function SurveyListWidget(props) {
    const [items, setItems] = useState([]);
  
    useEffect(() => {
      updateSurveyList();
    });
}  