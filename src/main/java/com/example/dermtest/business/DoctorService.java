package com.example.dermtest.business;

import com.example.dermtest.domain.Doctor;
import com.example.dermtest.domain.DoctorMapper;
import com.example.dermtest.domain.DoctorRepository;
import com.example.dermtest.validation.DataNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

import static com.example.dermtest.validation.Error.DOCTOR_NOT_FOUND;

@Service
public class DoctorService {
    @Resource
    private DoctorRepository doctorRepository;

    public DoctorResponse getDoctor(Integer doctorId) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        if (doctorOptional.isEmpty()) {
            throw new DataNotFoundException(DOCTOR_NOT_FOUND.getMessage(), DOCTOR_NOT_FOUND.getErrorCode());
        }
        Doctor doctor = doctorOptional.get();
        return DoctorMapper.mapToDoctorResponse(doctor);
    }

}

