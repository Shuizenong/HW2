package application;
import application.BrickBlock;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainBrick extends BaseObject{
    //javafx在网页里面放一个按钮
	private Rectangle mRectangle;
    //均值模糊
	private BoxBlur mBlur;
    //设置移动的板子
    public MainBrick(){   
        mRectangle = new Rectangle();
        mRectangle.widthProperty().bindBidirectional(widthProperty());
        mRectangle.heightProperty().bindBidirectional(heightProperty());
        mRectangle.xProperty().bindBidirectional(xProperty());
        mRectangle.yProperty().bindBidirectional(yProperty());
        mRectangle.setArcWidth(20);
        mRectangle.setArcHeight(20);
        mRectangle.setFill(Color.YELLOW);
        mBlur = new BoxBlur();
        mBlur.setWidth(5);
        mBlur.setHeight(5);
        mRectangle.setEffect(mBlur);
        setWidth(150);
        setHeight(25);
        getChildren().add(mRectangle);
    }
    //板子跟随鼠标移动
    public void onMouseMove(MouseEvent event){
        if (event.getX() >= getWidth()/2 && event.getX() <= BrickBlock.WIDTH - getWidth()/2) {
            setX(event.getX() - getWidth()/2);
        }
    }
 
}