package com.zhang.xypaotui.service.impl;

import com.zhang.xypaotui.dao.AddressDao;
import com.zhang.xypaotui.pojo.BigAddress;
import com.zhang.xypaotui.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;


    @Override
    public List<BigAddress> selectAll() {
        return addressDao.selectAll();
    }
}
