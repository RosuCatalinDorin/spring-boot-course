package app.webApi;

import app.webApi.Model.Photo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PhotosCrudTest {
@Autowired
    TestRestTemplate restTemplate;
@Test
    void createPhoto() throws JsonProcessingException {
    Photo photo = new Photo(UUID.randomUUID().toString(),"test.png");
    ResponseEntity <String> response = restTemplate.postForEntity("/addNewPhoto", photo,String.class);
    System.out.println(response.getBody());
    ObjectMapper objectMapper = new ObjectMapper();
    Photo testPhoto  =  objectMapper.readValue(response.getBody(),Photo.class);
    assertThat(testPhoto.getFileName()).isEqualTo("test.png");
}
}
