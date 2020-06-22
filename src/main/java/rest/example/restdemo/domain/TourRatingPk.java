package rest.example.restdemo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TourRatingPk implements Serializable {

    @ManyToOne
    private Tour tour;

    @Column(insertable = false, updatable = false, nullable = false)
    private Integer customerId;

    public TourRatingPk() {
    }

    public TourRatingPk(Tour tour, Integer customerId) {
        this.customerId = customerId;
        this.tour = tour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourRatingPk that = (TourRatingPk) o;
        return Objects.equals(tour, that.tour) &&
                Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public Tour getTour() {
        return tour;
    }

    public Integer getCustomerId() {
        return customerId;
    }
}

