package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name ="job_advert_confirm")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertConfirm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")	
	private int id;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	@Column(name = "condirmed_date")
	private LocalDate confirmedDate;
	
	@OneToOne
	@JoinColumn(name ="job_advertisement_id")
	private JobAdvertisement jobAdvertisement;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

}
