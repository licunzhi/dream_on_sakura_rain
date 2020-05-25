package main.sakura_rain.seven.menu;

import main.sakura_rain.seven.menu_listener.NewProjectListener;

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
}
