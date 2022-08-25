package dat3.RepositoryTests.Tests;

import dat3.RepositoryTests.Repository;
import dat3.carsrus.entity.Car;
import dat3.carsrus.entity.Member;
import dat3.carsrus.entity.Rental;
import dat3.carsrus.repository.CarRepository;
import dat3.carsrus.repository.MemberRepository;
import dat3.carsrus.repository.RentalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RentalRepositoryTests implements Repository {

    @Autowired
    CarRepository carRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RentalRepository rentalRepository;

    @Override
    @Test
    public void runTests() {
        prepareTestData();
        testCreate();
        testRead();
        testUpdate();
        testDelete();
        testMethods();
    }

    @Override
    public void prepareTestData() {
        Car car = new Car("brand1", "brand1", 200, 200);
        Member member = new Member("username", "password", "email@provider.com", "firstname", "lastname", "street", "city", 719053, true, 222);
        Rental rental = new Rental(LocalDate.now(), 200, car, member);

        carRepository.save(car);
        memberRepository.save(member);
        rentalRepository.save(rental);
    }

    @Override
    public void testCreate() {
        Car car = new Car("brand2", "brand2", 400, 400);
        Member member = new Member("user", "pass", "email@provider.dk", "prefix", "suffix", "road", "town", 231453, false, 111);
        Rental rental = new Rental(LocalDate.now(), 400, car, member);

        carRepository.save(car);
        memberRepository.save(member);
        rentalRepository.save(rental);

        Rental foundRental = rentalRepository.findById(2).get();
        assertEquals(400, foundRental.getPricePerDay());
    }

    @Override
    public void testRead() {
        Rental foundRental = rentalRepository.findById(1).get();
        assertEquals(200, foundRental.getPricePerDay());
    }

    @Override
    public void testUpdate() {
        Rental foundRental = rentalRepository.findById(1).get();
        foundRental.setPricePerDay(800);
        rentalRepository.save(foundRental);

        foundRental = rentalRepository.findById(1).get();
        assertEquals(800, foundRental.getPricePerDay());
    }

    @Override
    public void testDelete() {
        rentalRepository.deleteById(2);
        assertFalse(rentalRepository.findById(2).isPresent());
    }

    @Override
    public void testMethods() {

    }
}
