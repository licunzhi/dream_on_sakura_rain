package main.sakura_rain.seven;

import main.sakura_rain.seven.consts.SizeConstants;
import main.sakura_rain.seven.menu.MenuBarInit;
import main.sakura_rain.seven.panel.LeftPanelInit;
import main.sakura_rain.seven.panel.PanelSpiltUtils;
import main.sakura_rain.seven.panel.RightPanelInit;

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
        /*尺寸信息初始化*/
        SizeConstants.initSizeConstant();

        JFrame jFrame = new JFrame();

        /*顶部菜单初始化*/
        MenuBarInit menuBarInit = new MenuBarInit();
        menuBarInit.initMenuBar(jFrame);

        /*左右两部分面板初始化，修正分割线的功能*/
        LeftPanelInit leftPanelInit = new LeftPanelInit();
        JPanel initLeftPanel = leftPanelInit.initLeftPanel(jFrame);
        RightPanelInit rightPanelInit = new RightPanelInit();
        JPanel initRightPanel = rightPanelInit.initRightPanel(jFrame);
        PanelSpiltUtils.spiltPanelFont(jFrame, initLeftPanel, initRightPanel);


        /*初始化整体样式*/
        MainMenuStart mainMenuStart = new MainMenuStart();
        mainMenuStart.initLocalFont(jFrame);
    }

    public void initLocalFont(JFrame jFrame) {
        /*项目标题*/
        jFrame.setTitle("sakura_seven");
        ImageIcon icon = new ImageIcon("images\\jsb.png");
        jFrame.setIconImage(icon.getImage());
        /*黄金分割比例*/
        jFrame.setSize(1536, 864);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
