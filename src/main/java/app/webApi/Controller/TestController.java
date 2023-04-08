package app.webApi.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashcards")
public class TestController {
    @GetMapping("/{requestedId}")
    public ResponseEntity<String> findById() {
        return ResponseEntity.ok("{" +
                "test:test"+
                "}");
    }

}
