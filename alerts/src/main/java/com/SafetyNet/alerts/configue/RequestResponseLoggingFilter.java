package com.SafetyNet.alerts.configue;


import com.SafetyNet.alerts.controller.PersonController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;
import org.apache.http.impl.client.RequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
public class RequestResponseLoggingFilter implements Filter {



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Logger logger = LoggerFactory.getLogger(PersonController.class);

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        logger.info("Logging Request  {} : {} : {}", req.getMethod(), req.getRequestURI(), req.getQueryString());
        chain.doFilter(request, response);

        logger.info("Logging Response {} : {}", res.getStatus(), res.getContentType());
    }

}
