import java.util.concurrent.atomic.AtomicInteger;

class Main {
  static int i = 0;
  static AtomicInteger ai;
  static int si = 0;

  public static void main(String[] args) {
    ai = new AtomicInteger(0);
    for (int k = 1; k <= 500; k++) {
      new MyThread().start();
    }

    try {
      Thread.sleep(3000);
    } catch (Exception e) {
      System.out.println("Error");
    }

    System.out.println("Value i: " + i);
    System.out.println("Value ai: " + ai);
    System.out.println("Value si: " + si);
  }

  public static synchronized void addNumber(int k) {
    si += k;
  }

  public static class MyThread extends Thread {
    public void run() {
      try {
        Thread.sleep(2);
      } catch (Exception e) {
        System.out.println("Error");
      }
      i++;
      ai.getAndAdd(1);
      addNumber(1);
    }
  }
}