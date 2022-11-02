package com.qf.mapper;

import com.qf.pojo.Music;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangl
 * @version 1.0
 * @date 2022/10/31 15:36
 */

@Repository
public interface MusicMapper {

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
     * 根据id查询
     * @param musicId
     * @return
     */
    Music findById(Integer musicId);
}
