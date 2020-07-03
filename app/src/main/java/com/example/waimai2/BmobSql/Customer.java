package com.example.waimai2.BmobSql;

import cn.bmob.v3.BmobObject;

public class Customer extends BmobObject {
    private String Cno;
    private String Cid;
    private String Cpwd;
    private String Cname;
    private int Cage,Cbalance;
    private String Caddress,Ctel;

    public String getCaddress(){
        return Caddress;
    }
    public void setCaddress(String Caddress){
        this.Caddress=Caddress;
    }
    public int getCbalance(){
        return Cbalance;
    }
    public void setCbalance(int Cbalance){
        this.Cbalance=Cbalance;
    } public String getCno(){
        return Cno;
    }
    public void setCno(String Cno){
        this.Cno=Cno;
    } public String getCtel(){
        return Ctel;
    }
    public void setCtel(String Ctel ){
        this.Ctel=Ctel;
    } public String getCpwd(){
        return Cpwd;
    }
    public void setCname(String Cname){
        this.Cname=Cname;
    } public String getCname(){
        return Cname;
    }
    public void setCpwd(String Cpwd){
        this.Cpwd=Cpwd;
    } public String getCid(){
        return Cid;
    }
    public void setCid(String Cid){
        this.Cid=Cid;
    } public int getCage(){
        return Cage;
    }
    public void setCage(int Cage){
        this.Cage=Cage;
    }
}
