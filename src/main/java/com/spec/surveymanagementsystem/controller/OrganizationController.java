package com.spec.surveymanagementsystem.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The organization controller.
 *
 * @author : SPEC Developer on 22/08/2023.
 */
@RestController
@RequestMapping("/api/v1")
public class OrganizationController {

    @GetMapping("/organization")
    public String getOrganization() {
        return "get Organization1";
    }
}