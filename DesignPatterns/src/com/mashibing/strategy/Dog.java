package com.mashibing.strategy;

public class Dog implements Comparable<Dog>{

    int height;
    @Override
    public int compareTo(Dog d) {
        if (this.height <d.height) return -1;
        else if (this.height > d.height) return 1;
        else return 0;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "height=" + height +
                '}';
    }
}
