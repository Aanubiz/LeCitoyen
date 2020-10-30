package cm.logram.lecitoyen.items;

public class Data {
  private String titre;
  private int image;

  public Data(String titre, int image) {
    this.titre = titre;
    this.image = image;
  }

  public String getTitle() {
    return titre;
  }

  public void setTitle(String name) {
    this.titre = name;
  }
  public int getImage() {
    return image;
  }
  public void setImage(int image) {
    this.image = image;
  }

}
