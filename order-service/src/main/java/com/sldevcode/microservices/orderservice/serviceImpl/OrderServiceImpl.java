package com.sldevcode.microservices.orderservice.serviceImpl;

import com.sldevcode.microservices.orderservice.dto.OrderRequest;
import com.sldevcode.microservices.orderservice.dto.OrderResponse;
import com.sldevcode.microservices.orderservice.dto.UserCreationRequest;
import com.sldevcode.microservices.orderservice.dto.UserCreationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.UUID;

@Service
public class OrderServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

            public OrderResponse createOrder(OrderRequest orderRequest) {

                UserCreationRequest userCreationRequest = new UserCreationRequest();
                userCreationRequest.setAge(orderRequest.getAge());
                userCreationRequest.setFullName(orderRequest.getFullName());
                ResponseEntity<UserCreationResponse> userCreationResponse = restTemplate.postForEntity("http://localhost:8080/users" , userCreationRequest , UserCreationResponse.class);


                OrderResponse orderResponse = new OrderResponse();
                orderResponse.setOrderId(UUID.randomUUID().toString());
                orderResponse.setUserId(userCreationResponse.getBody().getUserId());
                orderResponse.setMessage("Successfuly Created the Order");

                return orderResponse;
            }

            @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
                return builder.build();
            }

}
