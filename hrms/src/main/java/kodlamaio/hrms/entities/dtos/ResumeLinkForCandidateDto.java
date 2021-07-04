package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeLinkForCandidateDto {
	
	private int id;
	
	private int resumeId;	
	
	private String linkedin;
	
	private String github;

}