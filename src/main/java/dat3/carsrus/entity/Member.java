package dat3.carsrus.entity;

import dat3.security.entity.UserWithRoles;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class Member extends UserWithRoles {

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastEdited;

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private int zipCode;
    private boolean approved;
    private int ranking;

    public Member(String username, String password, String email, String firstName, String lastName, String street, String city, int zipCode, boolean approved, int ranking) {
        super(username, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.approved = approved;
        this.ranking = ranking;
    }
}
