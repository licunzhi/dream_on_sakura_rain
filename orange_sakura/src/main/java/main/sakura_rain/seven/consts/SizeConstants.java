package main.sakura_rain.seven.consts;

import java.awt.*;

/**
 * @ClassName SizeConstants
 * @function [界面尺寸信息]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/05/25 13:32
 */
public class SizeConstants {

    public static Integer windowWidth;

    public static Integer windowHeight;

    public static void initSizeConstant() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize =defaultToolkit.getScreenSize();
        windowWidth = screenSize.width;
        windowHeight = screenSize.height;
        System.out.println(windowHeight);
        System.out.println(windowWidth);
    }

}
