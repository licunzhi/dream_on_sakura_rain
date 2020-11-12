package entry;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName ProjectMain
 * @function [java实现处理图片透明度]
 * @Author lcz
 * @Date 2020/11/10 10:55
 */
public class ProjectMain {
    public static void main(String[] args) throws IOException {
        String srcFile = ProjectMain.class.getResource("/body.png").getPath();
        BufferedImage srcImage =  ImageIO.read(new File(srcFile));//取得图片
        int imgHeight = srcImage.getHeight();//取得图片的长和宽
        int imgWidth = srcImage.getWidth();
        int c = srcImage.getRGB(3, 3);
        int alpha = 0;
        //防止越位
        if (alpha < 0) {
            alpha = 0;
        } else if (alpha > 10) {
            alpha = 10;
        }
        BufferedImage bi = new BufferedImage(imgWidth, imgHeight,
                BufferedImage.TYPE_4BYTE_ABGR);//新建一个类型支持透明的BufferedImage
        for(int i = 0; i < imgWidth; ++i)//把原图片的内容复制到新的图片，同时把背景设为透明
        {
            for(int j = 0; j < imgHeight; ++j)
            {
                //把背景设为透明
                if(srcImage.getRGB(i, j) == c){
                    bi.setRGB(i, j, c & 0x00ffffff);
                }
                //设置透明度
                else{
                    int rgb = bi.getRGB(i, j);
                    rgb = ((alpha * 255 / 10) << 24) | (rgb & 0x00ffffff);
                    bi.setRGB(i, j, rgb);
                }
            }
        }
        ImageIO.write(bi, "png", new File("aaa.png"));
    }
}
