package com.spec.surveymanagementsystem.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "descriptions", columnDefinition = "text")
    private String descriptions;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;

    @Column(name = "survey_link", nullable = false)
    private String surveyLink;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "updated_by")
    private Long updatedBy;

    // Constructors, getters, setters
}

