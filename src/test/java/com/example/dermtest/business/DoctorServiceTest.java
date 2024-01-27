package com.example.dermtest.business;
import com.example.dermtest.domain.Doctor;
import com.example.dermtest.domain.DoctorRepository;
import com.example.dermtest.validation.DataNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @Test
    void getDoctor_ValidId_ReturnsDoctor() {
        Doctor mockDoctor = new Doctor();
        when(doctorRepository.findById(anyInt())).thenReturn(Optional.of(mockDoctor));

        DoctorResponse response = doctorService.getDoctor(0);

        assertNotNull(response);
    }

    @Test
    void getDoctor_InvalidId_ThrowsException() {
        when(doctorRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, () -> doctorService.getDoctor(999));
    }
}
