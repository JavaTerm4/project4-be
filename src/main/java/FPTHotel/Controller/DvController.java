package FPTHotel.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import FPTHotel.Model.*;
import FPTHotel.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DvController {

	@Autowired
	Idv idv;
	
	@Autowired
	Ilsdtp ilsdtp;
	
	@Autowired
	QuanLyPhongService quanlyphongservice;

	@Autowired
	DsqldvService dsqldvService;

	@Autowired
	BookingServices bookingServices;

	@ModelAttribute(name = "changeURL")
	public String changeURL() {
		return "pddv";
	}

	@GetMapping("/homestaydv")
	public String homestaydv(ModelMap model, @RequestParam("maPhong") Integer maPhong,
			@RequestParam("soPhong") Integer soPhong) {
		List<Checkin> danhsach = ilsdtp.listHomestayByMaPhong(maPhong);
		model.addAttribute("titlepage", "Call for service");
		model.addAttribute("danhsach", danhsach);
		model.addAttribute("maPhong", maPhong);
		model.addAttribute("soPhong", soPhong);
		return "dichvu/listhomestaydv";
	}

	@RequestMapping("/pddv")
	public String pddv(ModelMap model) {
		activemenu(model);
		List<Booking> listBooking = bookingServices.findRoomForService();

		if (listBooking.isEmpty()) {
			model.addAttribute("message", "All rooms are empty");
			return "pddv";
		}

		List<ListRoomCheckin> listRoomCheckin = listBooking.stream().map(b ->{
				ListRoomCheckin listRoomCheckin1 = new ListRoomCheckin();
				listRoomCheckin1.setMaDatPhong(b.getMaDatPhong());
				listRoomCheckin1.setSoPhong(b.getSoPhong());
				listRoomCheckin1.setTang(b.getRoom().getTang());
				listRoomCheckin1.setKhuyenMai(b.getRoom().getKhuyenMai());
				listRoomCheckin1.setTenLoaiPhong(b.getRoom().getLoaiPhong().getTenLoaiPhong());
				return listRoomCheckin1;
			}).collect(Collectors.toList());
		List<Integer> listTang = listRoomCheckin.stream().map(ListRoomCheckin::getTang).distinct().collect(Collectors.toList());
		listTang.sort(Integer::compareTo);
		model.addAttribute("listRoomCheckin", listRoomCheckin);
		model.addAttribute("listTang", listTang);
		model.addAttribute("titlepage", "Select a reservation service");

		return "pddv";
	}

	Integer chuyenhuongtrang = 3;
	Integer madatphong = null;
	Integer sophongtemp = null;

	@RequestMapping("/dv")
	public String dv(ModelMap model, @RequestParam("madatphong") int madatphong, @RequestParam("sophong") int sophong) {
		activemenu(model);
		chuyenhuongtrang = 3;
		this.madatphong = madatphong;
		sophongtemp = sophong;
		getlistdsdadat(model);
		model.addAttribute("width", "100%");
		model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
		return "dv";
	}

	@RequestMapping(value = "/actionloaidichvu", params = "anuong")
	public String anuong(ModelMap model, @ModelAttribute("donDichVu") ServiceMenu donDichVu) {
		activemenu(model);
		chuyenhuongtrang = 0;
		model.addAttribute("madatphong", madatphong);
		model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
		getlistdsdadat(model);
		return "dv.jsp?view=dichvu/anuong";
	}

	@RequestMapping(value = "/actionloaidichvu", params = "giatui")
	public String giatui(ModelMap model, @ModelAttribute("donDichVu") ServiceMenu donDichVu) {
		activemenu(model);
		chuyenhuongtrang = 1;
		model.addAttribute("madatphong", madatphong);
		model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
		getlistdsdadat(model);
		return "dv.jsp?view=dichvu/giatui";
	}

	@RequestMapping(value = "/actionloaidichvu", params = "thugian")
	public String thugian(ModelMap model, @ModelAttribute("donDichVu") ServiceMenu donDichVu) {
		activemenu(model);
		chuyenhuongtrang = 2;
		model.addAttribute("maDatPhong", madatphong);
		model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
		getlistdsdadat(model);
		return "dv.jsp?view=dichvu/thugian";
	}

	@RequestMapping(value = "/actionloaidichvu", params = "khac")
	public String dichVuKhac(ModelMap model) {
		activemenu(model);
		chuyenhuongtrang = 4;
		model.addAttribute("madatphong", madatphong);
		model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
		getlistdsdadat(model);
		return "dv.jsp?view=dichvu/dichvukhac";
	}

	@RequestMapping("/actionanuong")
	public String actionanuong(ModelMap model, @ModelAttribute("donDichVu") ServiceMenu donDichVu,
			HttpServletRequest httpServletRequest) {
		activemenu(model);
		Date date = new Date();
		model.addAttribute("madatphong", madatphong);
		if (donDichVu.getSoLuong() == 0) {
			model.addAttribute("message", "Invalid quantity");
			getlistdsdadat(model);
			model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
			return "dv.jsp?view=dichvu/anuong";
		} else {
			HttpSession session = httpServletRequest.getSession();
			String nguoiDung = session.getAttribute("nguoidung").toString();
			donDichVu.setTenDangNhap(nguoiDung);
			donDichVu.setNgayDat(date);
			donDichVu.setGioDat(date);
			int maDv = donDichVu.getDichVu().getMaDichVu();
			Service dichVu = dsqldvService.findByMaDichVu(maDv);
			donDichVu.setDonGia(dichVu.getGiaDichVu());
			donDichVu.setTotal(dichVu.getGiaDichVu() * donDichVu.getSoLuong());
			donDichVu.setTrangThai(1);
			idv.save(donDichVu);
			model.addAttribute("message", "Create successfully");
			model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
			getlistdsdadat(model);
			model.addAttribute("donDichVu", new ServiceMenu());
			return "dv.jsp?view=dichvu/anuong";
		}
	}

	@RequestMapping("/actiongiatui")
	public String actiongiatui(ModelMap model, @ModelAttribute("donDichVu") ServiceMenu donDichVu,
			HttpServletRequest httpServletRequest) {
		activemenu(model);
		model.addAttribute("madatphong", madatphong);
		Date date = new Date();
		if (donDichVu.getSoLuong() == 0) {
			model.addAttribute("message", "Invalid quantity");
			getlistdsdadat(model);
			model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
			return "dv.jsp?view=dichvu/giatui";
		} else {
			HttpSession session = httpServletRequest.getSession();
			String nguoiDung = session.getAttribute("nguoidung").toString();
			donDichVu.setTenDangNhap(nguoiDung);
			donDichVu.setNgayDat(date);
			donDichVu.setGioDat(date);
			int maDv = donDichVu.getDichVu().getMaDichVu();
			Service dichVu = dsqldvService.findByMaDichVu(maDv);
			donDichVu.setDonGia(dichVu.getGiaDichVu());
			donDichVu.setTotal(dichVu.getGiaDichVu() * donDichVu.getSoLuong());
			donDichVu.setTrangThai(1);
			idv.save(donDichVu);
			model.addAttribute("message", "Create successfully");
			model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
			getlistdsdadat(model);
			model.addAttribute("donDichVu", new ServiceMenu());
			return "dv.jsp?view=dichvu/giatui";
		}
	}

	@RequestMapping("/actionthugian")
	public String actionthugian(ModelMap model, @ModelAttribute("donDichVu") ServiceMenu donDichVu,
			HttpServletRequest httpServletRequest) {
		activemenu(model);
		model.addAttribute("madatphong", madatphong);
		Date date = new Date();
		if (donDichVu.getSoLuong() == 0) {
			model.addAttribute("message", "Invalid quantity");
			model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
			getlistdsdadat(model);
			return "dv.jsp?view=dichvu/thugian";
		} else {
			HttpSession session = httpServletRequest.getSession();
			String nguoiDung = session.getAttribute("nguoidung").toString();
			donDichVu.setTenDangNhap(nguoiDung);
			donDichVu.setNgayDat(date);
			donDichVu.setGioDat(date);
			int maDv = donDichVu.getDichVu().getMaDichVu();
			Service dichVu = dsqldvService.findByMaDichVu(maDv);
			donDichVu.setDonGia(dichVu.getGiaDichVu());
			donDichVu.setTotal(dichVu.getGiaDichVu() * donDichVu.getSoLuong());
			donDichVu.setTrangThai(1);
			idv.save(donDichVu);
			model.addAttribute("message", "Create successly");
			model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
			getlistdsdadat(model);
			model.addAttribute("donDichVu", new ServiceMenu());
			return "dv.jsp?view=dichvu/thugian";
		}
	}

	@RequestMapping("/actiondichvukhac")
	public String actionanuong(ModelMap model, HttpServletRequest httpServletRequest,
			@RequestParam(name = "maDatPhong") Integer maDatPhong,
			@RequestParam(name = "tenDichVu") String tenDichVu,
			@RequestParam(name = "thongTinThem") String thongTinThem,
			@RequestParam(name = "giaDichVu") Double giaDichVu) {
		activemenu(model);
		
		// thêm dịch vụ trước
		Service dv = new Service();
		dv.setTenDichVu(tenDichVu);
		dv.setLoaiDichVu(3);
		dv.setGiaDichVu(giaDichVu);
		dsqldvService.save(dv);
		// get id dich vu vua them
		Integer maDV = dsqldvService.getLastIdDv();
		
		ServiceMenu donDichVu = new ServiceMenu();
		Date date = new Date();
		HttpSession session = httpServletRequest.getSession();
		String nguoiDung = session.getAttribute("nguoidung").toString();
		donDichVu.setTenDangNhap(nguoiDung);
		donDichVu.setNgayDat(date);
		donDichVu.setGioDat(date);
		donDichVu.setSoLuong(1);
		donDichVu.setThongTinThem(thongTinThem);
		
		Service dichVu = new Service();
		dichVu.setMaDichVu(maDV);
		donDichVu.setDichVu(dichVu);

		idv.save(donDichVu);
		
		model.addAttribute("message", "Create successly");
		model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
		getlistdsdadat(model);
		model.addAttribute("madatphong", maDatPhong);
		return "dv.jsp?view=dichvu/dichvukhac";
	}

	@RequestMapping("/deletedvdd")
	public String deletedvdd(ModelMap model, @ModelAttribute("donDichVu") ServiceMenu donDichVu,
			@RequestParam("id") int id) {
		activemenu(model);
		if (chuyenhuongtrang == 3) {
			model.addAttribute("width", "100%");
			model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
		}
		donDichVu.setMaDonDichVu(id);
		idv.delete(donDichVu);
		model.addAttribute("message", "Deleted successfully");
		model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
		model.addAttribute("madatphong", madatphong);
		getlistdsdadat(model);
		if (chuyenhuongtrang == 0) {
			model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
			return "dv.jsp?view=dichvu/anuong";
		} else if (chuyenhuongtrang == 1) {
			model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
			return "dv.jsp?view=dichvu/giatui";
		} else if (chuyenhuongtrang == 2) {
			model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
			return "dv.jsp?view=dichvu/thugian";
		} else if (chuyenhuongtrang == 4) {
			model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
			return "dv.jsp?view=dichvu/dichvukhac";
		} else {
			model.addAttribute("titlepage", "Room service reservation " + sophongtemp);
			return "dv";
		}

	}

	public double getDonGia(int madichvu) {
		Service dv = dsqldvService.findById(madichvu).get();
		return dv.getGiaDichVu();
	}

	@ModelAttribute("ltendichvugiatui")
	public List<Service> ltendichvugiatui() {
		List<Service> ltendichvugiatui = dsqldvService.selectgiatui();
		return ltendichvugiatui;
	}

	@ModelAttribute("ltendichvuthugian")
	public List<Service> ltendichvuthugian() {
		List<Service> ltendichvuthugian = dsqldvService.selectthugian();
		return ltendichvuthugian;
	}

	@ModelAttribute("ltendichvuanuong")
	public List<Service> ltendichvuanuong() {
		List<Service> ltendichvuanuong = dsqldvService.selectanuong();
		return ltendichvuanuong;
	}

	public void getlistdsdadat(ModelMap model) {
		List<ServiceMenu> l = idv.datdichvu(madatphong);
		model.addAttribute("l", l);
		double sum = l.stream().map(ServiceMenu::getTotal).reduce(0.0, Double::sum);
		model.addAttribute("sum", sum);
	}

	private void activemenu(ModelMap model) {
		// active trên menu model.addAttribute("activedptp",null);
		model.addAttribute("activedv", "active");
	}

}
