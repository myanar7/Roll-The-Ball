
//Bahadýr Alacan 150118042
//Mustafa Yanar 150118048
import javafx.scene.image.ImageView;

public class PipeStaticTile extends Tile {

	public PipeStaticTile(int id, String type, String property) {
		super(id, type, property);// Assign values by using tile class.
		findImage(property);
	}

	public void findImage(String property) {// Set image depending on property value.
		if (property.equalsIgnoreCase("horizontal")) {
			setImage(new ImageView("pipeStaticHorizontal.PNG"));
		} else if (property.equalsIgnoreCase("vertical")) {
			setImage(new ImageView("pipeStaticVertical.PNG"));
		} else if (property.equalsIgnoreCase("01")) {
			setImage(new ImageView("pipeStatic01.PNG"));
		}

	}

}
