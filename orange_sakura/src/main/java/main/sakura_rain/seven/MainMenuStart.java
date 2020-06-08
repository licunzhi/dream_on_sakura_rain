package main.sakura_rain.seven;

import main.sakura_rain.seven.consts.ProjectConstants;
import main.sakura_rain.seven.consts.SizeConstants;
import main.sakura_rain.seven.main.MainContainer;
import main.sakura_rain.seven.menu.MenuBarInit;

import javax.swing.*;

/**
 * @ClassName MainMenuStart
 * @function [启动入口]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/05/25 09:55
 */
public class MainMenuStart {


    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        /*尺寸信息初始化*/
        SizeConstants.initSizeConstant();

        ProjectConstants.JFRAME = new JFrame();

        /*顶部菜单初始化*/
        MenuBarInit menuBarInit = new MenuBarInit();
        menuBarInit.initMenuBar(ProjectConstants.JFRAME);


        /*初始化整体样式*/
        MainMenuStart mainMenuStart = new MainMenuStart();
        mainMenuStart.initLocalFont(ProjectConstants.JFRAME);

        ProjectConstants.JFRAME.setContentPane(MainContainer.outerPanel);
    }

    public void initLocalFont(JFrame jFrame) {
        /*项目标题*/
        jFrame.setTitle("七樱");
        ImageIcon icon = new ImageIcon("images\\jsb.png");
        jFrame.setIconImage(icon.getImage());
        /*黄金分割比例*/
        jFrame.setSize(new Double(SizeConstants.windowWidth * 0.8).intValue(), new Double(SizeConstants.windowHeight * 0.8).intValue());
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
