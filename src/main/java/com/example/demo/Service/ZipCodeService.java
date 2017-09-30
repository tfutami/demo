package com.example.demo.Service;

import com.example.demo.dto.ZipCodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZipCodeService {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }

    @Autowired
//    @Qualifier("zipCodeSearchRestTemplate")
    RestTemplate restTemplate;

    private static final String URL = "http://zipcloud.ibsnet.co.jp/api/search?zipcode={zipcode}";

    public ZipCodeDto service(String zipcode){
        return restTemplate.getForObject(URL, ZipCodeDto.class, zipcode);
    }
}
