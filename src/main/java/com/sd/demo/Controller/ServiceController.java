package com.sd.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.sd.demo.Services.RestServiceClient;
import com.sd.demo.Services.SoapServiceClient;

@Controller
public class ServiceController {

   private SoapServiceClient soapServiceClient;
   private RestServiceClient restServiceClient;

   @Autowired
   public ServiceController(SoapServiceClient soapServiceClient, RestServiceClient restServiceClient) {
      this.soapServiceClient = soapServiceClient;
      this.restServiceClient = restServiceClient;
   }

   @PostMapping(path = "/soap",consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Object soap(@RequestBody String request) {
        System.out.println(request);
        return soapServiceClient.call(request);
    }


   @GetMapping("/restIP/{ip}")
   public Object restIp(@RequestParam String ip){
      return restServiceClient.ipCall(ip);
   }

   @GetMapping("/restObjects")
   public Object restObjects(){
      return restServiceClient.listObjects();
   }

   
}
