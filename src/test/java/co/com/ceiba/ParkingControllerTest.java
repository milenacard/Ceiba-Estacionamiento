package co.com.ceiba;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.service.ParkingService;
import co.com.ceiba.web.controller.ParkingController;

public class ParkingControllerTest {
	
	private ParkingController parkingController;
	private ParkingService parkingService;
	
	@Before
	public void init() {
		parkingService = Mockito.mock(ParkingService.class);
		parkingController = new ParkingController(parkingService);
	}
	
	@Test
	public void parkingControllerShouldCallService() {
		String userName = "nroales";
        String expectedMessage = "message";

        when(parkingService.welcome(userName)).thenReturn(expectedMessage);

        String message = parkingController.welcome(userName);

        verify(parkingService).welcome(userName);
        assertTrue(message.equals(expectedMessage));    
	}
	


}
