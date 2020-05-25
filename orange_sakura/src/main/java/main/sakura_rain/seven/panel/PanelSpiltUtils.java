package main.sakura_rain.seven.panel;

import javax.swing.*;

/**
 * @ClassName PanelSpiltUtils
 * @function [面板切开之后的样式工具类]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/05/25 12:48
 */
public class PanelSpiltUtils {

    public static void spiltPanelFont(JFrame jFrame, JPanel initLeftPanel, JPanel initRightPanel) {
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, initLeftPanel, initRightPanel);
        jSplitPane.setDividerLocation(200); //分割线的位置  也就是初始位置
        jSplitPane.setOneTouchExpandable(true); //是否可展开或收起，在这里没用
        jSplitPane.setDividerSize(9);//设置分割线的宽度 像素为单位
        jSplitPane.setEnabled(true);
        jFrame.add(jSplitPane);
    }
}
