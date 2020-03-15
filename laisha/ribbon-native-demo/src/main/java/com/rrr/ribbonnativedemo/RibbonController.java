package com.rrr.ribbonnativedemo;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rx.Observable;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RibbonController {

    @GetMapping("ribbon/test")
    @ResponseBody
    public String test() {

        List<Server> serverList = new ArrayList<>();
        serverList.add(new Server("localhost", 8081));
        serverList.add(new Server("localhost", 8083));

        ILoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(serverList);
        for (int i = 0; i < 5; i++) {
            String result = LoadBalancerCommand.<String>builder().withLoadBalancer(loadBalancer).build()
            .submit(new ServerOperation<String>() {
                @Override
                public Observable<String> call(Server server) {
                    try {
                        String addr = "http://" + server.getHost() + ":" + server.getPort() + "/user/hello";
                        System.out.println("调用地址:" + addr);
                        URL url = new URL(addr);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.connect();
                        InputStream in = connection.getInputStream();
                        byte[] data = new byte[in.available()];
                        in.read(data);
                        return Observable.just(new String(data));
                    } catch (Exception e) {
                        return Observable.error(e);
                    }
                }
            }).toBlocking().first();
            System.out.println("调用结果:" + result);
        }

        return "";
    }


}
