package dat3.carsrus.service;

import dat3.carsrus.dto.car.CarRequest;
import dat3.carsrus.dto.car.CarResponse;
import dat3.carsrus.dto.member.MemberResponse;
import dat3.carsrus.entity.Car;
import dat3.carsrus.entity.Member;
import dat3.carsrus.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService extends dat3.carsrus.service.Service<Car, CarRequest, CarResponse, Integer> {

    @Autowired
    CarRepository carRepository;

    @Override
    public CarResponse getById(Integer id) {
        return super.getById(id, carRepository, CarResponse.class, Car.class);
    }

    @Override
    public List<CarResponse> getAll() {
        return super.getAll(carRepository, CarResponse.class, Car.class);
    }

    @Override
    public void addNew(CarRequest body) {
        super.addNew(body, carRepository);
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id, carRepository);
    }

    @Override
    public void updateById(Integer id, CarRequest body) {
        super.updateById(id, body, carRepository);
    }
}
