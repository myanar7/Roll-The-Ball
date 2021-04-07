
//Bahadýr Alacan 150118042
//Mustafa Yanar 150118048
import javafx.scene.image.ImageView;

public class EmptyTile extends Tile {

	public EmptyTile(int id, String type, String property) {
		super(id, type, property);// Assign values by using tile class.
		findImage(property);
	}

	public void findImage(String property) {// Set image depending on property value.
		if (property.equalsIgnoreCase("free")) {
			setImage(new ImageView("emptyFree.PNG"));
		} else if (property.equalsIgnoreCase("none")) {
			setImage(new ImageView("emptyNone.PNG"));
		}
	}

}
