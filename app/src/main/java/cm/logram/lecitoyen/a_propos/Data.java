package cm.logram.lecitoyen.a_propos;

public class Data {
  private int image;
  private String title;

  public Data() {
  }

  public Data(int image, String title) {
    this.image = image;
    this.title = title;
  }
  public int getImage() {
    return image;
  }
  public void setImage(int image1) {
    this.image = image1;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String name) {
    this.title = name;
  }
}