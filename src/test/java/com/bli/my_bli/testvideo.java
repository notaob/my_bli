package com.bli.my_bli;

import com.bli.my_bli.dto.Video;
import com.bli.my_bli.mapper.VideoMapper;
import com.bli.my_bli.util.Bv;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class testvideo {
    @Autowired
    private VideoMapper videoMapper;
    @Test
    public void test1(){
        Video v= videoMapper.findByBv("1");
        System.out.println(v.getType());
        System.out.println(v.getCover());
        System.out.println(v.getTagList());
        System.out.println(v.getPublishTime());
    }
    @Test
    public void test2(){
        Video v = new Video();
        v.setType("转发");
        v.setCategory("动漫");
        v.setTitle("海贼3");
        v.setCover("3.png");
        v.setIntroduction("简介...");
        v.setPublishTime(LocalDateTime.now());
        v.setTags("日本_热血_动漫");

        videoMapper.insert(v);

        int id = videoMapper.lastInsertId();
        System.out.println(id);

        String bv= Bv.get(id);
        videoMapper.updateBv(bv,id);
    }
}
