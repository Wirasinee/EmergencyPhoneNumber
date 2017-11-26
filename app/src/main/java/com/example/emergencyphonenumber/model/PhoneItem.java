package com.example.emergencyphonenumber.model;

/**
 * Created by Wirasinee on 26-Nov-17.
 */
//[2]

public class PhoneItem {
    //กรณีclassไม่ได้มีการแก้ไขก็เป็นfinal แล้วเป็นpublic ไปเลย
    public final int id;
    public final String title;
    public final String number;
    public final String picture;

    //ALT+INS
    public PhoneItem(int id, String title, String number, String picture) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.picture = picture;
    }
    //ไปactivity_main MainAcitivity [3]

    @Override
    public String toString() {
        return title;
    }
}
