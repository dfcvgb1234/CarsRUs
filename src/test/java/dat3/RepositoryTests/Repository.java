package dat3.RepositoryTests;

public interface Repository {

    void runTests();

    void prepareTestData();

    void testCreate();
    void testRead();
    void testUpdate();
    void testDelete();

    void testMethods();
}
