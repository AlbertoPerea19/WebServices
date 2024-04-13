package com.sd.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Service
public class SoapServiceClient extends WebServiceGatewaySupport{

   private final WebServiceTemplate webServiceTemplate;
   private String uri="http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";

   @Autowired
   public SoapServiceClient(WebServiceTemplate webServiceTemplate) {
      this.webServiceTemplate = webServiceTemplate;
   }

   public Object call(Object request) {
      return webServiceTemplate.marshalSendAndReceive(this.uri,request);
   }

}
