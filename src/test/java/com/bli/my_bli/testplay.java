package com.bli.my_bli;

import com.bli.my_bli.dto.Play;
import com.bli.my_bli.mapper.PlayMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class testplay {

    @Autowired
    private PlayMapper playMapper;

    @Test
    public void test(){
        List<Play> list = playMapper.findByBv("1");
        System.out.println(list.size());
    }
}
