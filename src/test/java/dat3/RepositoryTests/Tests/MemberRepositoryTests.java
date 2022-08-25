package dat3.RepositoryTests.Tests;

import dat3.RepositoryTests.Repository;
import dat3.carsrus.entity.Member;
import dat3.carsrus.repository.MemberRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

public class MemberRepositoryTests implements Repository {

    @Autowired
    MemberRepository memberRepository;

    public void testFindByFirstAndLastname() {

        int foundMembersCount = memberRepository.findByFirstNameAndLastName("abcdef", "ghijkl").size();
        assertEquals(1, foundMembersCount);
    }

    @Override
    public void prepareTestData() {
        Member member1 = new Member("user", "pass", "user@email.dk", "abcdef", "ghijkl", "mnopq", "rstuv", 2600, true, 10);
        Member member2 = new Member("anotherUser", "pass", "user@email.dk","qwerty", "asdfgh", "zxcvb", "yuiop", 5632, false, 2);

        memberRepository.save(member1);
        memberRepository.save(member2);
    }

    @Override
    public void testCreate() {
        Member createdMember = new Member("newUsername", "newPassword", "newEmail@service.dk", "testName", "testLastName", "testStreet", "testCity", 1234, true, 10);

        memberRepository.save(createdMember);

        Member foundMember = memberRepository.findById(createdMember.getUsername()).get();

        assertNotNull(foundMember);
    }

    @Override
    public void testRead() {
        Member foundMember = memberRepository.findById("user").get();

        assertNotNull(foundMember);
    }

    @Override
    public void testUpdate() {
        Member foundMember = memberRepository.findById("user").get();

        foundMember.setFirstName("changedFirstName");
        memberRepository.save(foundMember);

        foundMember = memberRepository.findById("user").get();
        assertEquals("changedFirstName", foundMember.getFirstName());
    }

    @Override
    public void testDelete() {
        memberRepository.deleteById("anotherUser");

        assertFalse(memberRepository.findById("newUsername").isPresent());
    }

    @Override
    public void testMethods() {
        testFindByFirstAndLastname();
    }
}
