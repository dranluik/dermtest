package com.example.dermtest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "DOCTOR")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Size(max = 255)
    @NotNull
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Size(max = 255)
    @NotNull
    @Column(name = "LICENSE_CODE", nullable = false)
    private String licenseCode;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Role role;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORGANIZATION_ID", nullable = false)
    private Organization organization;

}