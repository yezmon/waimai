package com.example.waimai2.BmobSql;

import java.sql.Date;

import cn.bmob.v3.BmobObject;

public class Orders extends BmobObject {
    private String Dname,Oother,Bno,Cno,Caddress;
    private boolean Ostatus;
    private Date Otime;
    private int Odquan,Oalto;
    public String getBno(){
        return Bno;
    }
    public void setBno(String Bno){
        this.Bno=Bno;
    }
    public String getCno(){
        return Cno;
    }
    public void setCno(String Cno){
        this.Cno=Cno;
    }
    public String getDname(){
        return Dname;
    }
    public void setDname(String Dname){
        this.Dname=Dname;
    }
    public String getOother(){
        return Oother;
    }
    public void setOother(String Oother){
        this.Oother=Oother;
    }
    public String getCaddress(){
        return Caddress;
    }
    public void setCaddress(String Caddress){
        this.Caddress=Caddress;
    }
    public boolean isOstatus(){
        return Ostatus;
    }
    public void setOstatus(boolean Ostatus){
        this.Ostatus=Ostatus;
    }
    public Date getOtime(){
        return Otime;
    }
    public void setOtime(Date Otime) {this.Otime=Otime; }
    public int getOdquan(){
        return Odquan;
    }
    public void setOdquan(int Odquan){
        this.Odquan=Odquan;
    }
    public int getOalto(){
        return Oalto;
    }
    public void setOalto(int Oalto){
        this.Oalto=Oalto;
    }
}
