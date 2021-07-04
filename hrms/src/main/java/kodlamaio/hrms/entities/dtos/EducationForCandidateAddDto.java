package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EducationForCandidateAddDto {
	
	private int id;
	private int resumeId;
    private String schoolName;
    private String department;
    private LocalDate startedDate;
    private LocalDate endedDate;
}