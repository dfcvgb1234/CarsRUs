package dat3.carsrus.api;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface API<RequestType, ResponseType, ID> {

    ResponseEntity<ResponseType> getById(@PathVariable ID id);

    ResponseEntity<List<ResponseType>> getAll();

    ResponseEntity<Void> addNew(@RequestBody RequestType body);

    ResponseEntity<Void> deleteById(@PathVariable ID id);

    ResponseEntity<Void> update(@PathVariable ID id, @RequestBody RequestType body);
}
