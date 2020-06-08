package main.sakura_rain.seven.menu;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.sakura_rain.seven.consts.SizeConstants;
import main.sakura_rain.seven.menu_listener.NewProjectListener;
import main.sakura_rain.seven.menu_listener.NewTestDemo;

import javax.swing.*;

/**
 * @ClassName MenuBar
 * @function [初始化顶部菜单操作]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/05/25 11:21
 */
public class MenuBarInit {

    public void initMenuBar(JFrame jFrame) {
        JMenuBar jmb = new JMenuBar();
        JMenu menu = new JMenu("文件");
        JMenuItem jmenuItem = new JMenuItem("新建项目");
        jmenuItem.addActionListener(new NewProjectListener(jFrame));
        menu.add(jmenuItem);
        jmenuItem = new JMenuItem("打开本地项目");
        jmenuItem.addActionListener(new NewTestDemo());
        menu.add(jmenuItem);
        jmb.add(menu);

        menu = new JMenu();
        menu.setToolTipText("编辑");
        jmb.add(menu);

        menu = new JMenu("查找");
        jmb.add(menu);

        menu = new JMenu("运行");
        jmb.add(menu);

        menu = new JMenu("选项");
        jmb.add(menu);

        menu = new JMenu("工具");
        jmb.add(menu);

        menu = new JMenu("帮助");
        jmb.add(menu);

        jFrame.setJMenuBar(jmb);
    }

    public static void initMenuBar(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, new Double(SizeConstants.windowWidth * 0.8).intValue(), new Double(SizeConstants.windowHeight * 0.8).intValue(), Color.WHITE);

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        // File menu - new, save, exit
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
                new SeparatorMenuItem(), exitMenuItem);

        Menu webMenu = new Menu("Web");
        CheckMenuItem htmlMenuItem = new CheckMenuItem("HTML");
        htmlMenuItem.setSelected(true);
        webMenu.getItems().add(htmlMenuItem);

        CheckMenuItem cssMenuItem = new CheckMenuItem("CSS");
        cssMenuItem.setSelected(true);
        webMenu.getItems().add(cssMenuItem);

        Menu sqlMenu = new Menu("SQL");
        ToggleGroup tGroup = new ToggleGroup();
        RadioMenuItem mysqlItem = new RadioMenuItem("MySQL");
        mysqlItem.setToggleGroup(tGroup);

        RadioMenuItem oracleItem = new RadioMenuItem("Oracle");
        oracleItem.setToggleGroup(tGroup);
        oracleItem.setSelected(true);

        sqlMenu.getItems().addAll(mysqlItem, oracleItem,
                new SeparatorMenuItem());

        Menu tutorialManeu = new Menu("Tutorial");
        tutorialManeu.getItems().addAll(
                new CheckMenuItem("Java"),
                new CheckMenuItem("JavaFX"),
                new CheckMenuItem("Swing"));

        sqlMenu.getItems().add(tutorialManeu);

        menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu);

        primaryStage.setScene(scene);
    }
}
