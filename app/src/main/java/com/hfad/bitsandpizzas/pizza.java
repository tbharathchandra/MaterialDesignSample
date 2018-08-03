package com.hfad.bitsandpizzas;

public class pizza {
    private String name;
    private int imageResourceId;
    public static final pizza[] pizzas={
        new pizza("Diavolo",R.drawable.diavolo),
        new pizza("Funghi",R.drawable.funghi)
    };
    private pizza(String name,int imageResourceId){
        this.name=name;
        this.imageResourceId=imageResourceId;
    }
    public String getName(){
        return name;
    }
    public int getImageResourceId(){
        return imageResourceId;
    }
}
