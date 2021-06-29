package kodlamaio.hrms.dataAccess.abstracts;

import java.awt.print.Pageable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	/*@Query("Select j from kodlamaio.hrms.entities.concretes.JobAdvertisement j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
			+ " and ((:#{#filter.jobTitleId}) IS NULL OR j.jobTitle.id IN (:#{#filter.jobTitleId}))"
			+ " and ((:#{#filter.workHourId}) IS NULL OR j.workHour.id IN (:#{#filter.workHourId}))"
			+ " and ((:#{#filter.workTypeId}) IS NULL OR j.workType.id IN (:#{#filter.workTypeId}))")*/
	//List<JobAdvertisement> getByFilter(@Param("filter") JobAdvertisementFilter jobAdvertisementFilter, Pageable pageable);
}
