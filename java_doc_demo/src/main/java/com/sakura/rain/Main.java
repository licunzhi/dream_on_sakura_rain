package com.sakura.rain;

import com.sakura.rain.utils.DocUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Main
 * @Description 主函数
 * @Author lcz
 * @Date 2019/06/19 08:41
 */
public class Main {
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        String file = Main.class.getResource("/model/template_doc.docx").getFile();
        DocUtils.generateWord(params, new File(file));

    }
}
