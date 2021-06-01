package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "edu_gradutes")
@NoArgsConstructor
@AllArgsConstructor
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	@NotBlank(message = "Boş geçilemez!")
	@Column(name ="language_name")
	private String languageName;
	
	@NotBlank(message = "Boş geçilemez!")
	@Column(name = "language_level")
	private char level;
	
	@Column(name = "created_date")
	private Date createdDate;

}