package com.qf.controller;

import com.qf.pojo.Sheet;
import com.qf.service.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yangl
 * @version 1.0
 * @date 2022/11/1 17:05
 */

@RestController
@RequestMapping("sheet")
public class SheetController {

    @Autowired
    private SheetService sheetService;

    /**
     * 查询所有歌单
     * @return
     */
    @RequestMapping("findAll")
    public List<Sheet> findAll(){
        return sheetService.findAll();
    }

    /**
     * 添加歌单
     * @param sheetName
     */
    @RequestMapping("addSheet")
    public void addSheet(String sheetName){
        sheetService.addSheet(sheetName);
    }
}
