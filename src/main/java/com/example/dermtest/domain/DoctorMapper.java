package com.example.dermtest.domain;

import com.example.dermtest.business.DoctorResponse;

public class DoctorMapper {

    public static DoctorResponse mapToDoctorResponse(Doctor doctor) {
        if (doctor == null) {
            return null;
        }

        return new DoctorResponse(doctor);
    }
}
