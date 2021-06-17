package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("From JobAdvertisement where isOpen = true")
	List<JobAdvertisement> getAllOpenJobAdvertisementList();

	@Query("From JobAdvertisement where isOpen = true Order By publishedAt Desc")
	List<JobAdvertisement> findAllByOrderByPublishedAtDesc();

	@Query("From JobAdvertisement where isOpen = true and employer_id =:id")
	List<JobAdvertisement> getAllOpenJobAdvertisementByEmployer(int id);

	@Query("From JobAdvertisement where is_active=true AND is_open=true Order By published_at DESC")
	List<JobAdvertisement> getAllByIsActiveByEmployee();

	@Query("From JobAdvertisement where is_active=false And is_open=true Order By published_at DESC")
	List<JobAdvertisement> getAllByIsActiveByEmployee_False();

	JobAdvertisement getById(int id);

	List<JobAdvertisement> getAllByEmployerId(int employerId);

	JobAdvertisement findById(int id);
}
