package com.example.dermtest.business;

import com.example.dermtest.validation.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DoctorController {
    @Resource
    private DoctorService doctorService;

    @GetMapping("/doctor")
    @Operation(summary = "Returns DoctorResponse for a doctorId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Doctor not found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public DoctorResponse getDoctor(@RequestParam Integer doctorId){
         return doctorService.getDoctor(doctorId);
    }
}
