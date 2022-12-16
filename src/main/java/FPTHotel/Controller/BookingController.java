package FPTHotel.Controller;


import FPTHotel.Dto.BookingDTO;
import FPTHotel.Model.Booking;
import FPTHotel.Services.BookingServices;
import FPTHotel.Services.DangNhapService;
import FPTHotel.Services.DsqldvService;
import FPTHotel.Services.LichSuDangNhapService;
import FPTHotel.Model.Room;
import FPTHotel.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.repository.query.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@Transactional
public class BookingController {
	@Autowired
	BookingServices bookingServices;
	@Autowired
	private QuanLyPhongService quanLyPhongService;
	@Autowired
	private IttkhService ittkhService;
	@Autowired
	private ITraPhong iTraPhong;
	@Autowired
	private PaypalServices paypalServices;
	@Autowired
	private Ittp ittp;

	@GetMapping("/book-history")
	public String bookHistoryPage(HttpServletRequest httpServletRequest, ModelMap model){
		HttpSession session = httpServletRequest.getSession();
		String user = session.getAttribute("nguoidung").toString();
		List<Booking> l = bookingServices.findByCreatedBy(user);

		model.addAttribute("listBook", l);
		return "book-history";
	}

	@RequestMapping(value = "/bookingroom", method = RequestMethod.GET)
	public String bookingroom(@Param("roomNumber") Integer roomNumber, Model model,
							  @Param("checkinBooked") String checkinBooked,
							  @Param("checkoutBooked") String checkoutBooked, HttpServletRequest httpServletRequest
							  ) {
		Booking booking = new Booking();
		List<Booking> listBookingBambuu = new ArrayList<>();
		List<Map> listBooked = new ArrayList<>();
		Map<String, String> mapBooked;
		Room phong = ittp.findBySoPhong(roomNumber);

		if (roomNumber != null) {
			phong = quanLyPhongService.getBySoPhong(roomNumber);

			booking.setSoPhong(roomNumber);
			model.addAttribute("show", true);
			model.addAttribute("roomtype", phong.getLoaiPhong().getTenLoaiPhong());
			model.addAttribute("roomPrice", phong.getGiaPhong());
		}else{
			return "redirect:/listroom";
		}
		if(checkinBooked != null && checkoutBooked != null){
			listBookingBambuu = bookingServices.getAvailableForRoom(roomNumber, java.sql.Date.valueOf(checkinBooked), java.sql.Date.valueOf(checkoutBooked));
			model.addAttribute("checkBooked", "Y");
			if(!listBookingBambuu.isEmpty()){

				for (Booking b: listBookingBambuu) {
					mapBooked = new HashMap<>();
					mapBooked.put("checkin", DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH).format(b.getCheckinDuKien().toLocalDate()));
					mapBooked.put("checkout", DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH).format(b.getCheckoutDuKien().toLocalDate()));
					listBooked.add(mapBooked);
				}
			}else{
				model.addAttribute("messageBooked", "None booked in this period. You can book ^^ ");
			}
		}
		model.addAttribute("roomCode", phong.getMaPhong());
		model.addAttribute("roomNumber", phong.getSoPhong());
		model.addAttribute("roomPrice", phong.getGiaPhong());
		model.addAttribute("listBooked", listBooked);
		model.addAttribute("checkinBooked",checkinBooked);
		model.addAttribute("checkoutBooked",checkoutBooked);
		model.addAttribute("booking", booking);
		return "bookingroom";
	}

	@RequestMapping(value = "/bookingroom", method = RequestMethod.POST)
	public String bookingroomPost(@ModelAttribute("Booking") Booking booking, Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("roomNumber", booking.getSoPhong());
		Room phong = ittp.findBySoPhong(booking.getSoPhong());
		model.addAttribute("show", true);
		model.addAttribute("roomtype", phong.getLoaiPhong().getTenLoaiPhong());
		model.addAttribute("roomCode", phong.getMaPhong());
		model.addAttribute("roomPrice", phong.getGiaPhong());
		model.addAttribute("booking", booking);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(booking.getCheckinDuKien());
		c2.setTime(booking.getCheckoutDuKien());
		long noDay =  (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);

		if (booking.getCheckinDuKien().compareTo(new Date()) < 0) {
			model.addAttribute("error", "Check-in date must greater than or equal today");
			return "bookingroom";
		}
		if (booking.getCheckinDuKien().compareTo(booking.getCheckoutDuKien()) > 0) {
			model.addAttribute("error", "Check-in date can't greater than check-out date");
			return "bookingroom";
		}
		if(noDay > 7){
			model.addAttribute("error", "Cannot book more than 7 days");
			return "bookingroom";
		}
		if(bookingServices.existsBookingByCheckinout(booking.getSoPhong() ,booking.getCheckinDuKien(), booking.getCheckoutDuKien())){
			model.addAttribute("error", "This time have already booked by another! Please Choose other Checkin Checkout ^^ ");
			return "bookingroom";
		}
		HttpSession session = httpServletRequest.getSession();
		LocalDateTime now = LocalDateTime.now();
		booking.setCreatedDate(Timestamp.valueOf(now));
		booking.setUpdatedDate(Timestamp.valueOf(now));

		Double totalRentedRoom = booking.getRoomPrice() * noDay;
		booking.setTienCoc(totalRentedRoom/10);
		booking.setTienThuePhong(totalRentedRoom);
		booking.setTienDichVu(Double.valueOf(0));
		booking.setTrangThai(1);
		booking.setTongTien(booking.getTienThuePhong() + booking.getTienDichVu());
		session.setAttribute("booking",booking);
		return "invoice";
	}

	@GetMapping("/usdtbkin")
	public String usdtbkinPshr(ModelMap model){
		return "usdtbkin";
	}

}
