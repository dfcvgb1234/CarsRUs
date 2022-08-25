package dat3.carsrus.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Reservation extends EntityBase {

    private LocalDate reservationDate;
    private LocalDate rentalDate;

    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "member_id", referencedColumnName = "username")
    private Member member;
}
