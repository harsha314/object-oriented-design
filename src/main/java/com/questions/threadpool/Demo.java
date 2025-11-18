package com.questions.threadpool;

public class Demo {
  public static void main(String[] args) throws InterruptedException {
    ThreadPool pool = new ThreadPool(3, 10);

    for (int i = 1; i <= 5; ++i) {
      int taskNum = i;
      pool.submit(() -> {
        System.out.println("Executing task " + taskNum + " by " + Thread.currentThread().getName());
      });
    }

    pool.shutdown();
  }

}
