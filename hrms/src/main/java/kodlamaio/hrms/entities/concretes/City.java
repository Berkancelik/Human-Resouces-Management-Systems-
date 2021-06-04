package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdversitements"})
public class City  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@JsonIgnore
	@Column(name= "created_date")
	private Date createdDate;
	

	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "city")
	private List<JobAdversitements> jobAdversitements;
	
	public City(String name, List<JobAdversitements> jobAdversitements) {
		super();
		this.name = name;
		this.jobAdversitements = jobAdversitements;
	}
	
	
	

}
