package com.example.dermtest.business;

import com.example.dermtest.domain.Doctor;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * DTO for {@link Doctor}
 */
@Value
public class DoctorResponse implements Serializable {
    Integer doctorId;
    @NotNull
    @Size(max = 255)
    String firstName;
    @NotNull
    @Size(max = 255)
    String lastName;
    @NotNull
    @Size(max = 255)
    String licenseCode;
    String roleName;
    String organizationName;

    public DoctorResponse(Doctor doctor) {
        this.doctorId = doctor.getId();
        this.firstName = doctor.getFirstName();
        this.lastName = doctor.getLastName();
        this.licenseCode = doctor.getLicenseCode();
        this.roleName = doctor.getRole() != null ? doctor.getRole().getName() : null;
        this.organizationName = doctor.getOrganization() != null ? doctor.getOrganization().getName() : null;
    }
}