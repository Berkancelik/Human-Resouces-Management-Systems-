package kodlamaio.hrms.entities.concretes;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor


public class User {
	@Id
	@GeneratedValue()
	@Column(name= "id")
	private int id; 
	
	@Column(name= "email_address")
	private String email;
	
	@Column(name= "password")
	private String password;
	
	@Column(name= "created_at")	
	private LocalDate createdAt = LocalDate.now();
	
	@Column(name = "is_active",columnDefinition = "boolean default true")
	private boolean isActive = true;
	
	@Column(name = "is_deleted",columnDefinition = "boolean default false")
	private boolean isDeleted = false; 

}
