package kodlamaio.hrms.entities.concretes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidate_job_advertisemet_favorite")
public class CandidateJobAdvertisementFavorite {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne()
    @JoinColumn(name = "job_advertisement_id")
    private JobAdvertisement jobAdvertisement;
}