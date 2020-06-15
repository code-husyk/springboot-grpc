package com.yuhao.grpc.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/grpc", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GrpcContorller {

    @Autowired
private GrpcClient client;


    @GetMapping(value = "/name")
    public Object logout(@RequestParam("name") String name) {
        return client.sayHello(name);
    }


}
