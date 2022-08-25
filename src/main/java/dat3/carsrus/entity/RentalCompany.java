package dat3.carsrus.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter @NoArgsConstructor
public class RentalCompany extends EntityBase {

    private String name;

    @OneToMany(targetEntity = Car.class)
    private List<Car> cars;

    public RentalCompany(String name) {
        this.name = name;
        cars = new ArrayList<>();
    }
}
