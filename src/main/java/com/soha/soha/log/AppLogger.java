package com.soha.soha.log;

import com.soha.soha.rest.LogRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AppLogger {

    /**
     * This Method id Logging  Requests
     *
     * @param request
     * @param clazz
     */
    public static void logRequest(HttpServletRequest request, Class clazz) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info("Request Method : " + request.getMethod());
        logger.info("Request Address : " + request.getRemoteAddr());
        logger.info("Request URL : " + request.getRequestURL().toString());
        logger.info("Request URI : " + request.getRequestURI());
    }

    /**
     * this method logs the response and requests( in the file and console )
     *
     * @param response
     * @param clazz
     * @throws IOException
     */
    public static void logResponses(ResponseEntity<String> response, Class clazz) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info("Header : " + response.getHeaders().toString());
        logger.info("Body : " + response.getBody());

    }


}
