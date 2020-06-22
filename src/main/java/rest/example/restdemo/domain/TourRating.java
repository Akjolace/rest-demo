package rest.example.restdemo.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class TourRating {
    @EmbeddedId
    private TourRatingPk pk;

    @Column(nullable = false)
    private Integer score;

    @Column
    private String comment;

    protected TourRating() {
    }

    public TourRatingPk getPk() {
        return pk;
    }

    public Integer getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public TourRating(TourRatingPk pk, Integer score, String comment){
        this.pk = pk;
        this.score = score;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "TourRating{" +
                "pk=" + pk +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }
}
