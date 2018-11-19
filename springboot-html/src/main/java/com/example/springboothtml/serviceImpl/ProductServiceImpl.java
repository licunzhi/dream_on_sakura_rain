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
        headers.add("cookie",
                        "mt=ci%3D-1_0; miid=6410171181014946490; cna=+gLKEqEm1HoCATFN5NrvLalJ; hng=CN%7Czh-CN%7CCNY%7C156; thw=cn; tracknick=licunzhi199445; tg=0; enc=TAoegzYGjo7sfcGfASTEVEjGNPXtGunyqZeJqZ7UhM0LEzougtehONuY0OIwBguXrrzOa1V7GpY9JagpulRtSw%3D%3D; x=e%3D1%26p%3D*%26s%3D0%26c%3D0%26f%3D0%26g%3D0%26t%3D0%26__ll%3D-1; UM_distinctid=163e427b5415b2-0169f7ffb39ee8-47e1f32-100200-163e427b54381b; t=a766548d1bfdacd5affef6709b34baf8; cookie2=313887c86d6034871d3d6bb48e23493f; _tb_token_=54e3369ee5f15; alitrackid=www.taobao.com; lastalitrackid=www.taobao.com; lgc=licunzhi199445; _cc_=UIHiLt3xSw%3D%3D; swfstore=67658; v=0; skt=cd33a6343a4b1fb2; csg=e9ce35fd; uc3=vt3=F8dByR6sEl7RYcswk9E%3D&id2=Uone%2BXZ9rPayow%3D%3D&nk2=D8rlHFEl%2F4H2%2BOb%2FffU%3D&lg2=UIHiLt3xD8xYTw%3D%3D; existShop=MTU0MjQ2NzMxNA%3D%3D; dnk=licunzhi199445; whl=-1%260%260%261542472360121; mt=ci=-1_0; uc1=cookie16=VT5L2FSpNgq6fDudInPRgavC%2BQ%3D%3D&cookie21=UtASsssmeW6lpyd%2BB%2B3t&cookie15=V32FPkk%2Fw0dUvg%3D%3D&existShop=false&pas=0&cookie14=UoTYNOpE6A61UA%3D%3D&tag=8&lng=zh_CN; x5sec=7b227365617263686170703b32223a223030366266323032353863633666663436326665623935323936643730313937434d576477393846454d6d6f792b50387570797245686f4d4d5467314f544d344d4463344f447378227d; JSESSIONID=9A349577B04B6E65DFB05FE6F7566A89; isg=BKurYDZPdALmSKnDalUlFRaeOs9VaKBXDtJ5-B0lweCEvNkeoJEskhNaErx3pxc6");
        headers.add("pragma", "no-cache");
        //headers.add("referer", "https://s.taobao.com/search?q=花茶&imgfile=&js=1&stats_click=search_radio_all:1&initiative_id=staobaoz_20181117&ie=utf8&style=list&bcoffset=0&ntoffset=6&p4ppushleft=,44&sort=sale-desc&s=88");
        headers.add("user-agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
        return headers;
    }
}
