package FPTHotel.Controller;


import FPTHotel.Model.Booking;
import FPTHotel.Model.Collect;
import FPTHotel.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@Transactional
public class MoneyCollectController {
	@Autowired
	BookingServices bookingServices;
	@Autowired
	MoneyCollectionServices moneyCollectionServices;
	@Autowired
	Ittp ittp;

	@RequestMapping(value = "/checkout-room", method = RequestMethod.POST)
	public String bookingroom(@ModelAttribute("collect") Collect collect, Model model, @Param("soPhong") int soPhong) {
		collect.setNoiDungChi("Pay for booking ID "+collect.getBookingId());
		collect.setLoaiThuChi(2);
		ittp.updatetrangThaiRoom(0,soPhong);
		moneyCollectionServices.save(collect);
		bookingServices.updateBooking(3,collect.getBookingId());
		model.addAttribute("message", "Checkout boooking id #"+collect.getBookingId()+" successfull");
		return "lsdtp";
	}
	@RequestMapping(value = "/recpay", method = RequestMethod.GET)
	public String recpayPage(Model model) {
		List<Collect> listCollect = moneyCollectionServices.findOrderById();
		model.addAttribute("listCollect", listCollect);
		return "recpay";
	}

}
