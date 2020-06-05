package main.sakura_rain.seven.menu_listener;

import main.sakura_rain.seven.consts.ProjectConstants;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
     * <p>
     * - 弹出新的窗口输入项目的名称信息
     * - 需要保存项目的临时信息
     * - 文本框： 项目名称-XXX
     * - 提交信息： 保存 or 取消
     *
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
        projectNameLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        JTextField projectName = new JTextField(10);
        Border projectNameBorder = projectName.getBorder();
        JLabel descLabel = new JLabel("项目描述");
        descLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        JTextField desc = new JTextField(10);
        JButton saveButton = new JButton("保存");
        JButton cancelButton = new JButton("取消");

        /*取消点击监听事件*/
        cancelButton.addActionListener(e -> jDialog.dispose());
        /*保存点击监听事件*/
        saveButton.addActionListener(e -> {
            projectName.setBorder(projectNameBorder);
            desc.setBorder(projectNameBorder);
            HashMap<String, Object> simpleProject = new HashMap<>();
            String projectNameText = projectName.getText();
            String descText = desc.getText();
            if (StringUtils.isBlank(projectNameText)) {
                MatteBorder border = new MatteBorder(1, 1, 1, 1, new Color(192, 21,
                        43));
                projectName.setBorder(border);
            } else if (StringUtils.isBlank(descText)) {
                MatteBorder border = new MatteBorder(1, 1, 1, 1, new Color(192, 21,
                        43));
                desc.setBorder(border);
            } else {
                simpleProject.put("projectName", projectNameText);
                simpleProject.put("desc", desc.getText());
                ProjectConstants.projectInfo.add(simpleProject);
                jDialog.dispose();
            }
        });

        jDialog.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new GridLayout(2, 2));
        topPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        topPanel.add(projectNameLabel);
        topPanel.add(projectName);
        topPanel.add(descLabel);
        topPanel.add(desc);
        jDialog.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bottomPanel.add(saveButton);
        bottomPanel.add(cancelButton);
        jDialog.add(bottomPanel, BorderLayout.SOUTH);

        jDialog.pack();
        jDialog.setVisible(true);
        jDialog.setResizable(false);

    }


}
