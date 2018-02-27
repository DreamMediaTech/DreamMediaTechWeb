package com.dream.util;

import java.util.concurrent.CountDownLatch;


public class Encoder {
	private String path="C:\\Users\\wx_shadow\\Desktop\\streams\\kbd.mp4";  
	private final CountDownLatch mStartSinal = new CountDownLatch(1);
	private final CountDownLatch mDoneSinal = new CountDownLatch(3);
	
	public Encoder(String path) {
		this.path = path;
	}
	
	public void run(){
		Encode_sd encode_sd = new Encode_sd(mStartSinal,mDoneSinal);
		Encode_hd encode_hd = new Encode_hd(mStartSinal,mDoneSinal);
		Encode_ud encode_ud = new Encode_ud(mStartSinal,mDoneSinal);
		
		encode_sd.start();
		encode_hd.start();
		encode_ud.start();
		
		System.out.println("准备工作");
		mStartSinal.countDown();
		System.out.println("工作开始");
		try {
			mDoneSinal.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("工作结束");
		
	}
	

	
	
	class Encode_sd extends Thread{
		private final CountDownLatch mStartSinal ;
		private final CountDownLatch mDoneSinal ;
		public Encode_sd(final CountDownLatch startSignal,final CountDownLatch doneSignal) {
			this.mStartSinal = startSignal;
			this.mDoneSinal=doneSignal;
		}
		
		@Override
		public void run() {
			try {
				mStartSinal.await();
	            ConverVideoUtils cv = new ConverVideoUtils(path);  
	            String targetExtension = ".mp4";  
	            boolean isDelSourseFile = true;  
	            boolean beginConver = cv.beginConver(targetExtension,isDelSourseFile,Contants.type_sd_code);  
				mDoneSinal.countDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class Encode_hd extends Thread{
		private final CountDownLatch mStartSinal ;
		private final CountDownLatch mDoneSinal ;
		public Encode_hd(final CountDownLatch startSignal,final CountDownLatch doneSignal) {
			this.mStartSinal = startSignal;
			this.mDoneSinal=doneSignal;
		}

		@Override
		public void run() {
			try {
				mStartSinal.await();
	            ConverVideoUtils cv = new ConverVideoUtils(path);  
	            String targetExtension = ".mp4";  
	            boolean isDelSourseFile = true;  
	            boolean beginConver = cv.beginConver(targetExtension,isDelSourseFile,Contants.type_hd_code);  
				mDoneSinal.countDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class Encode_ud extends Thread{
		private final CountDownLatch mStartSinal ;
		private final CountDownLatch mDoneSinal ;
		public Encode_ud(final CountDownLatch startSignal,final CountDownLatch doneSignal) {
			this.mStartSinal = startSignal;
			this.mDoneSinal=doneSignal;
		}

		@Override
		public void run() {
			try {
				mStartSinal.await();
	            ConverVideoUtils cv = new ConverVideoUtils(path);  
	            String targetExtension = ".mp4";  
	            boolean isDelSourseFile = true;  
	            boolean beginConver = cv.beginConver(targetExtension,isDelSourseFile,Contants.type_ud_code);  
				mDoneSinal.countDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
