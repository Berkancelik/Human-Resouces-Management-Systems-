package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertConfirm;

public interface JobAdvertConfirmDao extends JpaRepository<JobAdvertConfirm, Integer>{
	JobAdvertConfirm getByJobAdvertId(int jobAdvertId);

}
