package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceForCandidateDto {
	
	private int id;
	
	private int resumeId;

	private String companyName;

	private int jobTitleId;

	private LocalDate startedDate;

	private LocalDate endedDate;

}
