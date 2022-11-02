package com.qf.service;

import com.qf.pojo.Music;

import java.util.List;

/**
 * @author yangl
 * @version 1.0
 * @date 2022/10/31 15:34
 */
public interface MusicService {

    /**
     * 查询所有歌曲
     * @return
     */
    List<Music> findAll();

    /**
     * 模糊查询
     * @param musicName
     * @return
     */
    List<Music> findByMusicName(String musicName);

    /**
     * 根据id查询歌曲
     * @param musicId
     * @return
     */
    Music findById(Integer musicId);

    /**
     * 下一首歌曲
     * @param musicId
     * @return
     */
    Music nextSong(Integer musicId);

    /**
     * 上一首歌曲
     * @param musicId
     * @return
     */
    Music lastSong(Integer musicId);
}
