package com.yuhao.grpc.server;

import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

import java.util.logging.Logger;

/**
 * 类的描述
 *
 * @author Wangjinghao
 * @version v1.0.0
 * @date 2019/6/11
 */
@GRpcService
public class GrpcServer extends GreeterGrpc.GreeterImplBase  {
    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage(("Hello "+req.getName())).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
        System.out.println("Message from gRPC-Client:" + req.getName());
    }
}
