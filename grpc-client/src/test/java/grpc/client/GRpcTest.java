package grpc.client;

import com.yuhao.grpc.client.GrpcClient;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GRpcTest {

    @Test
    public void test() throws Exception {
        GrpcClient client=new GrpcClient();
        assertThat(client.sayHello("yuhao.zou"))
                .isEqualTo("Hello yuhao.zou!");
    }
}
