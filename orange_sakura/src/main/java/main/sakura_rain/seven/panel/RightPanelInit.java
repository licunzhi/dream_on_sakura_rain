package main.sakura_rain.seven.panel;

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

    public JPanel initRightPanel(JFrame jFrame) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.gray);
        JButton button = new JButton("Press me");
        panel.add(button); // 将JButton实例添加到JPanel中
        jFrame.add(panel, BorderLayout.EAST);
        return panel;
    }
}
