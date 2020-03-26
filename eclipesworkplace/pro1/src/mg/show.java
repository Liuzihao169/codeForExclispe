package mg;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
public class show extends Application{
	@Override
	public void start(Stage primaryStage){
		GridPane pane=new GridPane();
		pane.setPadding(new Insets(5,5,5,5));
		pane.getChildren().add(new ImageView("0.jpg"));
		pane.add(new ImageView("0.jpg"),0,0);
		pane.getChildren().add(new ImageView("1.jpg"));
		pane.add(new ImageView("1.jpg"),0,1);
		pane.getChildren().add(new ImageView("2.jpg"));
		pane.add(new ImageView("2.jpg"),1,0);
		pane.getChildren().add(new ImageView("3.jpg"));
		pane.add(new ImageView("3.jpg"),1,1);
		Scene scene=new Scene(pane);
		primaryStage.setTitle("image");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	public static void main(String args[]) {
		Application.launch(args);
	}
}

