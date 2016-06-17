package application;
import java.util.concurrent.CopyOnWriteArrayList;

import block.Ball;
import block.Brick;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameScene extends Parent {
	private int width;
	private int height;
	private Rectangle background;
	private MainBrick mainBrick = new MainBrick();
	private Ball ball = new Ball(15, 15, 15);
	private Timeline timeline;
	private KeyFrame keyFrame;

	private CopyOnWriteArrayList<Brick> bricks = new CopyOnWriteArrayList<>();

	public GameScene(int width, int height) {
		this.width = width;
		this.height = height;

		initGameObjects();
		initTimeLine();
		initLevel();
	}

	private void initGameObjects() {
		this.background = new Rectangle(0.0D, 0.0D, this.width, this.height);
		this.background.setOnMouseMoved(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				mainBrick.onMouseMove(event);

			}
		});
		this.background.setFill(Color.BLACK);

		this.mainBrick.setX(0.0D);
		this.mainBrick.setY(this.height - this.mainBrick.getHeight());
		this.ball.setX((this.mainBrick.getWidth() - this.ball.getWidth()) / 2.0D);
		this.ball.setY(this.height - this.mainBrick.getHeight() - this.ball.getHeight());

		getChildren().add(this.background);
		getChildren().add(this.mainBrick);
		getChildren().add(this.ball);
	}

	private void initTimeLine() {
		this.timeline = new Timeline();
		this.timeline.setCycleCount(-1);
		this.keyFrame = new KeyFrame(Duration.millis(5.0D), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				ball.moveX(ball.getSpeedX());
				ball.moveY(ball.getSpeedY());

				if ((ball.getX() <= 0.0D) || (ball.getX() >= 800.0D - ball.getWidth())) {
					ball.setSpeedX(-ball.getSpeedX());
				}

				if ((ball.getY() <= 0.0D) || (ball.getY() >= 600.0D - ball.getHeight())) {
					ball.setSpeedY(-ball.getSpeedY());
				}

				if (ball.isCollisionWith(mainBrick)) {
					ball.setSpeedY(-ball.getSpeedY());
				}

				for (Brick brick : bricks) {
					if (ball.isCollisionWith(brick)) {
						brick.setHp(brick.getHp() - 1);
						ball.setSpeedY(-ball.getSpeedY());
						if (brick.getHp() <= 0) {
							destroyObject(brick);
						}
						break;
					}
				}
			}
		}, new KeyValue[0]);

		this.timeline.getKeyFrames().add(this.keyFrame);
		this.timeline.play();
	}

	private void destroyObject(final BaseObject brick) {
		FadeTransition fade = new FadeTransition(Duration.millis(200.0D), brick);
		fade.setFromValue(1.0D);
		fade.setToValue(0.0D);
		fade.setOnFinished(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				getChildren().remove(brick);
			}
		});
		this.bricks.remove((Brick) brick);
		fade.play();
	}

	private void initLevel() {
		InitBricks.load(this, 1);
	}

	public void addChild(Parent parent) {
		getChildren().add(parent);
	}

	public CopyOnWriteArrayList<Brick> getBricks() {
		return this.bricks;
	}
}
