package kodlamaio.hrms.entities.concretes;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name = "resume_images")
@NoArgsConstructor
@AllArgsConstructor
public class ResumeImage   {

	
	@JsonIgnore
	@Column(name= "created_date", columnDefinition = "Date defult CURRENT_DATE")
	private LocalDate createdDate = LocalDate.now();

	
	@JsonIgnore
	@Column(name= "is_active")
	private boolean isActive = true;
	
	
	@Column(name = "url_address")
	private String urlAddress;
	
	@OneToOne(optional=false,fetch=FetchType.LAZY)
    @JoinColumn(name = "candidate_id", referencedColumnName = "user_id")
    private Candidate candidate;

	

}
