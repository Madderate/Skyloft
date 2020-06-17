package com.madderate.skyloft.Utils;

import com.google.gson.Gson;
import com.madderate.skyloft.Models.MusicInfo;
import com.madderate.skyloft.Models.Playlist;
import com.madderate.skyloft.Models.PlaylistResult;
import com.madderate.skyloft.Models.Settings;
import com.madderate.skyloft.Models.StateCode;
import com.madderate.skyloft.Models.User;
import com.madderate.skyloft.Models.UserInfo;

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

    private static class PlaylistResultJson{
        private boolean hasTaste;
        private int category;
        private ArrayList<PlaylistResult> result;

        public boolean isHasTaste() {
            return hasTaste;
        }

        public void setHasTaste(boolean hasTaste) {
            this.hasTaste = hasTaste;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public ArrayList<PlaylistResult> getResult() {
            return result;
        }

        public void setResult(ArrayList<PlaylistResult> result) {
            this.result = result;
        }
    }
    public ArrayList<PlaylistResult> getPlaylistResult(String url, String body){
        communicateToSever(url,body);
        ArrayList<PlaylistResult> musicInfo = new ArrayList<>();
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText());
                try {
                    Gson gson = new Gson();
                    PlaylistResultJson playlistResultJson = gson.fromJson(c.getText(), PlaylistResultJson.class);
                    musicInfo = playlistResultJson.result;
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
    private static class PlayListJson{
        boolean more;
        ArrayList<Playlist> playlist;

        public boolean isMore() {
            return more;
        }

        public void setMore(boolean more) {
            this.more = more;
        }

        public ArrayList<Playlist> getPlaylist() {
            return playlist;
        }

        public void setPlaylist(ArrayList<Playlist> playlist) {
            this.playlist = playlist;
        }
    }
    public ArrayList<Playlist> getPlayList(String url, String body){
        communicateToSever(url,body);
        ArrayList<Playlist> playlists = new ArrayList<>();
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText());
                try {
                    Gson gson = new Gson();
                    PlayListJson playListJson = gson.fromJson(c.getText(), PlayListJson.class);
                    playlists = playListJson.playlist;
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
    private static class PlayListDetailJson{
        boolean relatedVideos;
        Playlist playlist;
        String urls;

        public boolean isRelatedVideos() {
            return relatedVideos;
        }

        public void setRelatedVideos(boolean relatedVideos) {
            this.relatedVideos = relatedVideos;
        }

        public Playlist getPlaylist() {
            return playlist;
        }

        public void setPlaylist(Playlist playlist) {
            this.playlist = playlist;
        }

        public String getUrls() {
            return urls;
        }

        public void setUrls(String urls) {
            this.urls = urls;
        }
    }
    public Playlist getPlayListDetail(String url, String body){
        communicateToSever(url,body);
        Playlist playlist = new Playlist();
        while (true){
            if(c.getText()!=null){
                System.out.println(c.getText());
                try {
                    Gson gson = new Gson();
                    PlayListDetailJson json = gson.fromJson(c.getText(), PlayListDetailJson.class);
                    playlist = json.playlist;
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
}
