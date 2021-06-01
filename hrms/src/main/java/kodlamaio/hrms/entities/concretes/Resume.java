package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "edu_gradutes")
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name="candidate_id", referencedColumnName = "id", nullable=false)
	private int candidateId;
	
	@Column(name ="github_link")
	private String githubLink;
	
	@Column(name ="github_link")
	private String linkedinLink;
	
	@Column(name ="photo")
	private String photo;
	
	@Column(name ="description")
	private String description;
	
	@Column(name ="created_date")
	private Date createdDate;
	
	@Column(name ="uptadet_date")	
	private Date uptadetDate;	
	
	@Column(name ="is_active")		
	private boolean isActive;
	
	@OneToMany(mappedBy ="resume")
	private List<Language> languages;
	
	@OneToMany(mappedBy ="resume")
	private List<Technology> technologies;
	
	@OneToMany(mappedBy ="resume")
	private List<Education> education;
	
	@OneToMany(mappedBy ="resume")
	private List<JobExperience> jobExperience;
	
	
}
