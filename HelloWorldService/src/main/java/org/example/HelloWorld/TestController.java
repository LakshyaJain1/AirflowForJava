package org.example.HelloWorld;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {

    private TestService testService;
    private ApiCaller apiCaller;

    @GetMapping("/temp")
    public String temp(){
        testService.print();
        apiCaller.makeApiCall();
        return "Print";
    }

}
