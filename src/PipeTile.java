
//Bahadýr Alacan 150118042
//Mustafa Yanar 150118048
import javafx.scene.image.ImageView;

public class PipeTile extends Tile {

	public PipeTile(int id, String type, String property) {
		super(id, type, property);// Assign values by using tile class.
		findImage(property);
	}

	public void findImage(String property) {// Set image depending on property value.
		if (property.equalsIgnoreCase("horizontal")) {
			setImage(new ImageView("pipeHorizontal.PNG"));
		} else if (property.equalsIgnoreCase("00")) {
			setImage(new ImageView("curvedPipe00.PNG"));
		} else if (property.equalsIgnoreCase("01")) {
			setImage(new ImageView("curvedPipe01.PNG"));
		} else if (property.equalsIgnoreCase("10")) {
			setImage(new ImageView("curvedPipe10.PNG"));
		} else if (property.equalsIgnoreCase("11")) {
			setImage(new ImageView("curvedPipe11.PNG"));
		} else if (property.equalsIgnoreCase("vertical")) {
			setImage(new ImageView("pipeVertical.PNG"));
		}

	}

}
