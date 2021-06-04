package kodlamaio.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name ="letter_of_acceptance")
@NoArgsConstructor
public class LetterOfAcceptance extends Base {

	@Column(name = "content")
	private String content;
	

	
	@ManyToOne()
	@JsonIgnore
	private Candidate candidate;
	
	public LetterOfAcceptance(String content, int candidate_id) {
		super();
		this.content = content;
		this.candidate.setId(candidate_id);
	}

}
