package dat3.RepositoryTests.Tests;

import dat3.RepositoryTests.Repository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class RentalCompanyRepositoryTests implements Repository {

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

    }

    @Override
    public void testCreate() {

    }

    @Override
    public void testRead() {

    }

    @Override
    public void testUpdate() {

    }

    @Override
    public void testDelete() {

    }

    @Override
    public void testMethods() {

    }
}
