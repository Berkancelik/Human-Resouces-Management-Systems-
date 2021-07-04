package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementFilter;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByEmployer_CompanyName(String companyName);

	List<JobAdvertisement> getByIsConfirm(boolean isConfirm);

	Page<JobAdvertisement> getByIsConfirmAndIsActive(boolean isConfirm, boolean isActive, Pageable pageable);
	
	JobAdvertisement getById(int id);

	@Modifying
	@Transactional
	@Query("update JobAdvertisement u set u.isConfirm=:isConfirm where u.id=:id ")
	void updateIsConfirm(boolean isConfirm, int id);

	@Modifying
	@Transactional
	@Query("update JobAdvertisement u set u.isActive=:isActive where u.employer.id=:id and u.id=:id ")
	void updateIsActive(boolean isActive,  int id);
	
	@Query("Select j from kodlamaio.hrms.entities.concretes.JobAdvertisement j where "
			+ "((:#{#filter.jobTitleId}) IS NULL OR j.jobTitle.id IN (:#{#filter.jobTitleId})) "
			+ "and ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId})) "
			+ "and ((:#{#filter.workTypeId}) IS NULL OR j.workType.id IN (:#{#filter.workTypeId})) "
			+ "and ((:#{#filter.workHourId}) IS NULL OR j.workHour.id IN (:#{#filter.workHourId})) "
			+ "and j.isActive = true " + "and j.isConfirm = true")
	Page<JobAdvertisement> getByFilter(@Param("filter") JobAdvertisementFilter jobAdvertisementFilter, Pageable pageable);
}