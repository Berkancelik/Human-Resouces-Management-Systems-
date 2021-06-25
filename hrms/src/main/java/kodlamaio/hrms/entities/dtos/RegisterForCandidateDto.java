package kodlamaio.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForCandidateDto {
	  	private String firstName;
	    private String lastName;
	    private String nationalId;
	    private String dateOfBirth;
	    private String email;
	    private String password;

}
