package com.questions.threadpool;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
  List<Worker> workers = new ArrayList<>();
  TaskQueue queue;

  public ThreadPool(int workerCount, int queueCapacity) {
    this.queue = new TaskQueue(queueCapacity);
    for (int i = 0; i < workerCount; ++i) {
      Worker worker = new Worker(queue);
      this.workers.add(worker);
      worker.start();
    }
  }

  public void submit(Runnable task) throws InterruptedException {
    queue.put(task);
  }

  public void shutdown() {
    for (Worker worker : workers) {
      worker.stopWorker();
    }
  }
}
