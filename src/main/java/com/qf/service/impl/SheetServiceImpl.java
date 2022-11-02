package com.qf.service.impl;

import com.qf.mapper.SheetMapper;
import com.qf.pojo.Sheet;
import com.qf.service.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yangl
 * @version 1.0
 * @date 2022/11/1 17:07
 */

@Transactional
@Service
public class SheetServiceImpl implements SheetService {

    @Autowired
    private SheetMapper sheetMapper;

    @Override
    public List<Sheet> findAll() {
        return sheetMapper.findAll();
    }

    @Override
    public void addSheet(String sheetName) {
        sheetMapper.addSheet(sheetName);
    }
}
