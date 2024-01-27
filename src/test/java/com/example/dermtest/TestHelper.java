package com.example.dermtest;
import com.example.dermtest.domain.Doctor;
import com.example.dermtest.domain.Organization;
import com.example.dermtest.domain.Role;

public class TestHelper {

    public static Doctor createDoctor(String firstName, String lastName, String licenseCode, String roleName, String organizationName) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setLicenseCode(licenseCode);

        Role role = new Role();
        role.setName(roleName);

        Organization organization = new Organization();
        organization.setName(organizationName);

        doctor.setRole(role);
        doctor.setOrganization(organization);

        return doctor;
    }
}
