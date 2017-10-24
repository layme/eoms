package com.gwssi.eoms.monitor;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Druid监控平台
 * Created by admin on 2017/10/24.
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/druid/*",
        initParams = {
                @WebInitParam(name = "allow", value = "10.75.12.32"),
                @WebInitParam(name = "loginUsername", value = "admin"),
                @WebInitParam(name = "loginPassword", value = "qwer5678"),
                @WebInitParam(name = "resetEnable", value = "false")
        })
public class DruidStatViewServlet extends StatViewServlet {}