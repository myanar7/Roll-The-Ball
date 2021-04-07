
//Bahadýr Alacan 150118042
//Mustafa Yanar 150118048
import javafx.scene.image.ImageView;

public class EndTile extends Tile {

	public EndTile(int id, String type, String property) {
		super(id, type, property);// Assign values by using tile class.
		findImage(property);
	}

	public void findImage(String property) {// Set image depending on property value.
		if (property.equalsIgnoreCase("horizontal")) {
			setImage(new ImageView("endHorizontal.PNG"));
		} else if (property.equalsIgnoreCase("vertical")) {
			setImage(new ImageView("endVertical.PNG"));
		}

	}

}
