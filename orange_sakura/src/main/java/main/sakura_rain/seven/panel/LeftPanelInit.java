package main.sakura_rain.seven.panel;

import main.sakura_rain.seven.consts.ProjectConstants;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName LeftPanelInit
 * @function [左边的面板]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/05/25 12:31
 */
public class LeftPanelInit {

    public static void renderLeftPanelFont() {
        ProjectConstants.INIT_LEFT_PANEL.setBackground(Color.gray);
        ProjectConstants.INIT_LEFT_PANEL.add(ProjectConstants.PROJECT_LIST);
    }
}
