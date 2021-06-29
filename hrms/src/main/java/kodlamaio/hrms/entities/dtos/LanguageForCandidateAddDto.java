package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageForCandidateAddDto {
	
	private int id;	
	public int resumeId ;
	public String languageName;
	public String level;
	
	
}
