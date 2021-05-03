package com.example.application.backend;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class BackendService {

  public void save(String name) {
    try {
      Thread.sleep(6000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Async
  public ListenableFuture<Void> saveAsync(String name) {
    try {
      // pretend to save
      Thread.sleep(6000);
    } catch (InterruptedException e) {
      return AsyncResult.forExecutionException(new RuntimeException("Error"));
    }

    return AsyncResult.forValue(null);
  }
}
