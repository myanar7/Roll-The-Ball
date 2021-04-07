
//Bahadýr Alacan 150118042
//Mustafa Yanar 150118048
import javafx.scene.image.ImageView;

public class Tile {

	private int position;// For the beginning same with id. When tiles move, position value changes but id value remains constant.
	private int id;
	private String type;
	private String property;
	private ImageView image;

	public Tile(int id, String type, String property) {// Assign values.
		this.id = id;
		this.type = type;
		this.property = property;
	}

	public void setCoordinate(int position) {// Set every tiles coordinate by using their position value.
		int x = (int) ((position - 1) % 4);
		int y = (int) ((position - 1) / 4);
		this.image.setX(100 * x);
		this.image.setY(100 * y);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public ImageView getImage() {
		return image;
	}

	public void setImage(ImageView image) {
		this.image = image;
		this.image.setFitHeight(100);// Edit image's size.
		this.image.setFitWidth(100);
		setPosition(id);
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int id) {
		this.position = id;
		setCoordinate(position);
	}
}
