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
){
    public JobRequestDTO(String jobTitle) {
        this(jobTitle, "", 0, 0, List.of(), List.of(), List.of(), null);
    }

    public JobRequestDTO(String jobTitle, String location, double yearsOfExperience, double jobSalary, List<String> requireTechnicalSkills, List<String> requireSoftSkills, List<String> benefits) {
        this(jobTitle, location, yearsOfExperience, jobSalary, requireTechnicalSkills, requireSoftSkills, benefits, null);
    }


}