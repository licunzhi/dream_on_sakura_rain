package com.meimei.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-06
 */
public class Hello extends Application {

    @Override
    public void start(Stage primaryStage) {
        //设置按钮点击内容
        Button btn = new Button();
        btn.setText("Hello, Dream On Sakura Rain");
        //动作事件
        btn.setOnAction(event -> System.out.println("Pretty!"));

        //创建一个面板
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene =  new Scene(root, 500, 450);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
