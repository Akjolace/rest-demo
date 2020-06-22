package rest.example.restdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.example.restdemo.domain.Difficulty;
import rest.example.restdemo.domain.Region;
import rest.example.restdemo.domain.Tour;
import rest.example.restdemo.domain.TourPackage;
import rest.example.restdemo.repository.TourPackageRepository;
import rest.example.restdemo.repository.TourRepository;

@Service
public class TourService {
    private TourPackageRepository tourPackageRepository;
    private TourRepository tourRepository;

    @Autowired
    public TourService(TourPackageRepository tourPackageRepository, TourRepository tourRepository) {
        this.tourPackageRepository = tourPackageRepository;
        this.tourRepository = tourRepository;
    }

    public Tour createTour(String title, String description, String blurb, double price,
                String duration, String bullets, String keyword, String tourPackageCode,
                Difficulty difficulty, Region region) {
        TourPackage tourPackage = tourPackageRepository.findById(tourPackageCode).get();
        if (tourPackage == null) {
            throw new RuntimeException(("Tour package does not exist" + tourPackageCode));
        }
        return tourRepository.save(new Tour(title, description, blurb, price,
                duration, bullets, keyword, tourPackage, difficulty, region));
    }

    public Iterable<Tour> lookup(){
        return tourRepository.findAll();
    }

    public long total(){
        return tourRepository.count();
    }
}
