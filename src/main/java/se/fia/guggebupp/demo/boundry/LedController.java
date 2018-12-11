package se.fia.guggebupp.demo.boundry;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final LedHandler handler = new LedHandler();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {

	try{
		handler.ledControl();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

@RequestMapping("/set/{on}")
    public Greeting set(@PathVariable("on") String on, @RequestParam(value="name", defaultValue="World") String name) {

	try{
		if(on.equals("on")){
			handler.ledOn();
		} else {
			handler.ledOff();
		}} catch(Exception e) {
			e.printStackTrace();
		}
	
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }


@RequestMapping("/on")
    public Greeting on(@RequestParam(value="name", defaultValue="World") String name) {

	try{
		handler.ledOn();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

@RequestMapping("/off")
    public Greeting off(@RequestParam(value="name", defaultValue="World") String name) {

	try{
		handler.ledOff();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}