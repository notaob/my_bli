package com.bli.my_bli.service;

import com.bli.my_bli.dto.Play;
import com.bli.my_bli.dto.Video;
import com.bli.my_bli.mapper.PlayMapper;
import com.bli.my_bli.mapper.VideoMapper;
import com.bli.my_bli.util.Bv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VideoService2 {
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private PlayMapper playMapper;

    public Video find(String bv){
        Video video = videoMapper.findByBv(bv);
        if(video == null){
            return null;
        }
        List<Play> playList = playMapper.findByBv(bv);
        video.setPlayList(playList);
        return video;
    }

    public String publish(Video video) {
        video.setPublishTime(LocalDateTime.now());//设置发布时间
        //1 video 插入数据
        videoMapper.insert(video);
        //2 生成bv号
        int id= videoMapper.lastInsertId();
        String bv= Bv.get(id);
        //3 更新bv号
        videoMapper.updateBv(bv,id);
        //4 向play插入视频选集
        for (Play play : video.getPlayList()) {
            playMapper.insert(play,bv);
        }
        return bv;
    }
}
