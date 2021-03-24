package postsservice.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> { 
    User findByUsername(String username);
    Boolean existsByUsername(String username);
}

