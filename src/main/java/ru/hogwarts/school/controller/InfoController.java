package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Value("${server.port}")
    private int ServerPort;

    @GetMapping("/getPort")
    public int getPort() {
        return ServerPort;
    }
    @GetMapping("/sum")
    public int getSum(){
        long time=System.currentTimeMillis();
        Stream.iterate(1,a->a+1)
                .limit(1_000_000)
                .reduce(0,Integer::sum);
        time=System.currentTimeMillis()-time;
        return (int) time;
    }

}

