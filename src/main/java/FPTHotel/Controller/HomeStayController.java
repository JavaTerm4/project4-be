package FPTHotel.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import FPTHotel.Dto.BookingDTO;
import FPTHotel.Event.OnBookingSuccessEvent;
import FPTHotel.Model.*;
import FPTHotel.Services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import FPTHotel.Services.Ilsdtp;
import FPTHotel.Services.Ittp;
import org.springframework.web.context.request.WebRequest;

@Controller
@Transactional
public class HomeStayController {

	@Autowired
	Ilsdtp ilsdtp;
	
	@Autowired
	Ittp ittp;

	@Autowired
	BookingServices bookingServices;


	@GetMapping("/homestay")
	public String homestay(ModelMap model, @RequestParam("maPhong") Integer maPhong,
			@RequestParam("soPhong") Integer soPhong) {
		List<Checkin> danhsach = ilsdtp.listHomestayByMaPhong(maPhong);
		model.addAttribute("titlepage", "Homestay");
		model.addAttribute("danhsach", danhsach);
		model.addAttribute("maPhong", maPhong);
		model.addAttribute("soPhong", soPhong);
		return "homestay/homestay";
	}

	@RequestMapping("/staying")
	public String stayingPage(ModelMap model, @Param("soPhong") String soPhong, @ModelAttribute("collect") Collect collect){
//		List<Booking> list = bookingServices.findBookingBySoPhongAndTrangThai(Integer.valueOf(soPhong), 2);
		Booking booking = bookingServices.findTop1BySoPhongAndTrangThai(Integer.valueOf(soPhong), 2);
		model.addAttribute("soPhong", soPhong);
		model.addAttribute("booking", booking);
		model.addAttribute("titlepage", "Customer in Rooom "+soPhong);
		if(booking!=null){
			model.addAttribute("booking", booking);

			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(booking.getCheckinDuKien());
			c2.setTime(booking.getCheckoutDuKien());
			long noDay =  (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
			model.addAttribute("soNgay", noDay);
		}

		return "checkoutbk";
	}

	@RequestMapping("/dsdpt")
	public String dsdptPage(ModelMap model, @Param("soPhong") String soPhong){
		List<Booking> list = bookingServices.findBookingBySoPhongAndTrangThai(Integer.valueOf(soPhong), 1);
		model.addAttribute("soPhong", soPhong);
		model.addAttribute("danhsach", list);
		model.addAttribute("titlepage", "List Reservation Room "+soPhong);
		return "homestay/dsdpt";
	}

	@GetMapping("/addhomestay")
	public String addhomestay(ModelMap model, @RequestParam("maPhong") Integer maPhong,
			@RequestParam("soPhong") Integer soPhong, Checkin datphong) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		datphong = new Checkin();
		
		model.addAttribute("maPhong", maPhong);
		model.addAttribute("soPhong", soPhong);
		model.addAttribute("datphong", datphong);
		model.addAttribute("ngayhientai", dateFormat.format(cal.getTime()));
		model.addAttribute("giohientai", timeFormat.format(cal.getTime()));
		model.addAttribute("titlepage", "Add guest homestay");
		return "homestay/addhomestay";
	}

	/*
	@PostMapping("/actionaddhomestay")
	public String actionaddhomestay(ModelMap model, @RequestParam("maPhong") Integer maPhong,
			@RequestParam("soPhong") Integer soPhong,@ModelAttribute("datphong") Checkin datphong) {
		// lưu thông tin khách đã đặt
				ilsdtp.save(datphong);

		Room p = ittp.findById(datphong.getPhong().getMaPhong()).get();
		// set trạng thái bằng 2 để phân biệt đang thuê kiểu homestay
		p.setTrangThai(2);
		// đếm và update tổng số khách đã đặt
		Integer countHomestay = ittp.countHomestayByMaPhong(maPhong);
		p.setCountHomestay(countHomestay);
		ittp.save(p);
		model.addAttribute("message", "Create successfully");
		return homestay(model, maPhong, soPhong);
	}
	*/

	@ModelAttribute(name = "changeURL")
	public String changeURL() {
		return "homestay";
	}

	@ModelAttribute(name = "activedptp")
	public String activedptp() {
		return "active";
	}

	//Booking
	@RequestMapping(value = "/confirmcheckout", method = RequestMethod.POST)
	public String bookingRoom(@ModelAttribute("booking") Booking booking, Model model, WebRequest request,
							  @ModelAttribute("collect") Collect collect) throws ParseException {
		model.addAttribute("booking", booking);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(booking.getCheckinDuKien());
		c2.setTime(booking.getCheckoutDuKien());
		long noDay =  (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
		model.addAttribute("soNgay", noDay);
		return "checkoutbk";
	}

}
