package com.bli.my_bli.service;

import com.bli.my_bli.dto.Play;
import com.bli.my_bli.dto.Video;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * 从文件中获取视频数据
 */
@Service
public class VideoService1 {
    //查询方发，根据视频编号，查询Video对象
    public Video find(String bv){
//        try {
//            List <String> data = Files.readAllLines(Path.of("data","p.csv"));
//            for(String line : data){
//                String[] s = line.split(",");
//                if (s[0].equals(bv)){//找到
//                    String[] tags = s[7].split("_");
//                    //读取选集文件
//                    List<Play> list = getPlayList(bv);
//                    return new Video(s[0],s[3], LocalDateTime.parse(s[6]),s[4],s[5], Arrays.asList(tags),list,s[1],s[2]);
//
//
//                }
//            }
//            //没有找到
//            return null;
//        } catch (IOException e) {
//            // RuntimeException 运行时异常
//            throw new RuntimeException(e);
//        }
        return map.get(bv);
    }

    private static List<Play> getPlayList(String bv) throws IOException {
        List<String> vdata=Files.readAllLines(Path.of("data","v_"+ bv +".csv"));
        List<Play> list = new ArrayList<>();
        for (String vline : vdata){
            String[] ss = vline.split(",");
            list.add(new Play(ss[0],ss[1], LocalTime.parse(ss[3]),ss[2]));
        }
        return list;
    }
    //map
    /*
    1 -> Video 1
     */
    Map<String,Video> map = new HashMap<>();
    public VideoService1(){

    }
    @PostConstruct //初始化方法，对象创建只会调用一次
    public void init(){
        try {
            List <String> data = Files.readAllLines(Path.of("data","p.csv"));
            for(String line : data){
                String[] s = line.split(",");
                String[] tags = s[7].split("_");
                Video video=new Video(s[0],s[3], LocalDateTime.parse(s[6]),s[4],s[5], Arrays.asList(tags),getPlayList(s[0]),s[1],s[2]);
                map.put(s[0],video);
            }
        } catch (IOException e) {
            // RuntimeException 运行时异常
            throw new RuntimeException(e);
        }
    }
}
