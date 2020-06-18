package com.madderate.skyloft.Utils;

import com.google.gson.Gson;
import com.madderate.skyloft.Models.Artist;
import com.madderate.skyloft.Models.Music;
import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.Models.Playlist;
import com.madderate.skyloft.Result.ArtistResult;
import com.madderate.skyloft.Result.LikeListResult;
import com.madderate.skyloft.Result.LyricResult;
import com.madderate.skyloft.Result.MusicResult;
import com.madderate.skyloft.Models.PlaylistResult;
import com.madderate.skyloft.Models.Settings;
import com.madderate.skyloft.Models.StateCode;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Models.UserInfo;
import com.madderate.skyloft.Models.UserPlayRecord;
import com.madderate.skyloft.Result.MusicUrlResult;
import com.madderate.skyloft.Result.PersonalFMResult;
import com.madderate.skyloft.Result.PlayListDetailResult;
import com.madderate.skyloft.Result.PlayListResult;
import com.madderate.skyloft.Models.SimplePlaylist;
import com.madderate.skyloft.Result.RecommendMusicInfoResult;
import com.madderate.skyloft.Result.RecommendPlayListResult;
import com.madderate.skyloft.Result.UserPlayRecordResult;

import java.util.ArrayList;

public class JsonToClass {
    private CommunicationManager c;

    private void communicateToSever(String url, String body){
        c = new CommunicationManager();
        c.setInterUrl(url);
        c.setBody(body);
        c.httpGetter();
    }

