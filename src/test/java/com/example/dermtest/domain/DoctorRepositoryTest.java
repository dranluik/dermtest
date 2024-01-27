package com.example.dermtest.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class DoctorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private OrganizationRepository organizationRepository;


    @Test
    public void whenSaveDoctor_thenCanBeRetrieved() {
        Doctor savedDoctor = createAndSaveDoctor();

        Doctor retrievedDoctor = doctorRepository.findById(savedDoctor.getId()).orElse(null);

        assertThat(retrievedDoctor).isNotNull();
        assertThat(retrievedDoctor.getFirstName()).isEqualTo("John");
        assertThat(retrievedDoctor.getLastName()).isEqualTo("Doe");
        assertThat(retrievedDoctor.getLicenseCode()).isEqualTo("L12345");
        assertThat(retrievedDoctor.getRole().getName()).isEqualTo("Dermatologist");
        assertThat(retrievedDoctor.getOrganization().getName()).isEqualTo("ITK");
    }

    @Test
    public void whenUpdateDoctor_thenDataIsUpdated() {
        Doctor doctor = createAndSaveDoctor();

        doctor.setFirstName("Jane");
        Doctor updatedDoctor = doctorRepository.save(doctor);

        assertThat(updatedDoctor.getFirstName()).isEqualTo("Jane");
    }

    @Test
    public void whenDeleteDoctor_thenCannotBeRetrieved() {
        Doctor doctor = createAndSaveDoctor();

        doctorRepository.deleteById(doctor.getId());

        Optional<Doctor> deletedDoctor = doctorRepository.findById(doctor.getId());
        assertThat(deletedDoctor.isEmpty()).isTrue();
    }

    private Doctor createAndSaveDoctor() {
        Role role = new Role();
        role.setName("Dermatologist");
        role = roleRepository.save(role);

        Organization organization = new Organization();
        organization.setName("ITK");
        organization = organizationRepository.save(organization);

        Doctor doctor = new Doctor();
        doctor.setFirstName("John");
        doctor.setLastName("Doe");
        doctor.setLicenseCode("L12345");
        doctor.setRole(role);
        doctor.setOrganization(organization);

        return doctorRepository.save(doctor);
    }


}
