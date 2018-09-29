package com.sakura.plum;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-29
 */
@Component
public class ExitApplication implements ExitCodeGenerator {

    @Override
    public int getExitCode() {
        return 1228;
    }
}
