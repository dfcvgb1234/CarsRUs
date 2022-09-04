package dat3.carsrus.dto.car;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.carsrus.entity.Car;
import dat3.carsrus.entity.RentalCompany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {

    private String brand;
    private String model;
    private int pricePerDay;
    private float bestDiscount;

    private RentalCompany company;

    public CarResponse(Car car, Boolean showCompany) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.pricePerDay = car.getPricePerDay();
        this.bestDiscount = car.getBestDiscount();

        if (showCompany) {
            this.company = car.getCompany();
        }
    }
}
