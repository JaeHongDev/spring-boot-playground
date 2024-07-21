package in.springbootplayground;

import org.apache.tomcat.util.threads.VirtualThreadExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync()
@SpringBootApplication
public class SpringBootPlaygroundApplication {

   public static void main(String[] args) {

        SpringApplication.run(SpringBootPlaygroundApplication.class, args);
    }

}
