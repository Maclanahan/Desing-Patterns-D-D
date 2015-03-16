package application;

import Combat.TurnManager;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class AnimationManager 
{	
	SequentialTransition sequence;
	EventHandler<ActionEvent> onFinished;
	TurnManager turnManage;
	
	double timestamp = 200;
	
	public AnimationManager()
	{		
		sequence = new SequentialTransition();
		
		onFinished = new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent t)
			{
				turnManage.afterAnimationExecute();
				sequence.getChildren().clear();
			}
		};
		
		sequence.onFinishedProperty().set(onFinished);
	}
	
	public void AttackAnimation(Rectangle $image)
	{
		double move;
		if($image.xProperty().get() > 240)
			move = -40;
		else
			move = 40;
		
		Timeline timeline = new Timeline();
		timeline.setAutoReverse(true);
		timeline.setCycleCount(2);
		
		KeyValue kv1 = new KeyValue($image.xProperty(), $image.xProperty().get() + move, Interpolator.EASE_IN);
		KeyValue kv2 = new KeyValue($image.xProperty(), $image.xProperty().get() - move, Interpolator.EASE_IN);
		
		KeyFrame kf1 = new KeyFrame(Duration.millis(timestamp), kv1);
		KeyFrame kf2 = new KeyFrame(Duration.millis(timestamp), kv2);
		
		timeline.getKeyFrames().add(kf1);
		timeline.getKeyFrames().add(kf2);

		sequence.getChildren().add(timeline);
	}
	
	public void DefendAnimation(Rectangle $image)
	{
		double move;
		if($image.xProperty().get() > 240)
			move = -20;
		else
			move = 20;
		
		Timeline timeline = new Timeline();
		timeline.setAutoReverse(true);
		timeline.setCycleCount(2);
		
		KeyValue kv1 = new KeyValue($image.xProperty(), $image.xProperty().get() - move, Interpolator.EASE_IN);
		KeyValue kv3 = new KeyValue($image.yProperty(), $image.yProperty().get() + 20, Interpolator.EASE_IN);
		
		KeyFrame kf1 = new KeyFrame(Duration.millis(timestamp * 2), kv1);
		KeyFrame kf3 = new KeyFrame(Duration.millis(timestamp * 2), kv3);
		
		timeline.getKeyFrames().add(kf1);
		timeline.getKeyFrames().add(kf3);

		sequence.getChildren().add(timeline);
	}
	
	public void SpecialAnimation(Rectangle $image)
	{
		double move;
		move = 20;
		
		Timeline timeline = new Timeline();
		timeline.setAutoReverse(true);
		timeline.setCycleCount(2);
		
		KeyValue kv1 = new KeyValue($image.yProperty(), $image.yProperty().get() + move, Interpolator.EASE_BOTH);
		KeyValue kv3 = new KeyValue($image.yProperty(), $image.yProperty().get() - move, Interpolator.EASE_BOTH);
		
		KeyFrame kf1 = new KeyFrame(Duration.millis(timestamp), kv1);
		KeyFrame kf3 = new KeyFrame(Duration.millis(timestamp), kv3);
		
		timeline.getKeyFrames().add(kf1);
		timeline.getKeyFrames().add(kf3);

		sequence.getChildren().add(timeline);
	}
	
	public void takeHitAnimation(Rectangle $image)
	{
		double move;
		if($image.xProperty().get() > 240)
			move = 10;
		else
			move = -10;
		
		Timeline timeline = new Timeline();
		timeline.setAutoReverse(true);
		timeline.setCycleCount(2);
		
		KeyValue kv1 = new KeyValue($image.xProperty(), $image.xProperty().get() + move);
		KeyValue kv2 = new KeyValue($image.xProperty(), $image.xProperty().get() - move);
		
		KeyFrame kf1 = new KeyFrame(Duration.millis(timestamp/2), kv1);
		KeyFrame kf2 = new KeyFrame(Duration.millis(timestamp/2), kv2);
		
		timeline.getKeyFrames().add(kf1);
		timeline.getKeyFrames().add(kf2);
		
		sequence.getChildren().add(timeline);
	}
	
	public void playAnimations()
	{
		sequence.playFromStart();
	}

	public void setAfterFinishedAnimationCall(TurnManager $turnManage) 
	{
		turnManage = $turnManage;	
	}

	public void moveHealth(Rectangle $healthbar, double $currentLength) 
	{
		Timeline timeline = new Timeline();
		timeline.setAutoReverse(true);
		timeline.setCycleCount(1);
		
		KeyValue kv1 = new KeyValue($healthbar.widthProperty(), $currentLength);
		
		KeyFrame kf1 = new KeyFrame(Duration.millis(timestamp), kv1);
		
		timeline.getKeyFrames().add(kf1);
		
		sequence.getChildren().add(timeline);
	}

	public void displayDamage(Text $damage, int $num) 
	{
		$damage.setFill(new Color(1, 1, 1, 0));
		$damage.textProperty().set($num + "");
		
		FillTransition ft1 = new FillTransition(Duration.millis(500), $damage, new Color(1, 0, 0, 0), Color.RED);
		FillTransition ft2 = new FillTransition(Duration.millis(500), $damage, Color.RED, new Color(1, 0, 0, 0));
		
		sequence.getChildren().add(ft1);
		sequence.getChildren().add(ft2);
		
	}
	
	
}
