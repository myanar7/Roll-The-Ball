
//Bahadýr Alacan 150118042
//Mustafa Yanar 150118048
import javafx.scene.image.ImageView;

public class StarterTile extends Tile {

	public StarterTile(int id, String type, String property) {
		super(id, type, property);// Assign values by using tile class.
		findImage(property);
	}

	public void findImage(String property) {// Set image depending on property value.
		if (property.equalsIgnoreCase("horizontal")) {
			setImage(new ImageView("starterHorizontal.PNG"));
		} else if (property.equalsIgnoreCase("vertical")) {
			setImage(new ImageView("starterVertical.PNG"));
		}

	}

}
