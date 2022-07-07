package com.zhang.xypaotui.dao;

import com.zhang.xypaotui.pojo.BigAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AddressDao {
    List<BigAddress> selectAll();
}
