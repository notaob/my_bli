package com.bli.my_bli.mapper;

import com.bli.my_bli.dto.Video;
import org.apache.ibatis.annotations.*;

@Mapper
public interface VideoMapper {
    //根据bv号查询视频
    @Select("""
            select bv,
                   type,
                   category,
                   title,
                   cover,
                   introduction,
                   publish_time,
                   tags
            from video
            where bv=#{bv}
            """)
    Video findByBv(String bv);

    @Insert("""
            insert into video(type, category, title, cover, introduction, publish_time, tags)
            VALUES(#{type},#{category},#{title},#{cover},#{introduction},#{publishTime},#{tags})
            """)
    void insert(Video video);

    @Select("select last_insert_id()") //获取最新生成的自增主键值
    int lastInsertId();

    @Update("update video set bv=#{bv} where id=#{id}")
    void updateBv(@Param("bv") String bv,@Param("id") int id);
}


