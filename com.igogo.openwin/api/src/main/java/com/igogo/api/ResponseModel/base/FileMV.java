package com.igogo.api.ResponseModel.base;

/**
 * Created by Lee on 2017/5/8.
 */
public class FileMV {

    private String absFilePath;
    private String relFilePath;

    public String getAbsFilePath() {
        return absFilePath;
    }

    public void setAbsFilePath(String absFilePath) {
        this.absFilePath = absFilePath;
    }

    public String getRelFilePath() {
        return relFilePath;
    }

    public void setRelFilePath(String relFilePath) {
        this.relFilePath = relFilePath;
    }
}
