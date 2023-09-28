package com.spec.osm.dto;

import com.spec.osm.entities.Organization;
import com.spec.osm.entities.User;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SurveyDTO {

    private Long SurveyId;
    private Integer organizationId;
    private Integer createdByUserId;
    private Integer updatedByUserId;
    private String title;
    private String descriptions;
    private Date startDate;
    private Date expirationDate;
    private boolean status;
    private List<QuestionDTO> questions;
}
