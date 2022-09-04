package dat3.carsrus.dto.car;

import dat3.carsrus.dto.DTO;
import dat3.carsrus.entity.Car;
import dat3.carsrus.entity.RentalCompany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarRequest implements DTO<Car> {

    private String brand;
    private String model;
    private int pricePerDay;
    private float bestDiscount;

    @Override
    public Car convertToEntity() {
        return new Car(brand, model, pricePerDay, bestDiscount);
    }

    @Override
    public Car updateEntity(Car entity) {
        entity.setBrand(this.brand);
        entity.setModel(this.model);
        entity.setPricePerDay(this.pricePerDay);
        entity.setBestDiscount(this.bestDiscount);

        return entity;
    }
}
