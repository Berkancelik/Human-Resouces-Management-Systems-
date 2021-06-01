package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resume_schools")
public class Education {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name ="resume_id" )
	private Resume resume;
	
	
	@Column(name ="school_name" )
	@NotBlank(message = "Boş geçilemez!")
	private String schoolName;
	
	@OneToOne(targetEntity = Graduate.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "graudate_id", referencedColumnName = "id",nullable =false )
	private Graduate graduate;
	
	@Column(name ="schoolDepartment" )
	@NotBlank(message = "Boş geçilemez!")
	private String schoolDepartment;
	
	@NotBlank(message = "Boş geçilemez!")
	@Column(name ="starting_date" )
	private Date startingDate;
	
	@Column(name ="ended_date" )
	private Date endedDate;
	
	@Column(name ="created_date" )
	private Date createdDate;
	

}
