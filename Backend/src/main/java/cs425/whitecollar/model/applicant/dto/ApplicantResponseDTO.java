package cs425.whitecollar.model.applicant.dto;

public record ApplicantResponseDTO(
         String firstName,
         String lastName,
         String email,
         Long yearsOfExperience
) {
}
