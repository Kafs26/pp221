package hiber.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cars")
public class Car implements Serializable {

    @Id
    @OneToOne
    @MapsId
    private User user;

    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;


    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    @Override
    public String toString() {
        return "model='" + model + '\'' +
                ", series=" + series;
    }
}
