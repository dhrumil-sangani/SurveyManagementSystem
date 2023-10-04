package com.spec.osm.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SurveyDTO {

    private Long SurveyId;
    private Long organizationId;
    private Long createdByUserId;
    private Long updatedByUserId;
    private String title;
    private String descriptions;
    private Date startDate;
    private Date expirationDate;
    private boolean status;
    private List<QuestionDTO> questions = new ArrayList<>();

}
