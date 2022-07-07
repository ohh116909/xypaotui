package com.zhang.xypaotui.service.impl;

import com.zhang.xypaotui.dao.MationForDao;
import com.zhang.xypaotui.pojo.Take;
import com.zhang.xypaotui.service.MationForService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MationForServiceImpl implements MationForService {

    @Autowired
    private MationForDao mationForDao;

    @Override
    public void save(Take take) {
        mationForDao.save(take);
    }

    @Override
    public List<Take> getAll() {
        return mationForDao.getAll();
    }
}
