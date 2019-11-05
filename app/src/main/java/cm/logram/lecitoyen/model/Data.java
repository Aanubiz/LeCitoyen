package cm.logram.lecitoyen.model;

public class Data {

	private int id;
	String titre, article,description;

	public String getTitre(){
		return titre;
	}
	public String getArticle() {
		return article;
	}
	public String getDescription(){
		return description;
	}
	public Data(String titre, String heading, String description) {
		this.titre = titre;
		this.article = heading;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}