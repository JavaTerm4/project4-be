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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.data.repository.query.Param;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
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

	@GetMapping("/book-history")
	public String bookHistoryPage(HttpServletRequest httpServletRequest, ModelMap model){
		HttpSession session = httpServletRequest.getSession();
		String user = session.getAttribute("nguoidung").toString();
		List<Booking> l = bookingServices.findByCreatedBy(user);

		model.addAttribute("listBook", l);
		return "book-history";
	}

	@RequestMapping(value = "/bookingroom", method = RequestMethod.GET)
	public String bookingroom(@Param("roomNumber") Integer roomNumber, Model model, @Param("checkinBooked") String checkinBooked, @Param("checkoutBooked") String checkoutBooked) {
		BookingDTO bookingDTO = new BookingDTO();
		List<Booking> listBookingBambuu = new ArrayList<>();
		List<Map> listBooked = new ArrayList<>();
		Map<String, String> mapBooked;
		Room phong = new Room();
		if (roomNumber != null) {
			phong = quanLyPhongService.getBySoPhong(roomNumber);

			bookingDTO.setRoomCode(roomNumber);
			bookingDTO.setRoomType(phong.getLoaiPhong().getTenLoaiPhong());
			model.addAttribute("show", true);
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

		model.addAttribute("bookingDTO", bookingDTO);
		return "bookingroom";
	}
}
