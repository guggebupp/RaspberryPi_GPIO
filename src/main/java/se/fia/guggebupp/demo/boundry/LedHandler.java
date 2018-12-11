package se.fia.guggebupp.demo.boundry;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


public class LedHandler {
final GpioController gpio = GpioFactory.getInstance();
private GpioPinDigitalOutput pin;


public void ledControl()  throws InterruptedException{
	
        
        // creating the pin with parameter PinState.HIGH
        // will instantly power up the pin        
	if(pin == null) {
		pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "PinLED", PinState.HIGH);
	        System.out.println("light is: ON");
	        // wait 2 seconds
	        Thread.sleep(2000);
	}

        
        
        // turn off GPIO 1
        pin.low();
        System.out.println("light is: OFF");

        // wait 1 second
        Thread.sleep(1000);

        // turn on GPIO 1 for 1 second and then off
        System.out.println("light is: ON for 1 second");
        pin.pulse(1000, true);
        
        // release the GPIO controller resources
        gpio.shutdown();
}

public void ledOn()  throws InterruptedException{
	if(pin == null) {
		pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "PinLED", PinState.HIGH);
	}else {
		pin.high();
	}
        System.out.println("light is: ON");
}

public void ledOff()  throws InterruptedException{
	if(pin == null) {
		pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "PinLED", PinState.LOW);
	}else {
		pin.low();
	}
        System.out.println("light is: OFF");
}


}