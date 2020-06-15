package com.sakura.rain;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * @ClassName JOLMain
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/15 08:54
 */
@Slf4j
public class JOLMain {
    public static void main(String[] args) {
        Object o = new Object();
        String toPrintable = ClassLayout.parseInstance(o).toPrintable();
        log.info(toPrintable);

        synchronized (o) {
            toPrintable = ClassLayout.parseInstance(o).toPrintable();
            log.info(toPrintable);
        }
    }
}
