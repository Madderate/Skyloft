package com.madderate.skyloft.Utils;

import com.google.gson.Gson;
import com.madderate.skyloft.Models.Music;
import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.Models.Playlist;
import com.madderate.skyloft.Result.LyricResult;
import com.madderate.skyloft.Result.MusicResult;
import com.madderate.skyloft.Models.PlaylistResult;
import com.madderate.skyloft.Models.Settings;
import com.madderate.skyloft.Models.StateCode;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Models.UserInfo;
import com.madderate.skyloft.Models.UserPlayRecord;
import com.madderate.skyloft.Result.MusicUrlResult;
import com.madderate.skyloft.Result.PlayListDetailJson;
import com.madderate.skyloft.Result.PlayListJson;
import com.madderate.skyloft.Result.PlaylistResultJson;
import com.madderate.skyloft.Result.UserPlayRecordResultJson;

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
                    UserPlayRecordResultJson userPlayRecordResultJson = gson.fromJson(c.getText(), UserPlayRecordResultJson.class);
                    userPlayRecords = userPlayRecordResultJson.getResult();
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
                    PlaylistResultJson playlistResultJson = gson.fromJson(c.getText(), PlaylistResultJson.class);
                    musicInfo = playlistResultJson.getResult();
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
                    PlayListJson playListJson = gson.fromJson(c.getText(), PlayListJson.class);
                    playlists = playListJson.getPlaylist();
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
                    PlayListDetailJson json = gson.fromJson(c.getText(), PlayListDetailJson.class);
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
}
