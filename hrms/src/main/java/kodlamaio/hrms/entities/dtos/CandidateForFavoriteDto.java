package kodlamaio.hrms.entities.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateForFavoriteDto {
	
	private int id;
	private int candidateId;
	private int jobAdvertisementId;

}
