package com.yy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class SseController {
    @RequestMapping(value = "/push",produces = {"text/event-stream;charset=utf-8"})
    @ResponseBody
    public String push(){
        Random r=new Random();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "data:SSE 1,2,3  "+r.nextInt()+"\n\n";
    }
}
