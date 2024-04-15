package seng201.team0.gui;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MovingController implements Initializable {

    private BooleanProperty wPressed = new SimpleBooleanProperty();
    private BooleanProperty aPressed = new SimpleBooleanProperty();
    private BooleanProperty sPressed = new SimpleBooleanProperty();
    private BooleanProperty dPressed = new SimpleBooleanProperty();
    private BooleanBinding keyPressed = wPressed.or(aPressed).or(sPressed).or(dPressed);
    private int movementVar = 5;
    @FXML
    private Button towerbutton;
    @FXML
    private Rectangle tower;
    @FXML
    private AnchorPane scene;
//    @FXML
//    void start(ActionEvent event){
//        tower.setLayoutY(200);
//        tower.setLayoutX(280);
//    }
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {
            if(wPressed.get()){
                tower.setLayoutY(tower.getLayoutY() - movementVar);
                towerbutton.setLayoutY(towerbutton.getLayoutY() - movementVar);
            }
            if(sPressed.get()){
                tower.setLayoutY(tower.getLayoutY() + movementVar);
                towerbutton.setLayoutY(towerbutton.getLayoutY() + movementVar);
            }
            if(aPressed.get()){
                moveLeft();
                towerbutton.setLayoutX(towerbutton.getLayoutX() - movementVar);
            }
            if(dPressed.get()){
                moveRight();
                towerbutton.setLayoutX(towerbutton.getLayoutX() + movementVar);
            }
        }
    };
    void moveLeft(){
        double newXPosition = tower.getLayoutX() - movementVar;
        if (newXPosition > 0 && newXPosition < 600)
            tower.setLayoutX(newXPosition);
    }
    void moveRight(){
        double newXPosition = tower.getLayoutX() + movementVar;
        if (newXPosition > 0 && newXPosition < 600)
            tower.setLayoutX(newXPosition);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        movementSetup();
        keyPressed.addListener(((observableValue, aBoolean, t1) -> {
            if(!aBoolean){
                timer.start();
            }else {
                timer.stop();
            }
        }));
    }
    public void movementSetup(){
        scene.setOnKeyPressed(e ->{
            if(e.getCode() == KeyCode.W){
                wPressed.set(true);
            }
            if(e.getCode() == KeyCode.A){
                aPressed.set(true);
            }
            if(e.getCode() == KeyCode.S){
                sPressed.set(true);
            }
            if(e.getCode() == KeyCode.D){
                dPressed.set(true);
            }
        });
        scene.setOnKeyReleased(e ->{
            if(e.getCode() == KeyCode.W){
                wPressed.set(false);
            }
            if(e.getCode() == KeyCode.A){
                aPressed.set(false);
            }
            if(e.getCode() == KeyCode.S){
                sPressed.set(false);
            }
            if(e.getCode() == KeyCode.D){
                dPressed.set(false);
            }
        });
    }
}
