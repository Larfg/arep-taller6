package edu.escuelaing.applbroundrobin;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.util.Random;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class LoadBalancerController {

    String server = "localhost";
    String puerto1 = "34000";
    String puerto2 = "34001";
    String puerto3 = "34002";
    Random random = new Random();

    @GetMapping("/")
    public ResponseEntity<String> getIndex() throws IOException {
        Resource resource = new ClassPathResource("static/pagina.html");
        String content = new String(Files.readAllBytes(resource.getFile().toPath()));
        return ResponseEntity.ok().body(content);
    }

    @GetMapping("/get")
    public String get() {
        URI uri;
        int sel = random.nextInt(3);
        if (sel == 0){
            uri = URI.create(String.format("http://%s:%s/logs", server, puerto1));
        }
        if (sel == 1){
            uri = URI.create(String.format("http://%s:%s/logs", server, puerto1));
        }
        else{
            uri = URI.create(String.format("http://%s:%s/logs", server, puerto1));
        }
        return new RestTemplate().getForObject(uri, String.class);
    }

    @PostMapping("/post")
    public String post(@RequestBody String log) {
        URI uri;
        int sel = random.nextInt(3);
        if (sel == 0){
            uri = URI.create(String.format("http://%s:%s/logs", server, puerto1));
        }
        if (sel == 1){
            uri = URI.create(String.format("http://%s:%s/logs", server, puerto1));
        }
        else{
            uri = URI.create(String.format("http://%s:%s/logs", server, puerto1));
        }
        return new RestTemplate().postForObject(uri, log, String.class);
    }

}
