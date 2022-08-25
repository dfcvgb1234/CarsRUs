package dat3.carsrus.repository;

import dat3.carsrus.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

    List<Member> findByFirstNameAndLastName(String firstName, String lastName);
}
