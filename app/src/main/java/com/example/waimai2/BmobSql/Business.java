package com.example.waimai2.BmobSql;

import cn.bmob.v3.BmobObject;

public class Business extends BmobObject {
    private String Bno;
    private String Bname;
    private String Baddress;
    private String Btel;
    private String Bremark;

    public String getBno(){
        return Bno;
    }
    public void setBno(String Bno){
        this.Bno=Bno;
    }
    public String getBname(){
        return Bname;
    }
    public void setBname(String Bname){
        this.Bname=Bname;
    } public String getBaddress(){
        return Baddress;
    }
    public void setBaddress(String Baddress){
        this.Baddress=Baddress;
    } public String getBtel(){
        return Btel;
    }
    public void setBtel(String Btel ){
        this.Btel=Btel;
    } public String getBremark(){
        return Bremark;
    }
    public void setBremark(String Bremark){
        this.Bremark=Bremark;
    }
}
