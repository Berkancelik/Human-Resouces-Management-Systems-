package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name = "resume_images")
@NoArgsConstructor
@AllArgsConstructor
public class ResumeImage extends Base {
	
	
	@Column(name = "url_address")
	private String urlAddress;
	
	@OneToOne(optional=false,fetch=FetchType.LAZY)
    @JoinColumn(name = "candidate_id", referencedColumnName = "user_id")
    private Candidate candidate;

	

}
