package com.example.springboothtml.serviceImpl;

import com.example.springboothtml.domain.ListData;
import com.example.springboothtml.service.ProductService;
import com.example.springboothtml.utils.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-11-17
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Value("${headers.cookie}")
    private String cookie;

    @Value("${sleep.time}")
    private Integer time;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<List<ListData.Mods.Item.Data.Auction>> scrapHtml(String query, Integer startPage,
                    Integer endPage, String fileName, Integer sortType, Boolean picture) {

        // 2018/11/18/018 优化并封装
        HttpHeaders headers = getHttpHeaders();

        //请求参数
        Map<String, String> params = new HashMap<>();
        if (sortType == 1) {
            params.put("sort", "");
        } else if (sortType == 2) {
            params.put("sort", "sale-desc");
        }
        List<ListData.Mods.Item.Data.Auction> resultList = new ArrayList<>();
        for (int page = startPage; page <= endPage; page++) {
            params.put("q", query);
            if (page == 1) {
                params.put("data-key", "s,ps");
                params.put("data-value", "0,1");
                params.put("s", "44");
            } else {
                params.put("data-key", "s");
                params.put("data-value", String.valueOf(44 * (page - 1)));
                params.put("s", String.valueOf(44 * (page - 2)));
            }
            String searchUrl =
                            "https://s.taobao.com/search?data-key=" + params.get("data-key") + "&q=" + params.get("q")
                                            + "&data-value=" + params.get("data-value") + "&s=" + params.get("s")
                                            + "&ajax=true&stats_click=search_radio_all:1&p4ppushleft=,44&bcoffset=0&js=1"
                                            + "&sort=" + params.get("sort")
                                            + "&imgfile=&initiative_id=staobaoz_20181118&style=list&ie=utf8";
            try {
                ResponseEntity<ListData> responseEntity =
                                restTemplate.exchange(searchUrl, HttpMethod.GET, new HttpEntity<String>(headers),
                                                ListData.class);
                HttpStatus statusCode = responseEntity.getStatusCode();

                if (!statusCode.toString().equals(HttpStatus.OK.value() + " " + HttpStatus.OK.name())) {
                    LOGGER.error("失败页数：" + page + "程序继续执行，如果多次出现失败消息请检验程序正确性");
                }
                ListData message = responseEntity.getBody();
                if (message != null && message.getMods() != null && message.getMods().getItemlist() != null
                                && message.getMods().getItemlist().getData() != null
                                && message.getMods().getItemlist().getData().getAuctions() != null) {
                    resultList.addAll(message.getMods().getItemlist().getData().getAuctions());
                }
                //避免连续请求
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    LOGGER.error("进程睡眠失败");
                }
                LOGGER.info("当前进度第{}页", page);
            } catch (Exception e) {
                LOGGER.info("返回结果出现格式问题，请检查接口，并重新发起对{}的请求", page);
            }
        }

        //excel存储工具
        excelAdapter(resultList, fileName, picture);
        LOGGER.info("进程结束");

        return new ResponseEntity(resultList, HttpStatus.OK);
    }

    private void excelAdapter(List<ListData.Mods.Item.Data.Auction> resultList, String fileName, Boolean picture) {
        // 加载模板文件
        String userDir = System.getProperty("user.dir");
        String relativelyPath = String.format("%s/springboot-html/report/excel.xls", userDir);
        String reportPath = String.format("%s/springboot-html/report/%s.xls", userDir, fileName);
        File file = new File(reportPath);
        try (InputStream fileInputStream = new FileInputStream(new File(relativelyPath));
                        FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
            hssfWorkbook = ExcelUtils.createDataSheet(hssfWorkbook, null, resultList, "数据分析抓取", picture);
            hssfWorkbook.write(fileOutputStream);
        } catch (FileNotFoundException e) {
            boolean delete = file.delete();
            LOGGER.info("删除临时文件{}", delete);
            LOGGER.error("读取模板文件失败", e);
        } catch (Exception e) {
            boolean delete = file.delete();
            LOGGER.info("删除临时文件{}", delete);
            LOGGER.error("生成报表存储本地操作失败", e);
        }

    }

    /*headers请求封装，使用账户为licunzhi199445 and password tracknick=licunzhi199445*/
    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("authority", "s.taobao.com");
        headers.add("method", "GET");
        ///headers.add("path", "/search?data-key=s&data-value=132&ajax=true&_ksTS=1542458652611_3046&callback=jsonp3047&q=%E8%8A%B1%E8%8C%B6&imgfile=&js=1&stats_click=search_radio_all%3A1&initiative_id=staobaoz_20181117&ie=utf8&style=list&bcoffset=0&ntoffset=6&p4ppushleft=%2C44&sort=sale-desc&s=88");
        headers.add("scheme", "https");
        headers.add("accept", "*/*");
        headers.add("accept-language", "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7");
        headers.add("cache-control", "no-cache");
        headers.add("cookie", cookie);
        headers.add("pragma", "no-cache");
        //headers.add("referer", "https://s.taobao.com/search?q=花茶&imgfile=&js=1&stats_click=search_radio_all:1&initiative_id=staobaoz_20181117&ie=utf8&style=list&bcoffset=0&ntoffset=6&p4ppushleft=,44&sort=sale-desc&s=88");
        headers.add("user-agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
        return headers;
    }
}
