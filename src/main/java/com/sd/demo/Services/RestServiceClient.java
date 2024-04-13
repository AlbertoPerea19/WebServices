package com.sd.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceClient {
   
   private final RestTemplate restTemplate;

   @Autowired
   public RestServiceClient(RestTemplate restTemplate) {
      this.restTemplate = restTemplate;
   }

   public Object ipCall(String ip){
      return restTemplate.getForObject("https://ipapi.co/"+ip+"/json", Object.class);
   }

   public Object listObjects(){
      return restTemplate.getForObject("https://api.restful-api.dev/objects", Object.class);
   }
}
