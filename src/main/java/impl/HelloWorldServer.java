package impl;

import gen.HelloWordService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;

import java.net.InetSocketAddress;

/**
 * @author 彭家玮
 * @version V1.0
 * @className HelloWorldServer
 * @description //TODO 描述这个类的作用
 * @date 2017/3/2
 */
public class HelloWorldServer {
    public static void main(String[] args) throws Exception {
        TServerTransport serverTransport = new TServerSocket(new InetSocketAddress("127.0.0.1", 9981));
        TProcessor processor = new HelloWordService.Processor(new HelloWorldServiceImpl());
        TThreadPoolServer.Args trArgs = new TThreadPoolServer.Args(serverTransport);
        trArgs.processor(processor);
        // 使用二进制来编码应用层的数据
        trArgs.protocolFactory(new TBinaryProtocol.Factory(true, true));
        // 使用普通的socket来传输数据
        trArgs.transportFactory(new TTransportFactory());
        TServer server = new TThreadPoolServer(trArgs);
        System.out.println("server begin ......................");
        server.serve();
        System.out.println("---------------------------------------");
        server.stop();
    }
}
