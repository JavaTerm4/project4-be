package FPTHotel.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import FPTHotel.Services.Ilsdtp;

@Controller
public class TestController {

	@Autowired
	Ilsdtp ilsdtp;
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		
		return "test";
	}
}
