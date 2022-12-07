package FPTHotel.Controller;


import FPTHotel.Model.Booking;
import FPTHotel.Services.BookingServices;
import FPTHotel.Services.DangNhapService;
import FPTHotel.Services.DsqldvService;
import FPTHotel.Services.LichSuDangNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
public class BookingController {
	@Autowired
	BookingServices bookingServices;

	@GetMapping("/book-history")
	public String bookHistoryPage(HttpServletRequest httpServletRequest, ModelMap model){
		HttpSession session = httpServletRequest.getSession();
		String user = session.getAttribute("nguoidung").toString();
		List<Booking> l = bookingServices.findByCreatedBy(user);

		model.addAttribute("listBook", l);
		return "book-history";
	}


}
