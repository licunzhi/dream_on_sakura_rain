package main.sakura_rain.seven.panel;

import main.sakura_rain.seven.consts.ProjectConstants;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName LeftPanelInit
 * @function [右边的面板]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/05/25 12:31
 */
public class RightPanelInit {

    public static void renderLeftPanelFont() {
        ProjectConstants.INIT_RIGHT_PANEL.setBackground(Color.gray);
        JButton button = new JButton("Press me");
        ProjectConstants.INIT_RIGHT_PANEL.add(button);
        ProjectConstants.JFRAME.add(ProjectConstants.INIT_RIGHT_PANEL, BorderLayout.EAST);
    }
}
