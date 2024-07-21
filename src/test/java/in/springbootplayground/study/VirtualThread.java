package in.springbootplayground.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.jupiter.api.Test;

public class VirtualThread {

    @Test
    void 가상스레드_생성_테스트(){

        Thread.startVirtualThread(() -> {
            System.out.println(Thread.currentThread().getName() + " start virtual thread");
        });

        Thread.ofVirtual().start(() -> {
            System.out.println(Thread.currentThread().getName() + " start virtual Thread1");
        }).run();

        new Thread(() -> {
            System.out.println( Thread.currentThread().getName() + " start Thread");
        }).run();

        try(final var executor = Executors.newVirtualThreadPerTaskExecutor()){
            executor.submit(() -> {
                System.out.println( Thread.currentThread().getName() + "virtual start Thread");
            });
        }
    }
}
