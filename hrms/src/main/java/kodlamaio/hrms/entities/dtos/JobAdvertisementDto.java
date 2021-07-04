package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {

	private int openTitleCount;

	private LocalDate deadline;

	private int workTypeId;

	private int workHourId;

	private int jobTitleId;

	private int employerId;

	private String description;

	private int cityId;

	private int salaryMin;

	private int salaryMax;

}