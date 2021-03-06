package com.soha.soha.soap;

import com.soha.soha.log.AppLogger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/soap")
public class LogSoapController {


    @GetMapping("/log")
    public String logSoap(HttpServletRequest request) {
        try {

            RestTemplate restTemplate = new RestTemplate();
            String resourceUrl = "https://www.crcind.com/csp/samples/SOAP.Demo.cls?wsdl";
            ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);

            AppLogger.logRequest(request, LogSoapController.class);
            AppLogger.logResponses(response, LogSoapController.class);

            return response.getBody();

        } catch (Exception e) {
            e.printStackTrace();
            return "OOPS !! ";
        }

    }

}
