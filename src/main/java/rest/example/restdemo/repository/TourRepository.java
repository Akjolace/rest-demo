package rest.example.restdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import rest.example.restdemo.domain.Region;
import rest.example.restdemo.domain.Tour;

import java.util.List;

@Repository
public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {

    List<Tour> findByRegion(Region region);
}
