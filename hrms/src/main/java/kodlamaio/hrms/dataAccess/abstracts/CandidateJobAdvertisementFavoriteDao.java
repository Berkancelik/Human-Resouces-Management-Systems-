package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateJobAdvertisementFavorite;

public interface CandidateJobAdvertisementFavoriteDao extends JpaRepository<CandidateJobAdvertisementFavorite,Integer> {
    List<CandidateJobAdvertisementFavorite> getAllByCandidate_Id(int candidateId);
    CandidateJobAdvertisementFavorite getByCandidate_IdAndJobAdvertisement_Id(int candidateId,int jobAdvertisementId);

}
