package com.example.waimai2;

public class Tool {
    private String[] str;
    private int[] in;
    public void setString(String s,int i){
        this.str[i]=s;
    }
    public String getString(int i){
        return str[i];
    }
    public void setInt(int n,int i){this.in[n]=i;}
    public int getInt(int n){return in[n];}
}
