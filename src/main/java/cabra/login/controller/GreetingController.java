package cabra.login.controller;

import java.util.Map;

import cabra.login.enity.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins="*")
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @CrossOrigin(origins="*")
    @RequestMapping("/test")
    public Greeting greeting(@RequestBody Map<String,String> map) {
        String testvalue=map.get("test");
        return new Greeting(counter.incrementAndGet(),
                String.format(template, testvalue));
    }

}