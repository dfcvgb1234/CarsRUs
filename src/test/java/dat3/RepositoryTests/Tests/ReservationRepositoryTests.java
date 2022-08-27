package dat3.RepositoryTests.Tests;

import dat3.RepositoryTests.Repository;
import dat3.carsrus.entity.Car;
import dat3.carsrus.entity.Member;
import dat3.carsrus.entity.Reservation;
import dat3.carsrus.repository.CarRepository;
import dat3.carsrus.repository.MemberRepository;
import dat3.carsrus.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ReservationRepositoryTests implements Repository {

    @Autowired
    CarRepository carRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ReservationRepository reservationRepository;

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
        Member member = new Member("user", "pass", "user@email.dk", "abcdef", "ghijkl", "mnopq", "rstuv", 2600, true, 10);
        Reservation reservation1 = new Reservation(LocalDate.now(), LocalDate.now(), car, member);
        Reservation reservation2 = new Reservation(LocalDate.now().plus(1, ChronoUnit.MONTHS), LocalDate.now().plus(2, ChronoUnit.MONTHS), car, member);

        carRepository.save(car);
        memberRepository.save(member);
        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
    }

    @Override
    public void testCreate() {
        Car car = new Car("brand2", "brand2", 200, 200);
        Member member = new Member("username", "password", "email@provider.com", "firstName", "lastName", "street", "city", 4200, false, 2);
        Reservation reservation = new Reservation(LocalDate.now(), LocalDate.now(), car, member);

        carRepository.save(car);
        memberRepository.save(member);
        reservationRepository.save(reservation);

        Reservation foundReservation = reservationRepository.findById(3).get();
        assertNotNull(foundReservation);
    }

    @Override
    public void testRead() {
        Reservation foundReservation = reservationRepository.findById(1).get();
        assertNotNull(foundReservation);
    }

    @Override
    public void testUpdate() {
        Car car = new Car("brand3", "brand3", 200, 200);

        Reservation foundReservation = reservationRepository.findById(1).get();
        foundReservation.setCar(car);
        carRepository.save(car);
        reservationRepository.save(foundReservation);

        foundReservation = reservationRepository.findById(1).get();
        assertEquals("brand3", foundReservation.getCar().getBrand());
    }

    @Override
    public void testDelete() {
        reservationRepository.deleteById(2);
        assertFalse(reservationRepository.findById(2).isPresent());
    }

    @Override
    public void testMethods() {

    }
}
