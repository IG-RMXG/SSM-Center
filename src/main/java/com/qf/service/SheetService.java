package com.qf.service;

import com.qf.pojo.Sheet;

import java.util.List;

/**
 * @author yangl
 * @version 1.0
 * @date 2022/11/1 17:07
 */
public interface SheetService {

    /**
     * 查询所有歌单
     * @return
     */
    List<Sheet> findAll();

    /**
     * 添加歌单
     * @param sheetName
     */
    void addSheet(String sheetName);
}
