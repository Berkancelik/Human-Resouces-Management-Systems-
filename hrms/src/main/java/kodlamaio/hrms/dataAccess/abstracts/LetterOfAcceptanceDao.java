package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.LetterOfAcceptance;

public interface LetterOfAcceptanceDao extends JpaRepository<LetterOfAcceptance, Integer> {
	List<LetterOfAcceptance> getAllByCandidateId(int candidateId);



}
