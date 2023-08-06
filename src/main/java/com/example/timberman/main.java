package com.example.timberman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;


public class main extends Application {

    Integer[] innerArray = new Integer[7];
    int currentScore = 0;
    int targetScore = 50;
    Menu settingMenu = new Menu("Setting");
    MenuItem settingMenuItem = new MenuItem("Setting");
    MenuBar menuBarTop = new MenuBar();
    Button backToGameButton = new Button("Back");
    MenuItem helpMenuItem = new MenuItem("Help");
    Image leftTreeImage = new Image(main.class.getResource("left.png").toString());
    Image rightTreeImage = new Image (main.class.getResource("right.png").toString());
    Image noTreeImage = new Image (main.class.getResource("no.png").toString());
    Image standLeftImage = new Image (main.class.getResource("standright.png").toString());
    Image standRightImage = new Image (main.class.getResource("standleft.png").toString());
    Image chopLeftImage = new Image (main.class.getResource("chopleft.png").toString());
    Image chopRightImage = new Image (main.class.getResource("chopright.png").toString());
    Image deadLeftImage = new Image (main.class.getResource("deadleft.png").toString());
    Image deadRightImage = new Image (main.class.getResource("deadright.png").toString());

    RadioButton target50 = new RadioButton("target 50");
    RadioButton target100 = new RadioButton("target 200");
    RadioButton target200 = new RadioButton("target 200");
    RadioButton targetEndless = new RadioButton("targetEndless");
    CheckBox setTimeLimitCheckBox = new CheckBox("Time Limit?");

    ImageView playerImageView = new ImageView();
    ImageView index0ImageView = new ImageView();
    ImageView index1ImageView = new ImageView();
    ImageView index2ImageView = new ImageView();
    ImageView index3ImageView = new ImageView();
    ImageView index4ImageView = new ImageView();
    ImageView index5ImageView = new ImageView();
    ImageView index6ImageView = new ImageView();



    @Override
    public void start(Stage stage) throws IOException {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane,200,820);
        BorderPane settingBorderPane = new BorderPane();
        Scene settingScene = new Scene(settingBorderPane,200,820);
        stage.setResizable(false);

        randomStart();
        imageSet();

        borderPane.setTop(menuBar());
        borderPane.setCenter(treeVBox());
        settingBorderPane.setCenter(settingVBoxMethod());

        scene.setOnKeyPressed(event -> handleKeyPressed(event));
        scene.setOnKeyReleased(event -> handleKeyReleased(event));

        stage.setTitle("TimberMan");
        stage.setScene(scene);
        stage.show();

        settingMenuItem.setOnAction(event -> {
            stage.setTitle("Setting");
            stage.setScene(settingScene);
            stage.show();
        });

        backToGameButton.setOnAction(event ->{
            stage.setTitle("TimberMan");
            stage.setScene(scene);
            stage.show();
        });

    }

    public static void main(String[] args) {
        launch();
    }

    private void handleKeyPressed(KeyEvent event) {
        String keyPressed = event.getCode().toString();
        if (keyPressed == "LEFT"){
            playerImageView.setImage(chopLeftImage);

        }
        else if (keyPressed == "RIGHT")
        {
            playerImageView.setImage(chopRightImage);
        }

    }

    private void handleKeyReleased(KeyEvent event) {
        String keyPressed = event.getCode().toString();
        if (keyPressed == "LEFT")
        {
            if (innerArray[0] == 1){
                randomArrayAction();
                imageSet();
                playerImageView.setImage(deadLeftImage);
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("You Lose!");
                alert.setContentText("Score: "+ currentScore);
                alert.showAndWait();
                currentScore = 0;
                randomStart();
                imageSet();
                playerImageView.setImage(standLeftImage);
            }else {
                playerImageView.setImage(standRightImage);
                randomArrayAction();
                imageSet();
                currentScore++;
            }

        }else if (keyPressed == "RIGHT")
        {
            if (innerArray[0] == 2){
                randomArrayAction();
                playerImageView.setImage(deadRightImage);
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("You Lose!");
                alert.setContentText("Score: "+ currentScore);
                alert.showAndWait();
                currentScore = 0;
                randomStart();
                imageSet();
                playerImageView.setImage(standRightImage);
            }else {
                playerImageView.setImage(standLeftImage);
                randomArrayAction();
                imageSet();
                currentScore++;
            }

        }

    }


    public void randomStart()
    {
        int[] randomArray = new int[7]; // Create an array with 7 elements

        Random random = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            // Generate random number between 0, 1 and 2 (inclusive)
            innerArray[i] = random.nextInt(3);
        }
    }

    public VBox treeVBox()
    {
        playerImageView.setImage(standLeftImage);
        VBox treeVBox = new VBox(index6ImageView,index5ImageView,index4ImageView,index3ImageView,index2ImageView,index1ImageView,index0ImageView,playerImageView);
        return treeVBox;
    }

    public MenuBar menuBar()
    {


        settingMenu.getItems().addAll(settingMenuItem,helpMenuItem);
        menuBarTop.getMenus().addAll(settingMenu);
        return menuBarTop;
    }

    public void imageSet()
    {
        if (innerArray[0] == 1)
        {
            index0ImageView.setImage(leftTreeImage);
        } else if (innerArray[0] == 2) {
            index0ImageView.setImage(rightTreeImage);
        } else index0ImageView.setImage(noTreeImage);

        if (innerArray[1] == 1)
        {
            index1ImageView.setImage(leftTreeImage);
        } else if (innerArray[1] == 2) {
            index1ImageView.setImage(rightTreeImage);
        } else index1ImageView.setImage(noTreeImage);

        if (innerArray[2] == 1)
        {
            index2ImageView.setImage(leftTreeImage);
        } else if (innerArray[2] == 2) {
            index2ImageView.setImage(rightTreeImage);
        } else index2ImageView.setImage(noTreeImage);

        if (innerArray[3] == 1)
        {
            index3ImageView.setImage(leftTreeImage);
        } else if (innerArray[3] == 2) {
            index3ImageView.setImage(rightTreeImage);
        } else index3ImageView.setImage(noTreeImage);

        if (innerArray[4] == 1)
        {
            index4ImageView.setImage(leftTreeImage);
        } else if (innerArray[4] == 2) {
            index4ImageView.setImage(rightTreeImage);
        } else index4ImageView.setImage(noTreeImage);

        if (innerArray[5] == 1)
        {
            index5ImageView.setImage(leftTreeImage);
        } else if (innerArray[5] == 2) {
            index5ImageView.setImage(rightTreeImage);
        } else index5ImageView.setImage(noTreeImage);

        if (innerArray[6] == 1)
        {
            index6ImageView.setImage(leftTreeImage);
        } else if (innerArray[6] == 2) {
            index6ImageView.setImage(rightTreeImage);
        } else index6ImageView.setImage(noTreeImage);

    }


    private void randomArrayAction()
    {
        for(int i =1;i<innerArray.length;i++)
        {
            innerArray[i-1] = innerArray[i];
        }

        Random random = new Random();

        innerArray[6] = random.nextInt(3);

    }
    public VBox settingVBoxMethod(){
        ToggleGroup targetToggleGroup = new ToggleGroup();
        target50.setToggleGroup(targetToggleGroup);
        target100.setToggleGroup(targetToggleGroup);
        target200.setToggleGroup(targetToggleGroup);
        targetEndless.setToggleGroup(targetToggleGroup);
        target50.setSelected(true);

        VBox settingVBox = new VBox(target50,target100,target200,targetEndless, setTimeLimitCheckBox,backToGameButton);

        return settingVBox;
    }

}