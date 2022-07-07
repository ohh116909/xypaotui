package com.zhang.xypaotui.dao;

import com.zhang.xypaotui.pojo.Take;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MationForDao {
   void save(Take take);
   List<Take> getAll();
}
