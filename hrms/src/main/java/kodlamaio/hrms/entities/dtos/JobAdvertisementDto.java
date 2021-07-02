package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {

	private String companyName;
	private String jobtitle;
	private String city;
	private LocalDateTime createdDate;
	private LocalDate deadlineeadline;
	private String description;
}
