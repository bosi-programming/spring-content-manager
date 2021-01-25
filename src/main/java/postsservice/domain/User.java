package postsservice.domain;

import org.springframework.data.annotation.Id;

public class User {
  @Id
  private String id;
  private String username;
  private String authorName;
  private String password;
  private String role;
  private String mainAccount;

  public User() {
  }

  public User(String username, String password, String role, String mainAccount) {
    super();
    this.username = username;
    this.password = password;
    this.role = role;
    this.mainAccount = mainAccount;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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

  public String getMainAccount() {
    return mainAccount;
  }

  public void setMainAccount(String mainAccount) {
    this.mainAccount = mainAccount;
  }
}
