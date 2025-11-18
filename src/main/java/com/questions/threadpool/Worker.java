package com.questions.threadpool;

public class Worker extends Thread {
  private TaskQueue queue;
  private volatile boolean stopped = false;

  public Worker(TaskQueue taskQueue) {
    this.queue = taskQueue;
  }

  public void stopWorker() {
    stopped = false;
    interrupt();
  }

  @Override
  public void run() {
    while (!stopped) {
      try {
        Runnable task = queue.take();
        task.run();
      } catch (InterruptedException ie) {
        System.out.println("Task Interrupted");
      }
    }
  }
}
