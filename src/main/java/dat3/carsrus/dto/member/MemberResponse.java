package dat3.carsrus.dto.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.carsrus.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberResponse {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String street;
    private String city;
    private int zipCode;
    private boolean approved;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime edited;
    private Integer ranking;

    public MemberResponse(Member member, Boolean includeAll) {
        this.username = member.getUsername();
        this.email = member.getEmail();
        this.street = member.getStreet();
        this.firstName =member.getFirstName();
        this.lastName = member.getLastName();
        this.city = member.getCity();
        this.zipCode = member.getZipCode();
        if(includeAll){
            this.created = member.getCreated();
            this.edited = member.getEdited();
            this.ranking = member.getRanking();
        }
    }

}
