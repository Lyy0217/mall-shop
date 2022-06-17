package com.imooc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描mybaits 通用mapper 所在的包
@MapperScan(basePackages = "com.imooc.mapper")
//扫描所有包，以及相关组件包
@ComponentScan(basePackages = {"com.imooc", "org.n3r.idworker"})
@EnableScheduling       // 开启定时任务
public class Application {
    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);

        //List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //System.out.println(list.subList(0, 2));
        Map<String, Object> map = new HashMap<>();
        map.put("3", 77);
        System.out.println(map.get("3") + "====" + map.get("4"));
    }


}
