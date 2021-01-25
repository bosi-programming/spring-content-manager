package postsservice.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import postsservice.domain.Post;
import postsservice.domain.PostRepository;
import postsservice.domain.User;
import postsservice.domain.UserRepository;

@RestController
public class PostController {
  @Autowired
  private PostRepository repository;
  @Autowired
  private UserRepository userRepository;
  private User user;

  @RequestMapping(value = "/api/posts", method = RequestMethod.POST)
  public Iterable<Post> postPosts(Principal principal) {
    Boolean isUser = userRepository.existsByUsername(principal.getName());

    if (isUser) {
      user = userRepository.findByUsername(principal.getName());
    }

    if (user.getRole() == "admin") {
      return repository.findByMainAccount(user.getMainAccount());
    }

    return repository.findByAuthor(principal.getName());
  }

  @RequestMapping(value = "/api/posts", method = RequestMethod.GET)
  public Iterable<Post> getPosts(Principal principal, @RequestParam(value = "title", required = false) String title) {
    Boolean isUser = userRepository.existsByUsername(principal.getName());

    if (isUser) {
      user = userRepository.findByUsername(principal.getName());
    }

    if (user.getRole() == "viewer") {
      return repository.findByMainAccount(user.getMainAccount());
    }
    if (!StringUtils.isEmpty(title)) {
      return repository.findByTitleAndAuthor(title, principal.getName());
    }

    return repository.findByAuthor(principal.getName());
  }
}
