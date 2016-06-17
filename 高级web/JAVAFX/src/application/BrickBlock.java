package application;

import javafx.application.Application;  
import javafx.scene.Scene;  
import javafx.stage.Stage;  
//main frame of the game
//设置游戏框架
public class BrickBlock extends Application {  
    public static final int WIDTH = 800;  
    public static final int HEIGHT = 600;  
   
    public static void main(String[] args) {  
        launch(args);  
    }  
     
    //初始化屏幕
    @Override  
    public void start(Stage primaryStage) {  
        GameScene  root = new GameScene(WIDTH, HEIGHT);  
        primaryStage.setTitle("FXPJ");  
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));  
        primaryStage.show();  
    }  
}  