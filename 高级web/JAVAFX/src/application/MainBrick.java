package application;
import application.BrickBlock;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainBrick extends BaseObject{
    //javafx����ҳ�����һ����ť
	private Rectangle mRectangle;
    //��ֵģ��
	private BoxBlur mBlur;
    //�����ƶ��İ���
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
    //���Ӹ�������ƶ�
    public void onMouseMove(MouseEvent event){
        if (event.getX() >= getWidth()/2 && event.getX() <= BrickBlock.WIDTH - getWidth()/2) {
            setX(event.getX() - getWidth()/2);
        }
    }
 
}