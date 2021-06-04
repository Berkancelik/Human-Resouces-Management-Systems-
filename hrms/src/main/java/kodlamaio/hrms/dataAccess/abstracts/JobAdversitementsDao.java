package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdversitements;

public interface JobAdversitementsDao extends JpaRepository<JobAdversitements, Integer> {
	
	@Query("From JobAdversitements where isOpen = true")
	List<JobAdversitements> getAllOpenJobAdversitementsList();
	
	@Query("From JobAdversitements where isOpen = true Order By publishedAt Desc")
	List<JobAdversitements> findAllByOrderByPublishedAtDesc();
	
	@Query("From JobAdversitements where isOpen = true and employer_id =:id")
	List<JobAdversitements> getAllOpenJobAdversitementsByEmployer(int id);

}
