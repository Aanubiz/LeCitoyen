package cm.logram.lecitoyen.items;

/**
 * The {@link MenuRegle} class.
 * <p>Defines the attributes for a restaurant menu item.</p>
 */
public class MenuRegle {

    private final String titre;
    private final String image;

    public MenuRegle(String titre, String image) {
        this.titre = titre;
        this.image = image;
    }

    public String getTitre() {
        return titre;
    }

    public String getImageName() {
        return image;
    }
}
