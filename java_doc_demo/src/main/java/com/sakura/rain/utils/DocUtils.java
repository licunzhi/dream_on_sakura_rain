package com.sakura.rain.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName DocUtils
 * @Description docx模板渲染
 * @Author lcz
 * @Date 2019/06/19 13:56
 */
public class DocUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocUtils.class);


    public static String createDoc(String fileName, Map<String, Object> dataMap) {
        String uuid = UUID.randomUUID().toString();
        Configuration configuration;
        configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setDefaultEncoding("utf-8");
        String contextPath;
        try {
            contextPath = URLDecoder.decode(ClassUtils.getDefaultClassLoader().getResource("").getPath(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(">>>DocUtils createDoc decode template dir error: ", e);
            return null;
        }
        File file = new File(contextPath + "/static/model/" + uuid + ".doc");
        try (FileOutputStream fos = new FileOutputStream(file);
             OutputStreamWriter oWriter = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             Writer out = new BufferedWriter(oWriter)) {
            configuration.setDirectoryForTemplateLoading(new File(contextPath + "/static/model/"));
            Template template = configuration.getTemplate(fileName);
            template.process(dataMap, out);
        } catch (Exception e) {
            LOGGER.error(">>>DocUtils createDoc error, template dir error: ", e);
            return null;
        }
        return uuid;
    }
}
