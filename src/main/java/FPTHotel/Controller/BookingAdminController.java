package FPTHotel.Controller;


import FPTHotel.Dto.BookingDTO;
import FPTHotel.Model.Booking;
import FPTHotel.Model.Checkin;
import FPTHotel.Model.Checkout;
import FPTHotel.Model.Room;
import FPTHotel.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@Transactional
public class BookingAdminController {
	@Autowired
	Ittp ittp;

	@Autowired
	BookingServices bookingServices;


	@RequestMapping(value = "/edbkad", method = RequestMethod.GET)
	public String editBookAdminPage(ModelMap model,@ModelAttribute("datphong") Checkin datphong, @ModelAttribute("datphong1") Checkin datphong1, @Param("maDatPhong") int maDatPhong) {
		Booking booking = bookingServices.findBookingByMaDatPhong(maDatPhong);
		if(booking.getTrangThai() == 1){
			if(bookingServices.existsCheckingByRoom(booking.getSoPhong())){
				model.addAttribute("messageError","Cannot change to checkin as having Guest is checking this room!");
				List<Booking> list = bookingServices.findBookingBySoPhongAndTrangThai(Integer.valueOf(booking.getSoPhong()), 1);
				model.addAttribute("soPhong", booking.getSoPhong());
				model.addAttribute("danhsach", list);
				model.addAttribute("titlepage", "List Reservation Room "+booking.getSoPhong());
				return "homestay/dsdpt";
			}

		}
		boolean conditionReadonly = false;
		String action= "confirmCheckin?currentTrangThai="+booking.getTrangThai();

		List<Integer> listRooms = ittp.getAllSoPhong();
		if(booking.getTrangThai() == 2){
			action = "confirmcheckout?currentTrangThai="+booking.getTrangThai();
			conditionReadonly = true;
		}
		model.addAttribute("booking", booking);
		model.addAttribute("titlepage", "Reservation room " +booking.getSoPhong());
		model.addAttribute("currentStatus", booking.getTrangThai());
		model.addAttribute("action",action);
		model.addAttribute("listRooms", listRooms);
		model.addAttribute("conditionReadonly", conditionReadonly);
		return "editbookadmin";
	}
	@RequestMapping(value = "/confirmCheckin", method = RequestMethod.POST)
	public String confirmCheckin(HttpServletRequest httpServletRequest, ModelMap model,@ModelAttribute("booking") Booking booking, @Param("currentTrangThai") int currentTrangThai) {
		HttpSession session = httpServletRequest.getSession();
		if(currentTrangThai != booking.getTrangThai() && booking.getTrangThai() == 2) {
			if(bookingServices.existsCheckingByRoom(booking.getSoPhong())){
				model.addAttribute("messageError","Cannot change to checkin as having Guest is checking this room!");
				List<Booking> list = bookingServices.findBookingBySoPhongAndTrangThai(Integer.valueOf(booking.getSoPhong()), 1);
				boolean conditionReadonly = false;
				booking.setTrangThai(1);
				String action= "confirmCheckin?currentTrangThai="+booking.getTrangThai();
				List<Integer> listRooms = ittp.getAllSoPhong();
				model.addAttribute("soPhong", booking.getSoPhong());
				model.addAttribute("titlepage", "Reservation Room "+booking.getSoPhong());
				model.addAttribute("booking", booking);
				model.addAttribute("currentStatus", booking.getTrangThai());
				model.addAttribute("action",action);
				model.addAttribute("listRooms", listRooms);
				model.addAttribute("conditionReadonly", conditionReadonly);
				return "editbookadmin";
			}
		}
		if(currentTrangThai != booking.getTrangThai()) {
			ittp.updatetrangThaiRoom(2,booking.getSoPhong());
		}
		booking.setUpdatedBy(session.getAttribute("nguoidung").toString());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		booking.setUpdatedDate(Timestamp.valueOf(now));
		bookingServices.save(booking);

		return "redirect:/dptp";
	}


	@RequestMapping(value = "/edbkad-1", method = RequestMethod.GET)
	public String editBookAdmin1Page(ModelMap model,@ModelAttribute("datphong") Checkin datphong, @ModelAttribute("datphong1") Checkin datphong1, @Param("maDatPhong") int maDatPhong) {
		Booking booking = bookingServices.findBookingByMaDatPhong(maDatPhong);
		boolean conditionReadonly = false;
		String action= "confirmCheckin?currentTrangThai="+booking.getTrangThai();

		List<Integer> listRooms = ittp.getAllSoPhong();
		if(booking.getTrangThai() == 2){
			action = "confirmcheckout?currentTrangThai="+booking.getTrangThai();
			conditionReadonly = true;
		}
		model.addAttribute("booking", booking);
		model.addAttribute("titlepage", "Reservation room " +booking.getSoPhong());
		model.addAttribute("currentStatus", booking.getTrangThai());
		model.addAttribute("action",action);
		model.addAttribute("listRooms", listRooms);
		model.addAttribute("conditionReadonly", conditionReadonly);
		return "editbookadmin";
	}

	}
