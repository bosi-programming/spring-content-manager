package postsservice.domain;

import org.springframework.data.annotation.Id;

public class User {
  @Id
  private String _id;
  private String userName;
  private String authorName;
  private String password;
  private String role;

  public User() {
  }

  public User(String userName, String password, String role) {
    super();
    this.userName = userName;
    this.password = password;
    this.role = role;
  }

  public String getId() {
    return _id;
  }

  public void setId(String _id) {
    this._id = _id;
  }

  public String getUsername() {
    return userName;
  }

  public void setUsername(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }
}
