package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByEmployer_CompanyName(String companyName);

	List<JobAdvertisement> getByIsConfirm(boolean isConfirm);

	List<JobAdvertisement> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive);
	
	JobAdvertisement getById(int id);

	@Modifying
	@Transactional
	@Query("update JobAdvertisement u set u.isConfirm=:isConfirm where u.id=:id ")
	void updateIsConfirm(boolean isConfirm, int id);

	@Modifying
	@Transactional
	@Query("update JobAdvertisement u set u.isActive=:isActive where u.employer.id=:id and u.id=:id ")
	void updateIsActive(boolean isActive,  int id);
}
