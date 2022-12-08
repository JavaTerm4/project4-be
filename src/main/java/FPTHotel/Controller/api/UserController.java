package FPTHotel.Controller.api;

import FPTHotel.Common.Common;
import FPTHotel.Dto.LoginDto;
import FPTHotel.Dto.RegisterDto;
import FPTHotel.Model.Account;
import FPTHotel.Model.Position;
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
        List<Account> accounts = dangnhapservice.findUser(account.getUsername(), Common.encode(account.getPassword()));
        if (accounts.size() > 0) {
            Account account1 = accounts.get(0);
            RegisterDto accountDTO = new RegisterDto();
            accountDTO.setUsername(account1.getTenDangNhap());
            accountDTO.setFullName(account1.getHoTen());
            accountDTO.setGender(account1.getGioiTinh());
            accountDTO.setBirthday(account1.getNgaySinh());
            accountDTO.setPhoneNumber(account1.getSoDT());
            accountDTO.setEmail(account1.getEmail());
            return ResponseEntity.ok(accountDTO);
        }
        return ResponseEntity.badRequest().body("Username or password is incorrect");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto dto) {
        Account accountQuery = iTaikhoanServices.findByUsername(dto.getUsername());
        if (!Objects.isNull(accountQuery)) {
            return ResponseEntity.badRequest().body("Username is exist");
        }
        Account account = new Account();
        account.setTenDangNhap(dto.getUsername());
        account.setHoTen(dto.getFullName());
        account.setMatKhau(Common.encode(dto.getPassword()));
        account.setSoDT(dto.getPhoneNumber());
        account.setEmail(dto.getEmail());
        account.setGioiTinh(dto.getGender());
        account.setNgaySinh(dto.getBirthday());
        account.setCmnd("000000000");
        Position p = new Position();
        p.setMaChucVu(3);
        account.setChucVu(p);
        dangnhapservice.save(account);
        return ResponseEntity.ok("Register success");
    }

}
