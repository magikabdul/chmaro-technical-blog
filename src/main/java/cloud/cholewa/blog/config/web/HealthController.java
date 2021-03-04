package cloud.cholewa.blog.config.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<String> checkStatus() {
        return ResponseEntity.ok("It's alive!");
    }
}
