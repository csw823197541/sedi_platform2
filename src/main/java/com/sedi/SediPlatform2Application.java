package com.sedi;

import com.sedi.process.MSThreadPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SediPlatform2Application {

	public static void main(String[] args) {
		SpringApplication.run(SediPlatform2Application.class, args);

//		MSThreadPool.scheduledExecutor.scheduleAtFixedRate(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("开始执行定时任务。。。");
//				try {
//					Thread.currentThread().sleep(10000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println("定时任务执行结束！");
//			}
//		}, 1, 5, TimeUnit.MINUTES);
	}
}
