package com.example.fragment.model;

public class Bird {
    //鸟类名字
    private String birdName;
    //鸟类栖息地
    private String birdHabitat;
    //鸟类生活习惯
    private String birdLifestyle;
    //鸟类居留类型
    private String birdResidence;
    //鸟类详细信息
    private String birdDetails;
    //链接
    private String birdUrl;
    //存放鸟类图片链接
    private String birdImg;

    public Bird(String birdName,String habitat,String lifestyle,String residence,String details,String birdUrl,String birdImg){
        this.birdName=birdName;
        this.birdHabitat=habitat;
        this.birdLifestyle=lifestyle;
        this.birdResidence=residence;
        this.birdDetails=details;
        this.birdUrl=birdUrl;
        this.birdImg=birdImg;
    }

    /*
    鸟类信息接口
     */

    public String getBirdName(){
        return birdName;
    }

    public String getBirdHabitat(){
        return birdHabitat;
    }

    public String getBirdLifestyle(){
        return birdLifestyle;
    }

    public String getBirdResidence(){
        return birdResidence;
    }

    public String getBirdDetails(){
        return birdDetails;
    }

    public String getBirdUrl(){
        return birdUrl;
    }

    public String getBirdImg(){
        return birdImg;
    }


    /*
    修改鸟类信息
     */
    public void setBirdHabitat(String birdHabitat) {
        this.birdHabitat = birdHabitat;
    }

    public void setBirdLifestyle(String birdLifestyle) {
        this.birdLifestyle = birdLifestyle;
    }

    public void setBirdResidence(String birdResidence) {
        this.birdResidence = birdResidence;
    }

    public void setBirdDetails(String birdDetails) {
        this.birdDetails = birdDetails;
    }

    public void setBirdName(String birdName) {
        this.birdName = birdName;
    }

    public void setBirdUrl(String birdUrl) {
        this.birdUrl = birdUrl;
    }

    public void setBirdImg(String birdImg) {
        this.birdImg = birdImg;
    }
}
