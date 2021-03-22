package postsservice;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import postsservice.service.VerifyTokenService;

@Component
@Order(1)
public class AuthenticationFilter extends GenericFilterBean {
  private VerifyTokenService verifyToken = new VerifyTokenService();

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {
    ObjectMapper mapper = new ObjectMapper();
    String userJson = verifyToken.verifyToken((HttpServletRequest) request);

    Map<String, Object> user = mapper.readValue(userJson, Map.class);

    System.out.println(user.get("userName"));
    request.setAttribute("user", user);

    filterChain.doFilter(request, response);
  }

  @Override
  public void destroy() {
  }
}
