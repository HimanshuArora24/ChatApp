package com.bmpl.chatapp.networking;

/*
 * Thread = Worker
 * Worker needs a Job
 * For Job we use Runnable
 * Once job is created via runnable then we write logic inside run()
 */

//public class ServerWorker implements Runnable {
// Alternative way to create thread
public class ThreadDemo extends Thread{

	@Override
	public void run() {
		// Job To Perform
		for(int i = 1; i <= 5; i++) {
			System.out.println("I is : " + i + " " + Thread.currentThread());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadDemo job = new ThreadDemo();
		job.start();
		
		// Assign the job to a thread/worker
//		Thread worker = new Thread(job);
//		worker.start();  // Internally it will call run()
		
		for(int i = 1; i <= 5; i++) {
			System.out.println("Main : " + i + " " + Thread.currentThread());
		}
	}

}
