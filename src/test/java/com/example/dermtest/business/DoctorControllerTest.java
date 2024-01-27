package com.example.dermtest.business;

import com.example.dermtest.domain.Doctor;
import com.example.dermtest.domain.Organization;
import com.example.dermtest.domain.Role;
import com.example.dermtest.validation.DataNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.dermtest.validation.Error.DOCTOR_NOT_FOUND;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DoctorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorService doctorService;
    @Test
    void getDoctor_WithValidId_ReturnsDoctor() throws Exception {
        Doctor mockDoctor = getMockDoctor();
        DoctorResponse mockResponse = new DoctorResponse(mockDoctor);

        given(doctorService.getDoctor(0)).willReturn(mockResponse);

        mockMvc.perform(get("/doctor?doctorId=0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.doctorId").value(0))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Smith"))
                .andExpect(jsonPath("$.licenseCode").value("L03510"))
                .andExpect(jsonPath("$.roleName").value("Dermatologist"))
                .andExpect(jsonPath("$.organizationName").value("ITK"));
    }

    private static Doctor getMockDoctor() {
        Doctor mockDoctor = new Doctor();
        mockDoctor.setId(0);
        mockDoctor.setFirstName("John");
        mockDoctor.setLastName("Smith");
        mockDoctor.setLicenseCode("L03510");
        Role mockRole = new Role();
        mockRole.setName("Dermatologist");
        Organization mockOrganization = new Organization();
        mockOrganization.setName("ITK");

        mockDoctor.setRole(mockRole);
        mockDoctor.setOrganization(mockOrganization);
        return mockDoctor;
    }

    @Test
    void getDoctor_WithInvalidId_ReturnsNotFound() throws Exception {
        String expectedErrorMessage = DOCTOR_NOT_FOUND.getMessage();
        Integer expectedErrorCode = DOCTOR_NOT_FOUND.getErrorCode();

        given(doctorService.getDoctor(999)).willThrow(new DataNotFoundException(expectedErrorMessage, expectedErrorCode));

        mockMvc.perform(get("/doctor?doctorId=999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(expectedErrorMessage))
                .andExpect(jsonPath("$.errorCode").value(expectedErrorCode));
    }
}
