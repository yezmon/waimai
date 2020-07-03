package com.example.waimai2.BmobSql;

import cn.bmob.v3.BmobObject;

public class Menu extends BmobObject {
    private String Dno;
    private String Dname;
    private int Dprice;
    private int Dsale;
    private String Dremark;
    private String Bno;

    public String getBno(){
        return Bno;
    }
    public void setBno(){
        this.Bno=Bno;
    }
    public String getDname(){
        return Dname;
    }
    public void setDname(){
        this.Dname=Dname;
    } public String getDremark(){
        return Dremark;
    }
    public void setDremark(){
        this.Dremark=Dremark;
    } public String getDno(){
        return Dno;
    }
    public void setDno(){
        this.Dno=Dno;
    }
    public int getDprice(){
        return Dprice;
    }
    public void setDprice(){
        this.Dprice=Dprice;
    }
    public int getsale(){
        return  Dsale;
    }
    public void setDsale(){
        this.Dsale=Dsale;
    }
}
