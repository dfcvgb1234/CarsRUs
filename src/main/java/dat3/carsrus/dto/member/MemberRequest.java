package dat3.carsrus.dto.member;

import dat3.carsrus.dto.DTO;
import dat3.carsrus.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberRequest implements DTO<Member> {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String street;
    private String city;
    private int zipCode;

    @Override
    public Member convertToEntity() {
        return new Member(username, password, email, firstName, lastName, street, city, zipCode);
    }

    @Override
    public Member updateEntity(Member entity) {
        entity.setFirstName(this.firstName);
        entity.setLastName(this.lastName);
        entity.setUsername(this.username);
        entity.setPassword(this.password);
        entity.setEmail(this.email);
        entity.setStreet(this.street);
        entity.setCity(this.city);
        entity.setZipCode(this.zipCode);

        return entity;
    }

}
