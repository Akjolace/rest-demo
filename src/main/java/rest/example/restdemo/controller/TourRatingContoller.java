package rest.example.restdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rest.example.restdemo.domain.Tour;
import rest.example.restdemo.domain.TourRating;
import rest.example.restdemo.domain.TourRatingPk;
import rest.example.restdemo.repository.TourRatingRepository;
import rest.example.restdemo.repository.TourRepository;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingContoller {
    TourRatingRepository tourRatingRepository;
    TourRepository tourRepository;

    @Autowired
    public TourRatingContoller(TourRatingRepository tourRatingRepository, TourRepository tourRepository) {
        this.tourRatingRepository = tourRatingRepository;
        this.tourRepository = tourRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourRating(@PathVariable(value = "tourId") int tourId,
                                 @RequestBody @Validated RatingDto ratingDto){
        Tour tour = verifyTour(tourId);
        tourRatingRepository.save(new TourRating(new TourRatingPk(tour,
                ratingDto.getCustomerId()), ratingDto.getScore(), ratingDto.getComment()));

    }

    protected TourRatingContoller() {
    }

    private Tour verifyTour(int tourId) throws NoSuchElementException{
        Tour tour = tourRepository.findById(tourId).get();
        if(tour == null){
            throw new NoSuchElementException("Tour does not exist " + tourId);
        }
        return tour;
    }

    private RatingDto toDto(TourRating tourRating){
        return new RatingDto(tourRating.getScore(), tourRating.getComment(), tourRating.getPk().getCustomerId());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex){
        return ex.getMessage();
    }
}
