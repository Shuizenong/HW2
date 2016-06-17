package application;

import javafx.application.Application;  
import javafx.scene.Scene;  
import javafx.stage.Stage;  
//main frame of the game
//������Ϸ���
public class BrickBlock extends Application {  
    public static final int WIDTH = 800;  
    public static final int HEIGHT = 600;  
   
    public static void main(String[] args) {  
        launch(args);  
    }  
     
    //��ʼ����Ļ
    @Override  
    public void start(Stage primaryStage) {  
        GameScene  root = new GameScene(WIDTH, HEIGHT);  
        primaryStage.setTitle("FXPJ");  
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));  
        primaryStage.show();  
    }  
}  