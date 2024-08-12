package cs425.whitecollar.model.application.dto;

import cs425.whitecollar.model.applicant.dto.ApplicantResponseDTO;
import cs425.whitecollar.model.application.applicationStatus.ApplicationStatus;
import cs425.whitecollar.model.job.dto.JobResponseDTO;

import java.time.LocalDate;

public record ApplicationResponseDTO(
        Long applicationId,
        ApplicationStatus applicationStatus,
        LocalDate applicationDate,
        JobResponseDTO job

    ) { }
