package com.spec.surveymanagementsystem.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "survey_assign")
public class SurveyAssign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "survey_id", referencedColumnName = "id")
    private Survey survey;

    @ManyToOne
    @JoinColumn(name = "assign_to", referencedColumnName = "id")
    private User assignTo;

    @ManyToOne
    @JoinColumn(name = "assign_by", referencedColumnName = "id")
    private User assignBy;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    // Constructors, getters, setters
}

