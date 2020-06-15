package com.yuhao.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 类的描述
 *
 * @author Wangjinghao
 * @version v1.0.0
 * @date 2019/6/11
 */
@Component
public class GrpcClient {

    private GreeterGrpc.GreeterBlockingStub blockingStub;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(GrpcClient.class);

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 9090).usePlaintext().build();

        blockingStub =
                GreeterGrpc.newBlockingStub(managedChannel);
    }

    public String sayHello(String name) {
        HelloRequest person = HelloRequest.newBuilder().setName(name).build();
        LOGGER.info("client sending {}", person);

        HelloReply greeting =
                blockingStub.sayHello(person);
        LOGGER.info("client received {}", greeting);

        return greeting.getMessage();
    }

}
