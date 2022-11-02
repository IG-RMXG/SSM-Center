package com.qf.pojo;

import lombok.Data;

/**
 * @author yangl
 * @version 1.0
 * @date 2022/10/31 15:28
 *
 * 歌曲表
 */

@Data
public class Music {

    private Integer musicId;
    private String musicName;
    private String musicAlbumName;
    private String musicAlbumPicurl;
    private String musicMp3url;
    private String musicArtistName;
    private Integer sheetId;

}
