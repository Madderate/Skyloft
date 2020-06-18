package com.madderate.skyloft.Result;

public class LyricResult {
    Lyric lrc;

    public Lyric getLrc() {
        return lrc;
    }

    public void setLrc(Lyric lrc) {
        this.lrc = lrc;
    }

    public static class Lyric{
        String lyric;

        public String getLyric() {
            return lyric;
        }

        public void setLyric(String lyric) {
            this.lyric = lyric;
        }
    }
}
