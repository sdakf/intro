package simpleapp;

import java.util.Date;

public class Cat {

    private String imie;
    private Date dob;
    private Float waga;
    private String imieOpiekuna;

    public String przedstawSie(){
        return "hej, jestem "+imie+", ważę "+waga+", urodziłem sie "+dob+", opiekuje się mną "+imieOpiekuna;
    }
    public String getImie(){
        return imie;
    }
    public void setImie(String imie){
        this.imie = imie;
    }
    public Date getDob(){
        return dob;
    }
    public void setDob(Date dob){
        this.dob = dob;
    }
    public Float getWaga(){
        return waga;
    }
    public void setWaga(Float waga){
        this.waga = waga;
    }
    public String getImieOpiekuna(){
        return imieOpiekuna;
    }
    public void setImieOpiekuna(String imieOpiekuna){
        this.imieOpiekuna = imieOpiekuna;
    }
}