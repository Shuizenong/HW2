package application;
import javax.print.attribute.standard.MediaSize.Other;
import javafx.scene.paint.Color;
import block.Brick;
import application.*;
public class InitBricks
{
  //定义屏幕的砖块，
  private static int[][] level1 = { { 0, 2, 1, 1, 1, 2, 0 }, { 0, 2, 0, 0, 0, 2, 0 }, { 0, 2, 0, 0, 0, 2, 0 }, { 0, 1, 2, 3, 2, 1, 0 },{4, 0, 2, 0, 2, 0, 4} };

  public static void load(GameScene scene, int level)
  {
    int[][] datas = getLevel(level);
    for (int i = 0; i < datas.length; i++)
      for (int j = 0; j < datas[0].length; j++)
    	ColorTheBricks(scene,datas,i,j);
  }
  public static void ColorTheBricks(GameScene scene,int[][] datas, int i, int j)
  {
	  if (datas[i][j] != 0) {
      	Brick brick = null;
      	switch(datas[i][j])
      	{
      	//砖块不同的颜色
      	case(0):
      		break;
      	case(1):
	        brick = new Brick(Color.rgb(213, 229, 251), datas[i][j]);
      	    break;
      	case(2):
      		brick = new Brick(Color.rgb(152, 194, 251),datas[i][j]);
      		break;
      	case(3):
      		brick = new Brick(Color.rgb(72, 147, 248),datas[i][j]);
      		break;
      	case(4):
      		brick = new Brick(Color.rgb(8, 110, 248), datas[i][j]);
      		break;
      	}
	          brick.setWidth(108.0D);
	          brick.setX((760- 7 * brick.getWidth()) / 2.0D + j * (brick.getWidth()));
	          brick.setY(i * (brick.getHeight()) + 100);
	          scene.addChild(brick);
	          scene.getBricks().add(brick);
      }
  }
  public static int[][] getLevel(int i)
  {
    if (i == 1) {
      return level1;
    }
    return (int[][])null;
  }
}
