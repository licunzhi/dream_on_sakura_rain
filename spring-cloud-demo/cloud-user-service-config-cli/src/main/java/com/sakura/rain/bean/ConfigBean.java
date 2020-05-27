package com.sakura.rain.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ConfigBean
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/03/26 23:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Configuration
public class ConfigBean {

}
