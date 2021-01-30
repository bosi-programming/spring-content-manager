package postsservice.domain;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;

public class Post {
  @Id
  private String id;

  private String mainAccount;
  private String author;
  private String authorUserName;
  private String mainAccount;
  private LocalDate date;
  private String title;
  private String content;

  public String getMainAccount() {
    return mainAccount;
  }

  public void setMainAccount(String mainAccount) {
    this.mainAccount = mainAccount;
  }
  public String getAuthor() {
    return author;
  }

  public String getMainAccount() {
    return mainAccount;
  }

  public void setMainAccount(String mainAccount) {
    this.mainAccount = mainAccount;
  }

  public void setAuthor(String author) {
    this.author = author;
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
