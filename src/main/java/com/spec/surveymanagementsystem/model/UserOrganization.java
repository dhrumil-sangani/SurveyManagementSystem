package com.spec.surveymanagementsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_organizations")
public class UserOrganization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "organizations_id", referencedColumnName = "id")
    private Organization organization;

    // Constructors, getters, setters
}
