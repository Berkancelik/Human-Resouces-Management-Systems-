package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceForCandidateDto {
	private int candidateId;

	private String companyName;

	private String position;

	private LocalDate startedDate;

	private LocalDate endedDate;

}
