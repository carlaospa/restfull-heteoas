package com.carlaospa.restfull.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class FilterJava implements Filter {


    private Logger logger = LoggerFactory.getLogger(FilterJava.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        logger.info("Chegou no portão do castelo");

        HttpServletRequest req = (HttpServletRequest) request;
        Enumeration<String> headerNames = req.getHeaderNames();
        Map<String, String> mapHeaders  = Collections.list(headerNames)
                .stream()
                .collect(Collectors.toMap(it-> it, req::getHeader));

        if (mapHeaders.get("authorization") != null && mapHeaders.get("authorization").equals("batatinha")){

            chain.doFilter(request, response);

        }else{
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendError(403);
            return;
        }

        logger.info("Saiu do portão do castelo");
    }
}
