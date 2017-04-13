package com.example.android.dictionary;

/**
 * Created by SHREYA on 3/28/2017.
 */
public class Word {

    int _id;
    String word;
    String mean;
    public Word(){}
    public Word(String word,String mean){
        this.word=word;
        this.mean=mean;
    }
    public Word(int id,String word,String mean){
        this._id=id;
        this.word=word;
        this.mean=mean;
    }

    public int getId(){
        return _id;
    }

    public String getWord(){
        return word;

    }
    public String getMean(){
        return mean;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
}
