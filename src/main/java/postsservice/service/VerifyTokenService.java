package postsservice.service;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import postsservice.domain.User;

@Service
public class VerifyTokenService {
  private final RestTemplate restTemplate = new RestTemplate();

  public void verifyToken(HttpServletRequest request) {
    String token = request.getHeader("x-access-token");
    String url = "https://user-service-bosi.herokuapp.com/api/verify-token";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.set("x-access-token", token);

    HttpEntity<String> entity = new HttpEntity<>("{}", headers);
    ResponseEntity<String> response = this.restTemplate.postForEntity(url, entity, String.class);
    if (response.getStatusCode() == HttpStatus.OK) {
      System.out.println(response.getBody());
      System.out.println(response.toString());
    }
  }
}