    /*
     * 获取设置
     */
    public Settings getSettings(String url, String body){
        communicateToSever(url,body);
        Settings settings = new Settings();
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText().toString());
                try {
                    Gson gson = new Gson();
                    settings = gson.fromJson(c.getText(), Settings.class);
                    // TODO
                }catch (Exception e){
                    e.printStackTrace();
                }
                return settings;
            }
        }
    }
    /*
     * 获取歌曲信息结果
     */
    public ArrayList<MusicInfo> getMusicInfoResult(String url, String body){
        communicateToSever(url,body);
        ArrayList<MusicInfo> musicInfo = new ArrayList<>();
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText());
                try {
                    Gson gson = new Gson();
                    MusicResult musicResult = gson.fromJson(c.getText(), MusicResult.class);
                    musicInfo = musicResult.getResult();
                }catch (Exception e){
                    e.printStackTrace();
                }
                return musicInfo;
            }
        }
    }

    /*
     * 获取新歌曲信息结果
     */
    public ArrayList<UserPlayRecord> getUserPlayRecordResult(String url, String body){
        communicateToSever(url,body);
        ArrayList<UserPlayRecord> userPlayRecords = new ArrayList<>();
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText());
                try {
                    Gson gson = new Gson();
                    UserPlayRecordResult userPlayRecordResult = gson.fromJson(c.getText(), UserPlayRecordResult.class);
                    userPlayRecords = userPlayRecordResult.getResult();
                }catch (Exception e){
                    e.printStackTrace();
                }
                return userPlayRecords;
            }
        }
    }

    /*
     * 获取歌曲信息
     */

    public MusicInfo getMusicInfo(String url, String body){
        communicateToSever(url,body);
        MusicInfo musicInfo = new MusicInfo();
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText());
                try {
                    Gson gson = new Gson();
                    musicInfo = gson.fromJson(c.getText(), MusicInfo.class);
                    System.out.println(musicInfo.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                return musicInfo;
            }
        }
    }

    /*
     * 获取歌单结果
     */
    public ArrayList<PlaylistResult> getPlaylistResult(String url, String body){
        communicateToSever(url,body);
        ArrayList<PlaylistResult> musicInfo = new ArrayList<>();
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText());
                try {
                    Gson gson = new Gson();
                    SimplePlaylist simplePlaylist = gson.fromJson(c.getText(), SimplePlaylist.class);
                    musicInfo = simplePlaylist.getResult();
                    System.out.println(musicInfo.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                return musicInfo;
            }
        }
    }

    /*
     * 获取用户歌单信息（有什么歌单）
     */
    public ArrayList<Playlist> getPlayList(String url, String body){
        communicateToSever(url,body);
        ArrayList<Playlist> playlists = new ArrayList<>();
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText());
                try {
                    Gson gson = new Gson();
                    PlayListResult playListResult = gson.fromJson(c.getText(), PlayListResult.class);
                    playlists = playListResult.getPlaylist();
                    System.out.println(playlists.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                return playlists;
            }
        }
    }

    /*
     * 获取歌单详细信息（歌单有什么歌）
     */
    public Playlist getPlayListDetail(String url, String body){
        communicateToSever(url,body);
        Playlist playlist = new Playlist();
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText());
                try {
                    Gson gson = new Gson();
                    PlayListDetailResult json = gson.fromJson(c.getText(), PlayListDetailResult.class);
                    playlist = json.getPlaylist();
                    System.out.println(playlist.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                return playlist;
            }
        }
    }

    /*
     * 封装，获取账户信息
     */
    public void getUser(String url, String body){
        communicateToSever(url,body);
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText().toString());
                try {
                    Gson gson = new Gson();
                    User.setUser(gson.fromJson(c.getText(), User.class));
                    System.out.println(User.getInstance().toString());
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    /*
     * 封装，获取状态码信息
     */
    public StateCode getStateCode(String url, String body){
        communicateToSever(url,body);
        StateCode stateCode;
        while (true){
            if(c.getText()!=null){
                Gson gson = new Gson();
                stateCode = gson.fromJson(c.getText(), StateCode.class);
                return stateCode;
            }
        }
    }

    /*
     * 封装
     */
    public UserInfo getUserInfo(String url, String body){
        communicateToSever(url,body);
        UserInfo userInfo = new UserInfo();
        while (true){
            if(c.getText()!=null){
                try {
                    System.out.println(c.getText());
                    Gson gson = new Gson();
                    userInfo = gson.fromJson(c.getText(), UserInfo.class);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return userInfo;
            }
        }
    }

    // 获取音乐url json
    public ArrayList<Music> getMusicUrl(String url, String body){
        communicateToSever(url,body);
        ArrayList<Music> musics = new ArrayList<>();
        Gson gson = new Gson();
        while (true){
            if(c.getText()!=null){
                try {
                    MusicUrlResult musicUrlResult = gson.fromJson(c.getText(), MusicUrlResult.class);
                    musics = musicUrlResult.getData();
                }catch (Exception e){
                    e.printStackTrace();
                }
                return musics;
            }
        }
    }

    // 获取音乐歌词
    public String getMusicLyric(String url, String body){
        communicateToSever(url,body);
        Gson gson = new Gson();
        String lyric = null;
        while (true){
            if(c.getText()!=null){
                try {
                    LyricResult lyricResult = gson.fromJson(c.getText(), LyricResult.class);
                    lyric = lyricResult.getLrc().getLyric();
                }catch (Exception e){
                    e.printStackTrace();
                }
                return lyric;
            }
        }
    }

    // 获取推荐歌单
    public ArrayList<Playlist> getRecommendPlayList(String url, String body){
        communicateToSever(url,body);
        Gson gson = new Gson();
        ArrayList<Playlist> playlists = new ArrayList<>();
        while (true){
            if(c.getText()!=null){
                try {
                    RecommendPlayListResult result = gson.fromJson(c.getText(), RecommendPlayListResult.class);
                    playlists = result.getRecommend();
                }catch (Exception e){
                    e.printStackTrace();
                }
                return playlists;
            }
        }
    }

    // 获取推荐歌曲
    public ArrayList<Long> getRecommendSongs(String url, String body){
        communicateToSever(url,body);
        Gson gson = new Gson();
        ArrayList<Long> ids = new ArrayList<>();
        while (true){
            if(c.getText()!=null){
                try {
                    RecommendMusicInfoResult result = gson.fromJson(c.getText(), RecommendMusicInfoResult.class);
                    for(int i = 0;i<result.getRecommend().size();i++){
                        ids.set(i,result.getRecommend().get(i).getId());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                return ids;
            }
        }
    }

    // 获取私人电台
    public ArrayList<Playlist> getPersonalFM(String url, String body){
        communicateToSever(url,body);
        Gson gson = new Gson();
        ArrayList<Playlist> playlists = new ArrayList<>();
        while (true){
            if(c.getText()!=null){
                try {
                    PersonalFMResult result = gson.fromJson(c.getText(), PersonalFMResult.class);
                    playlists = result.getData();
                }catch (Exception e){
                    e.printStackTrace();
                }
                return playlists;
            }
        }
    }

    // 获取艺术家信息
    public Artist getArtist(String url, String body){
        communicateToSever(url,body);
        Gson gson = new Gson();
        Artist artist = new Artist();
        while (true){
            if(c.getText()!=null){
                try {
                    ArtistResult result = gson.fromJson(c.getText(), ArtistResult.class);
                    artist = result.getArtist();
                }catch (Exception e){
                    e.printStackTrace();
                }
                return artist;
            }
        }
    }

    // 获取喜欢的音乐信息
    public ArrayList<Long> getLikeList(String url, String body){
        communicateToSever(url,body);
        Gson gson = new Gson();
        ArrayList<Long> strings = new ArrayList<>();
        while (true){
            if(c.getText()!=null){
                try {
                    LikeListResult result = gson.fromJson(c.getText(), LikeListResult.class);
                    strings = result.getIds();
                }catch (Exception e){
                    e.printStackTrace();
                }
                return strings;
            }
        }
    }
}
