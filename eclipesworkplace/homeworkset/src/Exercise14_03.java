import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Exercise14_03 extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	@Override
	public void start(Stage primaryStage)
	{
		FlowPane pane = new FlowPane(5,5);
		pane.setPadding(new Insets(5,5,5,5));
		
		
		String[] str=new String[3];
		str[0]=choose();
		str[1]=choose();
		
		while(str[0].equals(str[1])) {
			str[1]=choose();
		}
		str[2]=choose();
		while(str[0].equals(str[2])||str[1].equals(str[2])) {
			str[2]=choose();
		}
		
	
		for(int i = 0;i < 3;i ++)
		{
			Image image = new Image(str[i]);
			pane.getChildren().add(new ImageView(image));
			
		}
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Ëæ»úÆË¿ËÅÆ");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public String choose()
	{
		String Istr = "images/card/";
		String Lstr = ".jpg";
		int nums = (int)(Math.random() * 52) + 3;
		return Istr + nums + Lstr;
	}
	
}

