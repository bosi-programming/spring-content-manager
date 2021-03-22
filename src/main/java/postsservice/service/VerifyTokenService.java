package postsservice.service;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class VerifyTokenService {
  private final RestTemplate restTemplate = new RestTemplate();

  public String verifyToken(HttpServletRequest request) {
    String token = request.getHeader("x-access-token");
    String url = "https://user-service-bosi.herokuapp.com/api/verify-token";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.set("x-access-token", token);

    HttpEntity<String> entity = new HttpEntity<>("{}", headers);
    ResponseEntity<String> response = this.restTemplate.postForEntity(url, entity, String.class);
    if (response.getStatusCode() == HttpStatus.OK) {
      return response.getBody();
    } else {
      return "Error validating token";
    }
  }
}
