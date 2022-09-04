package dat3.carsrus.api;

import dat3.carsrus.dto.car.CarRequest;
import dat3.carsrus.dto.car.CarResponse;
import dat3.carsrus.dto.member.MemberResponse;
import dat3.carsrus.repository.CarRepository;
import dat3.carsrus.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cars")
public class CarAPIController implements API<CarRequest, CarResponse, Integer> {

    @Autowired
    CarService carService;

    @Override
    public ResponseEntity<CarResponse> getById(Integer integer) {
        return null;
    }

    @SecurityRequirement(name = "JWT")
    @Operation(summary = "Get all cars", responses = {@ApiResponse(responseCode = "200")})
    @GetMapping("")
    @Override
    public ResponseEntity<List<CarResponse>> getAll() {
        List<CarResponse> members = carService.getAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @SecurityRequirement(name = "JWT")
    @Operation(summary = "add new car", responses = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "400")})
    @PostMapping("")
    @Override
    public ResponseEntity<Void> addNew(@RequestBody CarRequest body) {
        carService.addNew(body);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteById(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<Void> update(Integer integer, CarRequest body) {
        return null;
    }
}
