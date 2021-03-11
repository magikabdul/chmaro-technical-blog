package cloud.cholewa.blog.config.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
public class CreatedURI {
    private final String path;

    public URI uri() {
        return ServletUriComponentsBuilder.fromCurrentRequest().path(path).build().toUri();
    }
}
