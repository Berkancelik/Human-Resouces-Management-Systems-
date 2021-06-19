package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageCandidateAddDto {
	
	public int candidteId ;
	public String languageName;
	public String level;
	
	
}
