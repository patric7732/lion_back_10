package com.example.day05;

public class Dice {
//속성 - 주사위의 면을 나타내는 face  - 던졌을때 나오는 눈을 나타내는  eye
    public int face = 6;
    public int eye;

    //행위 - 주사위를 굴리다.  roll
    public void roll(){
        //주사위를 굴렸을 때 어떤 일을 해야할지??
        eye = (int)(Math.random()*face) + 1;
    }
}
