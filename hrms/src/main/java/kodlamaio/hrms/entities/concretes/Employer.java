package kodlamaio.hrms.entities.concretes;

import java.util.List;
import java.util.Map;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.vladmihalcea.hibernate.type.json.JsonType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@Table(name = "employers")
@TypeDef(name = "json",typeClass = JsonType.class)

public class Employer extends User{


	@Column(name = "company_name")
	private String companyName;
	

	@Column(name = "web_address")
	private String webAddress;

	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "confirm_status",columnDefinition = "boolean default false")
	private boolean confirmStatus;
	
	@Column(name = "employer_update",columnDefinition = "jsonb")
	@Type(type = "json")
	private Map<String, Object> employerUpdate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
}