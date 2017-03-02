package impl;

import gen.HelloWordService;
import gen.Request;
import gen.RequestType;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @author 彭家玮
 * @version V1.0
 * @className HelloWorldClient
 * @description //TODO 描述这个类的作用
 * @date 2017/3/2
 */
public class HelloWorldClient {
    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 8090;
    public static final int TIMEOUT = 30000;

    /**
     *
     * @param userName
     */
    public void startClient(Request request) {
        TTransport transport = null;
        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            // TProtocol protocol = new TCompactProtocol(transport);
            // TProtocol protocol = new TJSONProtocol(transport);
            HelloWordService.Client client = new HelloWordService.Client(
                    protocol);
            transport.open();
            String result = client.doAction(request);
            System.out.println("Thrify client result =: " + result);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        HelloWorldClient client = new HelloWorldClient();
        Request request = new Request().setAge(22).setName("pengjiawei").setType(RequestType.QUERY_TIME);
        client.startClient(request);

    }

}
