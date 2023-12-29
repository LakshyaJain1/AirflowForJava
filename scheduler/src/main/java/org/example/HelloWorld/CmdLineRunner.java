package org.example.HelloWorld;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Author - lakshya.jain <br>
 * Date - 25/09/2023
 */

@Component
@Log4j2
@AllArgsConstructor
public class CmdLineRunner implements CommandLineRunner {

    private TestService testService;
    private ApiCaller apiCaller;

    public void getMessage() {
        log.info("Cron running");
        testService.print();
        apiCaller.makeApiCall();

    }

    @Override
    public void run(String... args) {
        log.info("Hi From Command Line Runner with args:" + String.join(", ", args));
        if (args != null && args.length > 0) {
            log.info(args[0]);
            if (("1").equals(args[0])) {
                getMessage();
            }
        }
    }
}
