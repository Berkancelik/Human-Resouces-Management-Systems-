package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name ="letter_of_acceptance")
public class LetterOfAcceptance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")	
	private int id;
	
	@JsonIgnore
	@Column(name = "content")
	private String content;
	
	@JsonIgnore
	@Column(name= "created_at")
	private LocalDate createdAt = LocalDate.now();
	
	@JsonIgnore
	@Column(name= "is_active")
	private boolean isActive = true;
	
	@JsonIgnore
	@Column(name= "is_deleted")
	private boolean isDeleted = false;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	@JsonIgnore
	private Candidate candidate;

}
