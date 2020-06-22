package rest.example.restdemo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import rest.example.restdemo.domain.TourRating;
import rest.example.restdemo.domain.TourRatingPk;

import java.util.List;

@RepositoryRestResource(exported = false)

public interface TourRatingRepository extends PagingAndSortingRepository<TourRating, TourRatingPk> {
    List<TourRating> findByPkTourId(Integer tourId);

    TourRating findByPkTourIdAndPkCustomerId(Integer tourId, Integer CustomerId);
}
