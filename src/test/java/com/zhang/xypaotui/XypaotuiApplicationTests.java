package com.zhang.xypaotui;

import com.zhang.xypaotui.dao.MationForDao;
import com.zhang.xypaotui.pojo.Take;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class XypaotuiApplicationTests {

    @Autowired
    private MationForDao mationForDao;
    @Test
    void contextLoads() {
        List<Take> all = mationForDao.getAll();
        System.out.println(all);
    }

}
