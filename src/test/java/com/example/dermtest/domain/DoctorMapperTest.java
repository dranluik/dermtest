package com.example.dermtest.domain;

import com.example.dermtest.TestHelper;
import com.example.dermtest.business.DoctorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
public class DoctorMapperTest {


    @Test
    public void whenMapDoctorToResponse_givenValidDoctor_thenCorrectResponse() {
        Doctor doctor = TestHelper.createDoctor("John", "Doe", "L12345", "Dermatologist", "ITK");

        DoctorResponse response = DoctorMapper.mapToDoctorResponse(doctor);

        assertThat(response).isNotNull();
        assertThat(response.getDoctorId()).isEqualTo(doctor.getId());
        assertThat(response.getFirstName()).isEqualTo(doctor.getFirstName());
        assertThat(response.getLastName()).isEqualTo(doctor.getLastName());
        assertThat(response.getRoleName()).isEqualTo(doctor.getRole().getName());
        assertThat(response.getOrganizationName()).isEqualTo(doctor.getOrganization().getName());
    }

    @Test
    public void whenMapDoctorToResponse_givenNullDoctor_thenNullResponse() {
        DoctorResponse response = DoctorMapper.mapToDoctorResponse(null);

        assertThat(response).isNull();
    }

}