package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Employer getById(int id);
	boolean existsEmployerByEmail(String email);
	List<Employer> getByConfirmStatusFalse();



}
