# **JavaFX Project**

# FIND THE PATH


Bahadır Alacan - Mustafa Yanar


Date Submitted: May 10, 2020

**Problem Definition**

Nowadays, Technology is regularly growing and developing. And mobile phones and computers have started to become most popular devices for us. Nevertheless, the game industry is raising. Even a simple game is created by only one person might be very popular. And we wanted to prepare a simple game about puzzle.

This game is a puzzle game. The game is satisfied to play a game, to spend free times, to be gained thinking and solving problem abilities for children. You can test your brain on 5 different and hard level. The main aim of the game is to find correct path due to fact that the ball reach final tile. If you figure out to the correct path, you can pass the next level.

**Implementation Details**

The given project is a simple puzzle game. But creating game with JavaFX is new to us. Because of that, we found some examples about the game and got some information where we can start from. After we had considered, we&#39;ve decided to draw an UML diagram for the game classes. We&#39;ve considered to be the game about tiles and each tile has different features. For example, starter tile cannot move to another location however pipe tile can. So, we created 5 class according to the kind of tile. Classes were extended one basis class named Tile.class. Tile class is connected with all of them through inheritance.

Then the main class occurred. The aim of the main class is principal part of our work. Almost all special function is in the main class. We assigned some variable in data field of the class. The most important variable is &quot;ArrayList\&lt;Tile\&gt;&quot;. As the game has 16 boxes will be determined by level.txt, the boxes should be assigned in distinct location, distinct index of array. In the start method all tiles place to their tile indexes. And the sequences continue one by one.

Our project fulfilled all requirements that wanted by our terms project. The game has not any uncompleted piece. But we&#39;ve spent too much time because of that each new functionality was added by testing one by one. Also, we&#39;ve encountered with some situations. For example, when we finished the main mechanism of the game, we&#39;ve started to put in the project some new features. But adding something to complete project is hard. Because you have to review the codes you wrote. And If it needs, you change it with connected to it. In case of that you must change basis a function, you may have to rewrite all functions. We had taken measures about it. Therefore, we&#39;ve separated all functionality by creating new method.

Additionally, we add extra feature to the game. When a user run the program, a user interface is seen by the user. There are a Text and Button in the UI. If the user clicks to the button, the game will execute from level 1. Another extra feature is the texts are resultant after the level finished. These texts are in right of the &quot;Next&quot; button.

| Tile |
| --- |
| +position: int |
| + id: int|
| + type: String|
| + property: String|
| + image: ImageView|
||    
| - Tile(id: int, type: String, property: String)|
| - setCoordinate(position: int)|
| - voidgetter/setter methods|
||


Tile class is a superclass of endTile, emptyTile, starterTile, pipeTile and pipeStaticTile classes. It has five data fields.

The data field **position** determines tile coordinates. **Id** data field is different for every tile. **Type** and **property** properties use for finding image, find path, etc. The data field **image** keeps image of tiles.

The method **setCoordinate** sets image&#39;s coordinates by using their position value.

| StarterTile |
| --- |
| -StarterTile(id: int, type: String, property: String)|
| -findImage(): void |
||

StarterTile is a subclass of Tile class.

The findImage method finds the image of tiles by using their property value.

| EmptyTile |
| --- |
| -EmptyTile(id: int, type: String, property: String) |
| -findImage(): void |
||

EmptyTile is a subclass of Tile class.

| PipeStaticTile |
| --- |
| -PipeStaticTile(id: int, type: String, property: String) |
| -findImage(): void |
||

PipeStaticTile is a subclass of Tile class.

| EndTile |
| --- |
| -EndTile(id: int, type: String, property: String) |
| -findImage(): void |
||

EndTile is a subclass of Tile class.

| PipeTile |
| --- |
| - PipeTile(id: int, type: String, property: String)|
| - findImage(): void|
||

PipeTile is a subclass of Tile class.

| GameBoard |
| --- |
| + pathController: boolean|
| + window: Stageball: Circle|
| + fileName: String|
| + movement: int|
| + pathTransition: PathTransition|
| + tile: ArrayList|
| + playButtonImage: ImageView|
| + pane: Pane|
| + nextButton: Button|
| + scene: Scene|
| + nextLevelText: Text|
| + movementText: Text|
||

