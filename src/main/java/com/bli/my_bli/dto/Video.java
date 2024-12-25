package com.bli.my_bli.dto;

import java.time.LocalDateTime;
import java.util.List;

public class Video {
    private String bv; //视频编号
    private String title; //视频标题
    private LocalDateTime publishTime; //发布时间
    private String cover; //封面
    private String introduction;// 简介
    private List<String> tagList; //多个标签

    private List<Play> playList;

    private String type; //类型:自制或转载
    private String category; // 分区:
    private String tags;

    public void setTags(String tags) {
        this.tags = tags;
    }



    public Video() {
    }

    public Video(String bv, String title, LocalDateTime publishTime, String cover, String introduction, List<String> tagList, List<Play> playList, String type, String category) {
        this.bv = bv;
        this.title = title;
        this.publishTime = publishTime;
        this.cover = cover;
        this.introduction = introduction;
        this.tagList = tagList;
        this.playList = playList;
        this.type = type;
        this.category = category;
    }

    public String getBv() {
        return bv;
    }

    public void setBv(String bv) {
        this.bv = bv;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTags() {
        return tags;
    }

    public List<String> getTagList() {
        String tags=this.tags;
        if(tags==null){
            return List.of();
        }
        String[] s=tags.split("_");
        return List.of(s);
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public List<Play> getPlayList() {
        return playList;
    }

    public void setPlayList(List<Play> playList) {
        this.playList = playList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
