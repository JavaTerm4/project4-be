package FPTHotel.Controller;

import FPTHotel.Common.Common;
import FPTHotel.Model.Account;
import FPTHotel.Services.ITaikhoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DangKiController {

	@Autowired
	ITaikhoanServices iTaikhoanServices;

	@GetMapping("/register")
	public String registerPage(ModelMap model, @ModelAttribute("taikhoan") Account taikhoan){
		return "register";
	}

	@RequestMapping("/action-register")
	public String actionRegister(ModelMap model, @ModelAttribute("taikhoan") Account taikhoan){
		String a = null;
		try {
			a = iTaikhoanServices.findById(taikhoan.getTenDangNhap()).get().getTenDangNhap();
		} catch (Exception e) {
			a = "null";
		}
		if (a.equals(taikhoan.getTenDangNhap())) {
			model.addAttribute("errortk", "Username is available");
			return "register";
		}
		else {
			taikhoan.setMatKhau(Common.encode(taikhoan.getMatKhau()));
			Date today = new Date();
			taikhoan.setNgayTao(today);
			taikhoan.setGioTao(today);
			taikhoan.setCreatedBy(taikhoan.getTenDangNhap());
			taikhoan.setCreatedDate(today);
			taikhoan.setUpdatedBy(taikhoan.getTenDangNhap());
			taikhoan.setUpdatedDate(today);
			iTaikhoanServices.save(taikhoan);// nếu trùng id thì không thêm mà thành sửa.
			return "login";
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class,  new CustomDateEditor(dateFormat, true));
	}
}
