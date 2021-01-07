package postsservice.web;

import postsservice.Post;
import postsservice.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
  @Autowired
  private PostRepository repository;

  @RequestMapping("/posts")
  public Iterable<Post> getPosts() {
    return repository.findAll();
  }
}


