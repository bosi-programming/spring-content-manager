package postsservice.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends MongoRepository<Post, String> {
  List<Post> findByTitle(@Param("title") String title);

  List<Post> findByAuthorName(@Param("authorName") String authorName);

  List<Post> findByMainAccount(@Param("mainAccount") String mainAccount);

  List<Post> findByTitleAndMainAccount(@Param("title") String title, @Param("mainAccount") String mainAccount);

  List<Post> findByTitleAndAuthorName(@Param("title") String title, @Param("AuthorName") String authorName);
}
