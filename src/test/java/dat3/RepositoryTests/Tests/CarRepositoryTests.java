package dat3.RepositoryTests.Tests;

import dat3.RepositoryTests.Repository;
import dat3.carsrus.entity.Car;
import dat3.carsrus.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class CarRepositoryTests implements Repository {

    @Autowired
    CarRepository carRepository;

    @Override
    public void prepareTestData() {
        Car car1 = new Car("brand1", "model1", 1000, 250);
        Car car2 = new Car("brand2", "model2", 2000,500);

        carRepository.save(car1);
        carRepository.save(car2);
    }

    @Override
    public void testCreate() {
        Car newCar = new Car("brand3", "model3", 3000, 1000);
        carRepository.save(newCar);

        Car foundCar = carRepository.findById(3).get();
        assertEquals("brand3", foundCar.getBrand());
    }

    @Override
    public void testRead() {
        Car foundCar = carRepository.findById(1).get();

        assertEquals("brand1", foundCar.getBrand());
    }

    @Override
    public void testUpdate() {
        Car foundCar = carRepository.findById(1).get();
        foundCar.setBrand("brand4");
        carRepository.save(foundCar);

        foundCar = carRepository.findById(1).get();
        assertEquals("brand4", foundCar.getBrand());
    }

    @Override
    public void testDelete() {
        carRepository.deleteById(2);

        assertFalse(carRepository.findById(2).isPresent());

    }

    @Override
    public void testMethods() {

    }
}
