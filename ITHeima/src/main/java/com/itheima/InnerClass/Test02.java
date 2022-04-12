package com.itheima.InnerClass;

public class Test02 {
    public static void main(String[] args) {
        //外部类名.内部类名 对象名 = new  外部类构造器().new 内部类构造器();
    People.Heart heart = new People().new Heart();
    heart.show();
    }

}

class People{
    private int heartbeat = 150;

    public class Heart{
        private int heartbeat = 110;
        public void show(){
            int heartbeat = 78;
            System.out.println(heartbeat);
            System.out.println(this.heartbeat);
            //成员内部类中访问所在外部类对象，格式为 外部类名.this
            System.out.println(People.this.heartbeat);
        }
    }
}
