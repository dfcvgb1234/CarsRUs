package dat3.RepositoryTests.Tests;

import dat3.RepositoryTests.Repository;
import dat3.carsrus.entity.Rental;
import dat3.carsrus.entity.RentalCompany;
import dat3.carsrus.repository.RentalCompanyRepository;
import dat3.carsrus.repository.RentalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RentalCompanyRepositoryTests implements Repository {

    @Autowired
    RentalCompanyRepository rentalCompanyRepository;

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
        RentalCompany company1 = new RentalCompany("name1");
        RentalCompany company2 = new RentalCompany("name2");

        rentalCompanyRepository.save(company1);
        rentalCompanyRepository.save(company2);
    }

    @Override
    public void testCreate() {
        RentalCompany createdCompany = new RentalCompany("name3");

        rentalCompanyRepository.save(createdCompany);

        RentalCompany foundCompany = rentalCompanyRepository.findById(3).get();
        assertNotNull(foundCompany);
    }

    @Override
    public void testRead() {
        RentalCompany foundCompany = rentalCompanyRepository.findById(1).get();
        assertNotNull(foundCompany);
    }

    @Override
    public void testUpdate() {
        RentalCompany foundCompany = rentalCompanyRepository.findById(1).get();
        foundCompany.setName("name4");
        rentalCompanyRepository.save(foundCompany);

        foundCompany = rentalCompanyRepository.findById(1).get();
        assertEquals("name4", foundCompany.getName());
    }

    @Override
    public void testDelete() {
        rentalCompanyRepository.deleteById(2);
        assertFalse(rentalCompanyRepository.findById(2).isPresent());
    }

    @Override
    public void testMethods() {
        int foundCompanyAmount = rentalCompanyRepository.findByName("name1").size();
        assertEquals(1, foundCompanyAmount);
    }
}
