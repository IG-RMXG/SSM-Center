package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.mapper.MusicMapper;
import com.qf.pojo.Music;
import com.qf.service.MusicService;
import com.qf.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangl
 * @version 1.0
 * @date 2022/10/31 15:32
 */

@RestController
@RequestMapping("music")
public class MusicController {

    @Autowired
    private MusicService musicService;


    /**
     * 查询所有歌曲
     * @return
     */
    @RequestMapping("findAll")
    public List<Music> findAll(){
        return musicService.findAll();
    }

    /**
     * 前端发送请求：url: 'http://localhost:8080/music/findByMusicName?musicName='+keyword
     * keyword 就是 模糊查询的内容，例如：夜空，光，....
     *
     * 模糊查询
     * @param musicName
     * @return
     */
    @RequestMapping("findByMusicName")
    public List<Music> findByMusicName(String musicName){
        return musicService.findByMusicName(musicName);
    }

    /**
     * 根据id查询歌曲
     * @param musicId
     * @return
     */
    @RequestMapping("findById/{musicId}")
    public Music findById(@PathVariable("musicId") Integer musicId){
        return musicService.findById(musicId);
    }

    /**
     * 查询下一首歌曲
     * @param musicId
     * @return
     */
    @RequestMapping("nextSong")
    public Music nextSong(Integer musicId){

        System.out.println("当前正在播放的歌曲的id：" + musicId);

        Music music = null;
        //判断
        if(musicId != null){
             music = musicService.nextSong(musicId);
        }else{
            throw new RuntimeException("参数不能为空");
        }

        return music;
    }


    /**
     * 查询上一首歌曲
     * @param musicId
     * @return
     */
    @RequestMapping("lastSong")
    public Music lastSong(Integer musicId){

        System.out.println("当前正在播放的歌曲的id：" + musicId);

        Music music = null;
        //判断
        if(musicId != null){
            music = musicService.lastSong(musicId);
        }else{
            throw new RuntimeException("参数不能为空");
        }

        return music;
    }



    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */

/*    @RequestMapping("findByPage")
    public PageInfo<Music> findByPage(
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",required = false,defaultValue = "2") Integer pageSize
    ){

        PageHelper.startPage(pageNum,pageSize);

        List<Music> musicList = musicService.findAll();

        PageInfo<Music> musicPageInfo = new PageInfo<>(musicList);

        return musicPageInfo;
    }*/

    /**
     *        如果前端要求返回这样的Json格式，我们就不能返回 PageInfo 格式了
     *         {
     *             "code": 0,
     *             "msg": "",
     *             "count": 1000,
     *             "data": [{}, {}]
     *         }
     */

/*    @RequestMapping("findByPage")
    public Map findByPage(
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",required = false,defaultValue = "2") Integer pageSize
    ){

        PageHelper.startPage(pageNum,pageSize);

        List<Music> musicList = musicService.findAll();

        PageInfo<Music> musicPageInfo = new PageInfo<>(musicList);

        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","success");
        map.put("count",musicPageInfo.getTotal());
        map.put("data",musicPageInfo.getList());

        return map;
    }*/

    @RequestMapping("findByPage")
    public JsonResult<Music> findByPage(
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",required = false,defaultValue = "2") Integer pageSize
    ){

        PageHelper.startPage(pageNum,pageSize);

        List<Music> musicList = musicService.findAll();

        PageInfo<Music> musicPageInfo = new PageInfo<>(musicList);

        JsonResult jsonResult = JsonResult.ok();
        jsonResult.setCount(musicPageInfo.getTotal());
        jsonResult.setData(musicPageInfo.getList());

        return jsonResult;
    }
}
