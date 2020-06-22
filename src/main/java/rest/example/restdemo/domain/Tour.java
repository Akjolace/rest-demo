package rest.example.restdemo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Tour implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String blurb;

    @Column
    private double price;

    @Column
    private String duration;

    @Column
    private String bullets;

    @Column
    private String keyword;

    @ManyToOne
//    @JoinColumn(name = "tourPackage_id")
    private TourPackage tourPackage;

    @Enumerated(EnumType.STRING)
    private Region region;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;


    protected Tour() {
    }

    public Tour(String title, String description, String blurb, double price,
                String duration, String bullets,  String keyword, TourPackage tourPackage,
                Difficulty difficulty, Region region) {
        this.title = title;
        this.description = description;
        this.blurb = blurb;
        this.price = price;
        this.duration = duration;
        this.bullets = bullets;
        this.keyword = keyword;
        this.tourPackage = tourPackage;
        this.difficulty = difficulty;
        this.region = region;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBlurb() {
        return blurb;
    }

    public double getPrice() {
        return price;
    }

    public String getDuration() {
        return duration;
    }

    public String getBullets() {
        return bullets;
    }

    public String getKeyword() {
        return keyword;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public Region getRegion() {
        return region;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
