package FPTHotel.Controller.api;

import FPTHotel.Common.Common;
import FPTHotel.Dto.LoginDto;
import FPTHotel.Model.Account;
import FPTHotel.Services.ITaikhoanServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    ITaikhoanServices dangnhapservice;

    @Autowired
    ITaikhoanServices iTaikhoanServices;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto account) {
        List<Account> accounts = dangnhapservice.findUser(account.getUsername(), account.getPassword());
        if (accounts.size() > 0) {
            return ResponseEntity.ok(accounts.get(0));
        }
        return ResponseEntity.badRequest().body("Username or password is incorrect");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Account account) {
        Account accountQuery = iTaikhoanServices.findByUsername(account.getTenDangNhap());
        if (!Objects.isNull(accountQuery)) {
            return ResponseEntity.badRequest().body("Username is exist");
        }
        account.setMatKhau(Common.encode(account.getMatKhau()));
        Date today = new Date();
        account.setNgayTao(today);
        account.setGioTao(today);
        return ResponseEntity.ok(dangnhapservice.save(account));
    }

}