| GameBoard |
| --- |
| - start(primaryStage: Stage): void|
| - setMainMenu(): void|
| - setFile(fileName:String): void|
| - setNextButton(): void|
| - setCircle(): void|
| - readText(input: Scanner): void|
| - setObject(id: int, type: String, property:String): void|
| - setDrag(): void|
| - moveTile(index: int, e: MouseEvent): void|
| - isLevelFinish(): boolean|
| - levelPath(): void|
| - canMove(index: int): boolean|
| - findTile(position: int): Tile|
| - getter/setter methods|
| |

This class creates game screen.

The data field **pathController** controls the ball&#39;s complete path or not. **Window** edits screen. We use circle class to create **ball** data field. **fileName** data field keeps the reading file&#39;s name. The data field **movement** keeps number of movements. **pathTransition** is used for animation. **Tile** keeps the objects. **playButtonImage** is used for starting the game **. Pane** data field is the pane of the game. **nextButton** is used for passing next level if current level finishes. **Scene** data field is the scene of the game. If level finishes **nextLevelText** appears on the bottom. **movementText** data field writes number of movements.

The **start** method creates a scene and calls setMainMenu method. **setMainMenu** method adds title of the game and play button to pane. **setFile** method reads text and creates game screen. This method adds movement text to pane. Also, it calls readText, setDrag, setCircle, setNextButton methods. **setNextButton** adds next button to pane and if player clicks next and current level finishes, new level is opened. **setCircle** method edits ball&#39;s properties. **readText** method reads text and add images to pane. Also, it assigns objects to arrayList. **setObject** method creates objects. **setDrag** method gives movement ability to tiles if conditions are provided. If the mouse&#39;s position enters another tile and conditions are provided **moveTile** method changes position of tiles. **isLevelFinish** method&#39;s purpose is to control whether the path is suitable or not. **levelPath** method sets the animation of ball when the game finish for every level. **canMove** method controls the tile you&#39;ve dragged have moveable. **findTile** method finds which kind of tile exists in this position.

![](RackMultipart20210407-4-1mqtf7v_html_14ce252106b0ed1d.png) **Test Cases**

We click play button and the game starts.

![](RackMultipart20210407-4-1mqtf7v_html_8171aeb921b049b1.png)

First level starts. We shift tenth tile to downward for complete the path. Also, we try to move tiles which can move, to tiles which are not free, but they cannot move because tiles can move only to free tiles.

![](RackMultipart20210407-4-1mqtf7v_html_6ce142223c2c349e.png)

The ball starts to move from starter tile. Number of movements are updated to 1. When the ball moves on the path, we try move other tiles, but tiles cannot move because path is not completed. Also, we click next button to pass the next level, but it doesn&#39;t work because the ball is not located in the end tile.

![](RackMultipart20210407-4-1mqtf7v_html_e7ea7939b2847229.png)

The ball reaches end tile. Writing, which is congratulations, you can skip next level, appears on the bottom of the pane. We click next button and the game pass next level.

![](RackMultipart20210407-4-1mqtf7v_html_f2cfe9ecae84e8f3.png)

Second level starts. We try to move tiles which cannot move, to free tiles and they cannot move.

![](RackMultipart20210407-4-1mqtf7v_html_e4dcbfa70d7a5041.png)

Then we locate tiles in correct position. The ball reaches end tile. Number of movements are updated. Writing, which is congratulations, you can skip next level, appears on the bottom. We click next.

![](RackMultipart20210407-4-1mqtf7v_html_f768bb2524fa6e4b.png)

Third level starts. We do all control again. We locate tiles in correct position. The ball reaches end tile. Number of movements are updated. Writing, which is congratulations, you can skip next level, appears on the bottom. We click next.

![](RackMultipart20210407-4-1mqtf7v_html_a69481f11898dbe9.png)

Fourth level starts. We do all control again. We locate tiles in correct position. The Ball reaches end tile. Number of movements are updated. Writing, which is congratulations, appears on the bottom. We click next.

![](RackMultipart20210407-4-1mqtf7v_html_74ffac93b126db6c.png)

Fifth level starts. We do all control again. We locate tiles in correct position. The ball reaches end tile. Number of movements are updated. Writing, which is game finished, appears on the bottom. We click next button, but it doesn&#39;t work because game is finished.
