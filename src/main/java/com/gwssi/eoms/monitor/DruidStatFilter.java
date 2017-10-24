package com.gwssi.eoms.monitor;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Druid监控平台过滤器
 * Created by admin on 2017/10/24.
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
})
public class DruidStatFilter extends WebStatFilter {}
