package co.com.ceiba.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.service.ParkingService;

@RestController
public class ParkingController {
	
	@Autowired
	private ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }
    
    @RequestMapping(value = "/welcome/{userName}", method = RequestMethod.GET)
    public String welcome(
            @PathVariable("userName") String userName
    ) 
    {
        return parkingService.welcome(userName);
    }

}
