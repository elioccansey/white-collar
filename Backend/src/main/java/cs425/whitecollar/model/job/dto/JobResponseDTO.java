package cs425.whitecollar.model.job.dto;

import cs425.whitecollar.model.employer.dto.EmployerResponseDTO;

import java.util.List;

public record JobResponseDTO (
    Integer jobId,
    String jobTitle,
    String location,
    double yearsOfExperience,
    double jobSalary,
    List<String> requireTechnicalSkills,
    List<String> requireSoftSkills,
    List<String> benefits,
    EmployerResponseDTO employer)
{ }
