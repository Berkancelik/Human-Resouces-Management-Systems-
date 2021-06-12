package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {
	private String title;
	private String companyName;
	private int openTitleCount;
	private LocalDate createdDate;
	private LocalDate deadline;
	
	

}
