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
	private int openTitleCount;
	private LocalDateTime createdDate;
	private LocalDate deadline;
	private String description;
}
