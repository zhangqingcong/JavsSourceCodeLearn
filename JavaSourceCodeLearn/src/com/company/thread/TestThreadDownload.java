package com.company.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
//联系Thread，实现多线程同步下载图片
public class TestThreadDownload extends Thread{
    private String url;
    private String name;

    public TestThreadDownload(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println(name+"下载成功");
    }

    public static void main(String[] args) {
        TestThreadDownload testThreadDownload01 = new TestThreadDownload("https://www.ywcy.net/uploads/allimg/200509/1-200509214915.jpg","1狸花.jpeg");
        TestThreadDownload testThreadDownload02 = new TestThreadDownload("https://p8.itc.cn/images01/20211110/c915257902464282b685c508eda39c9f.jpeg","2美短.jpg");
        TestThreadDownload testThreadDownload03 = new TestThreadDownload("https://www.chagougou.com/uploads/allimg/200603/6-200603102514509.jpg","3k.jgp");
        testThreadDownload01.start();
        testThreadDownload02.start();
        testThreadDownload03.start();
    }
}

class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
