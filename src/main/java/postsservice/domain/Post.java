package postsservice.domain;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class Post {
  @Id
  private String id;

  private String authorName;
  private String authorUserName;
  private String mainAccount;
  private LocalDate date;
  private String title;
  private String content;

  public Post() {
  }

  public Post(User user, Map<String, Object> postJson) {
    super();
    this.authorName = user.getAuthorName();
    this.authorUserName = user.getUsername();
    this.mainAccount = user.getMainAccount();
    this.date = LocalDate.parse(postJson.get("date").toString());
    this.title = postJson.get("title") != null ? postJson.get("title").toString() : null;
    this.content = postJson.get("content") != null ? postJson.get("content").toString() : null;
  }

  public Post(String id, String authorName, String authorUserName, String mainAccount, LocalDate date, String title,
      String content) {
    super();
    this.authorName = authorName;
    this.authorUserName = authorUserName;
    this.mainAccount = mainAccount;
    this.date = date;
    this.title = title;
    this.content = content;
  }

  public String getAuthorName() {
    return authorName;
  }

  public String getMainAccount() {
    return mainAccount;
  }

  public void setMainAccount(String mainAccount) {
    this.mainAccount = mainAccount;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getAuthorUserName() {
    return authorUserName;
  }

  public void setAuthorUserName(String authorUserName) {
    this.authorUserName = authorUserName;
  }

}
