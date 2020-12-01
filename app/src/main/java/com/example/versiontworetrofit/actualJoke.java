package com.example.versiontworetrofit;

public class actualJoke {

    private String icon_url;
    private String id;
    private String url;
    private String value;

    public actualJoke(String icon_url, String id, String url, String value){
        this.icon_url = icon_url;
        this.id = id;
        this.url = url;
        this.value = value;
    }
    public void setIcon_url(String string){
        this.icon_url = string;
    }
    public String getIcon_url(){
        return this.icon_url;
    }

    public void setId(String string){
        this.id = string;
    }
    public String getId(){
        return this.id;
    }
    public void setUrl(String string){
        this.url = string;
    }
    public String getUrl(){
        return this.url;
    }
    public void setValue(String string){
        this.value = string;
    }
    public String getValue(){
        return this.value;
    }



}



