package main;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import model.User;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author licunzhi
 * @desc 测试excel文件生成
 * @date 2018-09-20
 */
public class TestExcel {
    public static void main(String[] args) throws Exception {

        File directory = new File("");//设定为当前文件夹
        System.out.println(directory.getCanonicalPath());//获取标准的路径
        System.out.println(directory.getAbsolutePath());//获取绝对路径
        // 配置信息
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
        configuration.setDirectoryForTemplateLoading(new File("E:\\dream_on_sakura_rain\\java_frermark_demo\\src\\main\\resources\\report"));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateUpdateDelayMilliseconds(0);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Template template = configuration.getTemplate("test_create.ftl");
        List<User> userList = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setName("sakura_" + i);
            user.setPassword(UUID.randomUUID().toString());
            user.setAddress(UUID.randomUUID().toString());
            userList.add(user);
        }

        Map<String, Object> root = new HashMap<>();
        root.put("userList", userList);
        root.put("size", userList.size() + 1);// 有一行设置为标题
        File file = new File("E:\\dream_on_sakura_rain\\java_frermark_demo\\src\\main\\resources\\report\\user.xls");
        FileWriter fw = new FileWriter(file);
        template.process(root, fw);
    }
}
