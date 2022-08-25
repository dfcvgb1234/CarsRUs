package dat3.carsrus.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class Car extends EntityBase{

    private String brand;
    private String model;
    private int pricePerDay;
    private float bestDiscount;

    @ManyToOne(targetEntity = RentalCompany.class)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private RentalCompany company;

    public Car(String brand, String model, int pricePerDay, float bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.bestDiscount = bestDiscount;
    }
}
