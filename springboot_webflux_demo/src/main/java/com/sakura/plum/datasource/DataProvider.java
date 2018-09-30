package com.sakura.plum.datasource;

import com.sakura.plum.domain.Sakura;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-29
 */
@Component
public class DataProvider {

    private static final List<Sakura> providerList = new ArrayList<>();

    public DataProvider() {
        this.providerList.add(new Sakura("aaaaaaaaaa"));
        this.providerList.add(new Sakura("AAAAAAAAAA"));
        this.providerList.add(new Sakura("bbbbbbbbbb"));
        this.providerList.add(new Sakura("BBBBBBBBBB"));
        this.providerList.add(new Sakura("cccccccccc"));
        this.providerList.add(new Sakura("CCCCCCCCCC"));
    }


    public Flux<Sakura> fetchSakuraInfo(Duration duration) {
        return Flux.fromIterable(generateSakuras());
    }

    private List<Sakura> generateSakuras() {
        return providerList;
    }
}
