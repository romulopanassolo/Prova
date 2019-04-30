package com.prova.main;

import java.util.concurrent.TimeUnit;

import com.prova.bean.ApplicationManager;

public class RunApplication {

	public static void main(String[] args) {

		Runnable runnable = () -> {
			try {
				while (true) {
					ApplicationManager application = new ApplicationManager();
					application.start();
					TimeUnit.SECONDS.sleep(10);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();

	}

}
