package main.sakura_rain.seven.menu_listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName NewProjectListener
 * @function [新建项目监听器]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/05/25 12:57
 */
public class NewProjectListener implements ActionListener {

    private final JFrame jFrame;

    public NewProjectListener(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    /**
     * 重写监听操作的行为
     *
     * - 弹出新的窗口输入项目的名称信息
     * - 需要保存项目的临时信息
     * - 文本框： 项目名称-XXX
     * - 提交信息： 保存 or 取消
     * @param actionEvent 事件行为
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        /*在底层窗口上面创建新的窗口*/
        JDialog jDialog = new JDialog(jFrame, true);
        jDialog.setTitle("项目信息");
        jDialog.setLocationRelativeTo(jFrame);
        jDialog.setSize(350, 200);



        JLabel projectNameLabel = new JLabel("项目名称");
        JTextField projectName = new JTextField(10);
        JLabel descLabel = new JLabel("描述");
        JTextField desc = new JTextField(10);
        JButton saveButton = new JButton("保存");
        JButton cancelButton = new JButton("取消");

        /*进行网格布局*/
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());

        jPanel.add(projectNameLabel);
        jPanel.add(projectName);
        jPanel.add(descLabel);
        jPanel.add(desc);
        jPanel.add(saveButton);
        jPanel.add(cancelButton);
        Container contentPane = jDialog.getContentPane();
        contentPane.add(jPanel);

        jDialog.setVisible(true);

    }


}
