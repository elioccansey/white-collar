package cs425.whitecollar.model.job.dto;

import cs425.whitecollar.model.employer.dto.EmployerRequestDTO;

import java.util.List;


public record JobRequestDTO(
        String jobTitle,
        String location,
        double yearsOfExperience,
        double jobSalary,
        List<String> requireTechnicalSkills,
        List<String> requireSoftSkills,
        List<String> benefits,
        EmployerRequestDTO employer
){ }