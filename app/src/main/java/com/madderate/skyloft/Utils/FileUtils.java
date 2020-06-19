package com.madderate.skyloft.Utils;

import android.os.Environment;

import java.io.File;

public class FileUtils {
    private String path = Environment.getExternalStorageDirectory().toString() + "/Mydownload";

    public FileUtils() {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public File createFile(String FileName) {
        return new File(path, FileName);
    }
}
