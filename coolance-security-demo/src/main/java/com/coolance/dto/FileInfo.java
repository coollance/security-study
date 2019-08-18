package com.coolance.dto;

/**
 * @ClassName FileInfo
 * @Description 文件信息类
 * @Author Coolance
 * @Version
 * @Date 2019/8/18 7:33
 */
public class FileInfo {
    private String path;

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
