
/*This game is a puzzle game. The game is satisfied to play a game, to spend free times, 
to be gained thinking and solving problem abilities for children. You can test your brain on 5 different and hard level. 
The main aim of the game is to find correct path due to fact that the ball reach final tile.
If you figure out to the correct path, you can pass the next level.
Bahadýr Alacan 150118042
Mustafa Yanar 150118048
  */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameBoard extends Application {
	private boolean pathController;
	private Stage window;
	private Circle ball;
	private String fileName;
	private int movement;
	private PathTransition pathTransition = new PathTransition();
	private ArrayList<Tile> tile = new ArrayList<Tile>();
	private ImageView playButtonImage = new ImageView("playButton2.png");
	private Pane pane = new Pane();
	private Button nextButton = new Button("Next");
	private Scene scene = new Scene(pane, 400, 425);
	private Text nextLevelText = new Text("Congratulations, you can skip next level.");
	private Text movementText = new Text("Movement: " + getMovement());

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		setMainMenu();// Add main menu to pane.
		playButtonImage.setOnMouseClicked(e -> {// If player click play button, program starts read first file.
			try {
				setFile("level1.txt");// Create game board.
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		window = primaryStage;
		window.setTitle("Find The Path");// Set the title of game.
		window.setScene(scene);
		window.show();
	}

	public void setMainMenu() {
		Text gameName = new Text("FIND THE PATH");
		gameName.setFont(Font.font(40));// Set the game title's font.
		pane.setStyle("-fx-background-color: beige");// Change pane's background color.
		gameName.setX(70);// Set coordinate of game title.
		gameName.setY(120);
		playButtonImage.setFitWidth(100);// Edit image's size.
		playButtonImage.setFitHeight(100);
		playButtonImage.setX(150);// Set coordinate of play button.
		playButtonImage.setY(150);
		pane.getChildren().addAll(playButtonImage, gameName);

	}

	public void setFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		setFileName(file.getName());
		Scanner input = new Scanner(file);
		readText(input);// Read text and add images to the pane.
		setDrag();// Give movement ability to the tiles if conditions are provided.
		setCircle();// Add ball to pane.
		setNextButton();// Add next button to pane.
		movementText.setLayoutX(323);// Set coordinate of movement text.
		movementText.setLayoutY(417);
		pane.getChildren().add(movementText);// Add movement text to pane.
		input.close();
		movement = 0;// For next level, set movement number 0.
		movementText.setText("Movement: " + getMovement());// For next level, set movement text.
		setPathController(false);// For next level, set path controller.
	}

	public void setNextButton() {
		int levelNumber = Integer.parseInt(getFileName().charAt(5) + "");// Keep number of level.
		nextButton.setLayoutY(400);// Set coordinate of next button.
		pane.getChildren().add(nextButton);
		nextButton.setOnAction(e -> {// Handle next button.
			if (levelNumber != 5) {// When last level finish, next button becomes functionless.
				if (pathController) {// Control path finish or not.
					try {
						pane.getChildren().remove(movementText);// Remove node's for next level.
						pane.getChildren().remove(nextLevelText);
						pane.getChildren().remove(ball);
						pane.getChildren().remove(nextButton);
						// Start to read next level.
						setFile("level" + (levelNumber + 1) + ".txt");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

	public void setCircle() {
		ball = new Circle();
		ball.setCenterX(50);// Set coordinate of ball.
		ball.setCenterY(39);
		ball.setRadius(10);
		ball.setFill(Color.YELLOW);// Set color of ball.
		ball.setStroke(Color.BLACK);
		pane.getChildren().add(ball);// Add ball to pane.

	}

	public void readText(Scanner input) {
		tile.clear(); // For next level, clear arraylist.
		while (input.hasNext()) {
			String[] wholeLine = input.nextLine().split(",");// Assign line to array.
			while (true) {// For line space at text.
				if (wholeLine[0].equals("")) {
					wholeLine = input.nextLine().split(",");
				} else {
					break;
				}
			}
			int id = Integer.parseInt(wholeLine[0]);// Keep id.
			setObject(id, wholeLine[1], wholeLine[2]);
			pane.getChildren().add((tile.get(id - 1).getImage()));// Add images to pane by using their coordinates.
		}
	}

	// Create objects for every tile and add them to arraylist.
	public void setObject(int id, String type, String property) {
		if (type.equalsIgnoreCase("empty")) {
			tile.add(new EmptyTile(id, type, property));
		} else if (type.equalsIgnoreCase("end")) {
			tile.add(new EndTile(id, type, property));
		} else if (type.equalsIgnoreCase("pipestatic")) {
			tile.add(new PipeStaticTile(id, type, property));
		} else if (type.equalsIgnoreCase("pipe")) {
			tile.add(new PipeTile(id, type, property));
		} else if (type.equalsIgnoreCase("starter")) {
			tile.add(new StarterTile(id, type, property));
		}
	}

	public void setDrag() {// Give movement ability to tiles if the conditions are provided.
		tile.get(0).getImage().setOnMouseDragged(e -> moveTile(0, e));
		tile.get(1).getImage().setOnMouseDragged(e -> moveTile(1, e));
		tile.get(2).getImage().setOnMouseDragged(e -> moveTile(2, e));
		tile.get(3).getImage().setOnMouseDragged(e -> moveTile(3, e));
		tile.get(4).getImage().setOnMouseDragged(e -> moveTile(4, e));
		tile.get(5).getImage().setOnMouseDragged(e -> moveTile(5, e));
		tile.get(6).getImage().setOnMouseDragged(e -> moveTile(6, e));
		tile.get(7).getImage().setOnMouseDragged(e -> moveTile(7, e));
		tile.get(8).getImage().setOnMouseDragged(e -> moveTile(8, e));
		tile.get(9).getImage().setOnMouseDragged(e -> moveTile(9, e));
		tile.get(10).getImage().setOnMouseDragged(e -> moveTile(10, e));
		tile.get(11).getImage().setOnMouseDragged(e -> moveTile(11, e));
		tile.get(12).getImage().setOnMouseDragged(e -> moveTile(12, e));
		tile.get(13).getImage().setOnMouseDragged(e -> moveTile(13, e));
		tile.get(14).getImage().setOnMouseDragged(e -> moveTile(14, e));
		tile.get(15).getImage().setOnMouseDragged(e -> moveTile(15, e));

	}

	public void moveTile(int index, MouseEvent e) { // If the mouse's position enter another image, replace both of
													// tile.
		if (!isLevelFinish()) // When level finish, stop tile's movement.
			if (canMove(index)) { // Is the tile,you want to change position to,has movement ability?
				int x = tile.get(index).getPosition();
				if (index + 1 <= 15 && (index % 4) != 3) { // That s for border of the moving ability.
					if (tile.get(index + 1).getType().equalsIgnoreCase("empty")// Is the tile, you want to change
																				// position with this, is empty free
																				// tile ?
							&& tile.get(index + 1).getProperty().equalsIgnoreCase("free")) {
						if (e.getX() == tile.get(index).getImage().getX() + 100) {// If the mouse's position enter
																					// another tile replaces them.
							tile.get(index).setPosition(tile.get(index + 1).getPosition()); // Replace positions
							tile.get(index + 1).setPosition(x);
							Collections.swap(tile, index, index + 1); // Swap the tile informations
							movement++; // Increase movement number
						}
					}
				}
				if (index - 1 >= 0 && (index % 4) != 0) { // Same Thing But This Time To Move To The Left Direction
					if (tile.get(index - 1).getType().equalsIgnoreCase("empty")
							&& tile.get(index - 1).getProperty().equalsIgnoreCase("free")) {
						if (e.getX() == tile.get(index).getImage().getX()) {
							tile.get(index).setPosition(tile.get(index - 1).getPosition());
							tile.get(index - 1).setPosition(x);
							Collections.swap(tile, index, index - 1);
							movement++;
						}
					}
				}
				if (index + 4 <= 15) { // Same Thing But This Time To Move To The Downward Direction
					if (tile.get(index + 4).getType().equalsIgnoreCase("empty")
							&& tile.get(index + 4).getProperty().equalsIgnoreCase("free")) {
						if (e.getY() == tile.get(index).getImage().getY() + 100) {
							tile.get(index).setPosition(tile.get(index + 4).getPosition());
							tile.get(index + 4).setPosition(x);
							Collections.swap(tile, index, index + 4);
							movement++;
						}
					}
				}
				if (index - 4 >= 0) { // Same Thing But This Time To Move To The Upward Direction
					if (tile.get(index - 4).getType().equalsIgnoreCase("empty")
							&& tile.get(index - 4).getProperty().equalsIgnoreCase("free")) {
						if (e.getY() == tile.get(index).getImage().getY()) {
							tile.get(index).setPosition(tile.get(index - 4).getPosition());
							tile.get(index - 4).setPosition(x);
							Collections.swap(tile, index, index - 4);
							movement++;
						}
					}
				}
				if (pathController == false) // If Path is suitable for the ball to go, Run to animation
					if (isLevelFinish()) {
						levelPath();
					}
				setDrag(); // Assign Movement Ability For Each Tile in new locations.
			}
		movementText.setText("Movement: " + getMovement()); // Print Movement Number
	}

	public boolean isLevelFinish() { // This purpose of the method is to control whether the path is suitable or not.
		int levelNumber = Integer.parseInt(getFileName().charAt(5) + "");// One Integer value to understand which the
																			// level we are in now.
		switch (levelNumber) {
		case 1:
		case 2: // Level 1,2 and 3 are using same path because of that the correct path's same
				// for them
		case 3:
			if (findTile(5).getProperty().equalsIgnoreCase("vertical") // The control is doing by using property of the
																		// tiles on the path
					&& findTile(9).getProperty().equalsIgnoreCase("vertical")
					&& findTile(13).getProperty().equalsIgnoreCase("01")
					&& findTile(14).getProperty().equalsIgnoreCase("horizontal"))
				return true;
		case 4: // Level 4 and 5 are using same path because of that the correct path's same for
				// them
		case 5:
			if (findTile(5).getProperty().equalsIgnoreCase("vertical") // The control is doing by using property of the
																		// tiles on the path
					&& findTile(9).getProperty().equalsIgnoreCase("01")
					&& findTile(10).getProperty().equalsIgnoreCase("horizontal")
					&& findTile(11).getProperty().equalsIgnoreCase("horizontal")
					&& findTile(12).getProperty().equalsIgnoreCase("00"))
				return true;

		}
		return false;

	}

	public void levelPath() { // This Method for the animation of ball when the game finish.
		int levelNumber = Integer.parseInt(getFileName().charAt(5) + ""); // One Integer value to understand which the
																			// level we are in now.
		Path path = new Path();
		MoveTo moveTo = new MoveTo(50, 39);
		LineTo line1 = new LineTo(50, 250); // Path Coordinates
		LineTo line2 = new LineTo(350, 250);
		LineTo line3 = new LineTo(350, 139);
		switch (levelNumber) {
		case 1:
		case 2:
		case 3:
			line1.setX(50);
			line1.setY(350);
			line2.setX(361); // Path Coordinates for 1,2 3th levels
			line2.setY(350);
			path.getElements().addAll(moveTo, line1, line2);
			break;
		case 4:
		case 5: // The Coordinates have already been for 4 and 5th levels. So Just Add.
			path.getElements().addAll(moveTo, line1, line2, line3);
			break;
		}
		pathTransition.setDuration(Duration.millis(5000));
		pathTransition.setNode(ball); // Enter Animation Information
		pathTransition.setPath(path);
		pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setCycleCount(1);
		pathTransition.play();
		pathTransition.setOnFinished(e -> {
			if (levelNumber != 5) {
				nextLevelText.setLayoutY(417);
				nextLevelText.setLayoutX(80); // When the animation finish, Print a text about level result.
				pane.getChildren().add(nextLevelText);
			} else {
				Text finish = new Text("Game finished."); // If Number Of Level is 5 and also you finished ,Print the
															// game finished
				finish.setLayoutY(417);
				finish.setLayoutX(155);
				pane.getChildren().add(finish);
			}
			pathController = true; // Path Correct
		});
		window.setScene(scene); // Set Scene For New Level or etc.
	}

	public boolean canMove(int index) { // Does the tile you've dragged have movable?
		if (tile.get(index).getType().equalsIgnoreCase("empty") // To Be Movable, it should be None Empty or Pipe Image.
				&& tile.get(index).getProperty().equalsIgnoreCase("none")) {
			return true;
		}
		if (tile.get(index).getType().equalsIgnoreCase("pipe")) {
			return true;
		}
		return false;
	}

	public Tile findTile(int position) { // This Method is to find which kind of tile exists in the this position.
		for (Tile til : tile)
			if (til.getPosition() == position)
				return til; // Return This Tile.
		return null;
	}

	public String getFileName() { // Setters And Getters For The Variable in Data Field.
		return fileName;
	}

	public void setFileName(String fileName) { // Setters And Getters For The Variable in Data Field.
		this.fileName = fileName;
	}

	public int getMovement() { // Setters And Getters For The Variable in Data Field.
		return movement;
	}

	public void setMovement(int movement) { // Setters And Getters For The Variable in Data Field.
		this.movement = movement;
	}

	public boolean isPathController() { // Setters And Getters For The Variable in Data Field.
		return pathController;
	}

	public void setPathController(boolean pathController) { // Setters And Getters For The Variable in Data Field.
		this.pathController = pathController;
	}
}