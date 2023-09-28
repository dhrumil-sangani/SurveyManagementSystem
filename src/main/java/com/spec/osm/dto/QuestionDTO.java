package com.spec.osm.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class QuestionDTO {

    private int questionId;
    private String questionTitle;
    private String questionType;
    private boolean isRequired;
    private boolean isActive;
    private Date questionCreatedAt;
    private Date questionUpdatedAt;

    private List<QuestionOptionDTO> questionOptions = new ArrayList<>();;

}