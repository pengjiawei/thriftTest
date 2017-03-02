package impl;

import gen.HelloWordService;
import gen.Request;
import gen.RequestException;
import gen.RequestType;
import org.apache.thrift.TException;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author 彭家玮
 * @version V1.0
 * @className HelloWorldServiceImpl
 * @description //TODO 描述这个类的作用
 * @date 2017/3/2
 */
public class HelloWorldServiceImpl implements HelloWordService.Iface {
    public String doAction(Request request) throws RequestException, TException {
        System.out.println("request = "+request);
        String result = "Hello, " + request.getName();
        if (request.getType() == RequestType.SAY_HELLO) {
            result += ", Welcome!";
        } else {
            result += ", Now is " + DateFormat.getInstance();
        }
        return result;
    }
}
