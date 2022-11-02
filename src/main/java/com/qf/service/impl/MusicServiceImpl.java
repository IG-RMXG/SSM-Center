package com.qf.service.impl;

import com.qf.mapper.MusicMapper;
import com.qf.pojo.Music;
import com.qf.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yangl
 * @version 1.0
 * @date 2022/10/31 15:35
 */

@Transactional
@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicMapper musicMapper;

    @Override
    public List<Music> findAll() {
        return musicMapper.findAll();
    }

    @Override
    public List<Music> findByMusicName(String musicName) {
        return musicMapper.findByMusicName(musicName);
    }

    @Override
    public Music findById(Integer musicId) {
        return musicMapper.findById(musicId);
    }

    @Override
    public Music nextSong(Integer musicId) {
        //通过当前歌曲的id，获取到当前歌曲的下标，因为下标是连续的
        //声明一个变量，用于存储当前歌曲的下标
        Integer currentMusicIndex = null;
        //先把所有的歌曲查询出来
        List<Music> musicList = musicMapper.findAll();
        //判断
        if(musicList.size() > 0){
            //遍历
            for (int i = 0; i < musicList.size(); i++) {
                //判断，如果id一样，i就是下标
                if(musicList.get(i).getMusicId().equals(musicId)){
                    currentMusicIndex = i;
                    break;
                }
            }
        }

        //当前歌曲的下标拿到了，我们只需要通过当前歌曲的下标返回下一首歌曲
        //返回下一首，考虑当前歌曲是不是最后一首，如果是最后一首则返回第一首歌曲，如果不是最后一首则下标 + 1
        Integer nextSongIndex =
        currentMusicIndex == musicList.size() - 1 ? 0 : currentMusicIndex + 1;

        return musicList.get(nextSongIndex);
    }

    @Override
    public Music lastSong(Integer musicId) {
        //通过当前歌曲的id，获取到当前歌曲的下标，因为下标是连续的
        //声明一个变量，用于存储当前歌曲的下标
        Integer currentMusicIndex = null;
        //先把所有的歌曲查询出来
        List<Music> musicList = musicMapper.findAll();
        //判断
        if(musicList.size() > 0){
            //遍历
            for (int i = 0; i < musicList.size(); i++) {
                //判断，如果id一样，i就是下标
                if(musicList.get(i).getMusicId().equals(musicId)){
                    currentMusicIndex = i;
                    break;
                }
            }
        }

        //当前歌曲的下标拿到了，我们只需要通过当前歌曲的下标返回上一首歌曲
        //返回上一首，考虑当前歌曲是不是第一首，如果是第一首则返回最后一首，如果不是第一首则下标 - 1
        Integer lastSongIndex =
                currentMusicIndex == 0 ? musicList.size() - 1 : currentMusicIndex - 1;

        return musicList.get(lastSongIndex);
    }
}
