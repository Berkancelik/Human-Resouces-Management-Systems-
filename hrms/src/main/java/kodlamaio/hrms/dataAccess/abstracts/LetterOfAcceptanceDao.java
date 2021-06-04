package kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.LetterOfAcceptance;

public interface LetterOfAcceptanceDao extends JpaRepository<LetterOfAcceptance, Integer> {
	LetterOfAcceptance getById(int id);



}
