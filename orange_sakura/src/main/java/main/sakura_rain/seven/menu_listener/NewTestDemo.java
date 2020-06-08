package main.sakura_rain.seven.menu_listener;

import main.sakura_rain.seven.consts.ProjectConstants;
import main.sakura_rain.seven.consts.SizeConstants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName NewTestDemo
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/05 17:14
 */
public class NewTestDemo implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("项目信息");
        jFrame.setLocationRelativeTo(ProjectConstants.JFRAME);

        jFrame.setSize(new Double(SizeConstants.windowWidth * 0.2).intValue(), new Double(SizeConstants.windowHeight * 0.2).intValue());
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
