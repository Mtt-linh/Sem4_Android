package com.example.assweatherapi.model;

public class Weather {
    private  String Date;
    private int Icon;
    private  String IconTem;
    private TemItem TemItem;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public String getIconTem() {
        return IconTem;
    }

    public void setIconTem(String iconTem) {
        IconTem = iconTem;
    }

    public com.example.assweatherapi.model.TemItem getTemItem() {
        return TemItem;
    }

    public void setTemItem(com.example.assweatherapi.model.TemItem temItem) {
        TemItem = temItem;
    }
}
