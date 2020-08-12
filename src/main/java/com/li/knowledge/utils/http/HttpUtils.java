package com.li.knowledge.utils.http;

import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;

/**
 * @author lifh
 * @version 2020/8/12
 * Http 工具类
 */
public class HttpUtils {
    /**
     * 获取请求的基础 URL
     * eg: http://www.example.com/war/api/aaa.jsp 返回 http://www.example.com/war
     *
     * @param request 请求
     * @return 基础 URL
     */
    public static String getBaseUrl(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" +
               request.getServerPort() + request.getContextPath();
    }

    /**
     * 获取完整的请求地址和参数
     *
     * @param request 请求
     * @return 完整的请求地址和参数
     */
    public static String getFullRequestUrl(HttpServletRequest request) {
        if (request == null) return null;

        String queryString = request.getQueryString();
        return request.getRequestURL().toString() +
               (StringUtils.isNotBlank(queryString) ? ("?" + queryString) : "");
    }

    /**
     * 获取客户端 IP 地址
     *
     * @param request 请求
     * @return IP 地址
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    /**
     * 判断当前请求是否为 ajax 请求
     *
     * @param request 请求
     * @return true：ajax 请求；false：非 ajax 请求
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}
