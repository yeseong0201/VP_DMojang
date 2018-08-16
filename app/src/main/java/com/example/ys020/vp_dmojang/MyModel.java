package com.example.ys020.vp_dmojang;

public class MyModel {
    private String title;
    private  String content;

    public MyModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

}
