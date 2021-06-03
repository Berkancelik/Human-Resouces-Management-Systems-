package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="resume_skills")
@NoArgsConstructor
@AllArgsConstructor
public class ResumeSkill extends Base {
	
	
	@Column(name = "skill_name")
	private String skillName;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

}
