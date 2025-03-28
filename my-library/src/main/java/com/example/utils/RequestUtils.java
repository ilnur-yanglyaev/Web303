package com.example.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

    public static String getXRequestIdHeader(HttpServletRequest request) {
        String xRequestId = request.getHeader("X-Request-ID");
        return xRequestId != null ? xRequestId : "no-request-id";
    }
}