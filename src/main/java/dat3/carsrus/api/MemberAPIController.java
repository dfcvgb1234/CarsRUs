package dat3.carsrus.api;

import dat3.carsrus.dto.member.MemberRequest;
import dat3.carsrus.dto.member.MemberResponse;
import dat3.carsrus.entity.Member;
import dat3.carsrus.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/members")
public class MemberAPIController implements API<MemberRequest, MemberResponse, String> {

    @Autowired
    MemberService memberService;

    @SecurityRequirement(name = "")
    @Operation(summary = "Gets a member by username")
    @Override
    public ResponseEntity<MemberResponse> getById(String username) {
        return null;
    }

    // Security: Admin
    @SecurityRequirement(name = "JWT")
    @Operation(summary = "Get all members", responses = {@ApiResponse(responseCode = "200")})
    @GetMapping("")
    public ResponseEntity<List<MemberResponse>> getAll() {
        List<MemberResponse> members = memberService.getAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    // Security: Anonymous
    @Operation(summary = "Adds a new member", responses = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "400")})
    @PostMapping("")
    public ResponseEntity<Void> addNew(MemberRequest body) {
        memberService.addNew(body);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteById(String username) {
        return null;
    }

    @Override
    public ResponseEntity<Void> update(String username, MemberRequest body) {
        return null;
    }
}
