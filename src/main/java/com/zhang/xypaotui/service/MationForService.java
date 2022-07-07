package com.zhang.xypaotui.service;

import com.zhang.xypaotui.pojo.Take;

import java.util.List;

public interface MationForService {
    void save(Take take);
    List<Take> getAll();
}
