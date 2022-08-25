package dat3.RepositoryTests;

import dat3.RepositoryTests.Tests.CarRepositoryTests;
import dat3.RepositoryTests.Tests.MemberRepositoryTests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class RepositoryTests {

    private static List<Repository> testRepositories;

    public RepositoryTests() {
        testRepositories = new ArrayList<>();
        testRepositories.add(new CarRepositoryTests());
        testRepositories.add(new MemberRepositoryTests());
    }

    @BeforeAll
    public static void prepareTestData() {
        for (Repository repo : testRepositories) {
            repo.prepareTestData();
        }
    }

    @Test
    public void testCreate() {
        for (Repository repo : testRepositories) {
            repo.testCreate();
        }
    }

    @Test
    public void testRead() {
        for (Repository repo : testRepositories) {
            repo.testRead();
        }
    }

    @Test
    public void testUpdate() {
        for (Repository repo : testRepositories) {
            repo.testUpdate();
        }
    }

    @Test
    public void testDelete() {
        for (Repository repo : testRepositories) {
            repo.testDelete();
        }
    }

    @Test
    public void testMethods() {
        for (Repository repo : testRepositories) {
            repo.testMethods();
        }
    }
}
