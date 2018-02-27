package com.dream.util;

import java.util.concurrent.CountDownLatch;




public class Encoder_1 {
	private String path=null;  
	private final CountDownLatch sd_StartSinal = new CountDownLatch(1);
	private final CountDownLatch hd_StartSinal = new CountDownLatch(1);
	private final CountDownLatch ud_StartSinal = new CountDownLatch(1);
	private final CountDownLatch mDoneSinal = new CountDownLatch(3);
	
	public Encoder_1(String path) {
		this.path = path;
	}
	
	public void run(){
		Encode_sd encode_sd = new Encode_sd(sd_StartSinal,hd_StartSinal,mDoneSinal);
		Encode_hd encode_hd = new Encode_hd(hd_StartSinal,ud_StartSinal,mDoneSinal);
		Encode_ud encode_ud = new Encode_ud(ud_StartSinal,mDoneSinal);
		
		encode_sd.start();
		encode_hd.start();
		encode_ud.start();
		
		System.out.println("准备工作");
		System.out.println("工作开始");
		sd_StartSinal.countDown();

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
		private final CountDownLatch hd_StartSinal ;
		public Encode_sd(final CountDownLatch startSignal,final CountDownLatch hd_startSignal,final CountDownLatch doneSignal) {
			this.mStartSinal = startSignal;
			this.mDoneSinal=doneSignal;
			this.hd_StartSinal=hd_startSignal;
		}
		
		@Override
		public void run() {
			try {
				mStartSinal.await();
	            ConverVideoUtils cv = new ConverVideoUtils(path);  
	            String targetExtension = ".mp4";  
	            boolean isDelSourseFile = true;  
	            boolean beginConver = cv.beginConver(targetExtension,isDelSourseFile,Contants.type_sd_code);  
				System.out.println("sd");
				mDoneSinal.countDown();
				hd_StartSinal.countDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class Encode_hd extends Thread{
		private final CountDownLatch mStartSinal ;
		private final CountDownLatch mDoneSinal ;
		private final CountDownLatch ud_DoneSinal ;
		public Encode_hd(final CountDownLatch startSignal,final CountDownLatch ud_startSignal,final CountDownLatch doneSignal) {
			this.mStartSinal = startSignal;
			this.mDoneSinal=doneSignal;
			this.ud_DoneSinal=ud_startSignal;
		}

		@Override
		public void run() {
			try {
				mStartSinal.await();
	            ConverVideoUtils cv = new ConverVideoUtils(path);  
	            String targetExtension = ".mp4";  
	            boolean isDelSourseFile = true;  
	            boolean beginConver = cv.beginConver(targetExtension,isDelSourseFile,Contants.type_hd_code);  
				System.out.println("hd");
				mDoneSinal.countDown();
				ud_DoneSinal.countDown();
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
				System.out.println("ud");
				mDoneSinal.countDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}