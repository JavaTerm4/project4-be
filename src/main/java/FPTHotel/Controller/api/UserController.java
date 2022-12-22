package FPTHotel.Controller.api;

import FPTHotel.Common.Common;
import FPTHotel.Dto.LoginDto;
import FPTHotel.Dto.RegisterDto;
import FPTHotel.Model.Account;
import FPTHotel.Model.Feedback;
import FPTHotel.Model.Position;
import FPTHotel.Services.FeedbackService;
import FPTHotel.Services.ITaikhoanServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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

    @Autowired
    FeedbackService feedService;


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
    public ResponseEntity<?> register(@RequestBody @ModelAttribute RegisterDto dto,String birth) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = new Date();
        try {
            birthday = formatter.parse(birth);
        }catch (Exception e) {
            e.getMessage();
        }
        Account accountQuery = iTaikhoanServices.findByUsername(dto.getUsername());
        if (!Objects.isNull(accountQuery)) {
            return ResponseEntity.badRequest().body(1);
        }
        Account account = new Account();
        account.setTenDangNhap(dto.getUsername());
        account.setHoTen(dto.getFullName());
        account.setMatKhau(Common.encode(dto.getPassword()));
        account.setSoDT(dto.getPhoneNumber());
        account.setEmail(dto.getEmail());
        account.setGioiTinh(dto.getGender());
        account.setNgaySinh(birthday);
        account.setCmnd("000000000");
        Position p = new Position();
        p.setMaChucVu(3);
        account.setChucVu(p);
        dangnhapservice.save(account);
        return ResponseEntity.ok(2);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateProfile(@RequestBody @ModelAttribute RegisterDto dto,String birth) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = new Date();
        try {
            birthday = formatter.parse(birth);
        }catch (Exception e) {
            e.getMessage();
        }
        Account user = iTaikhoanServices.findByUsername(dto.getUsername());
        if(dto.getEmail().isEmpty()){
            dto.setEmail(user.getEmail());
        }
        if (dto.getFullName().isEmpty()){
            dto.setFullName(user.getHoTen());
        }
        if (dto.getPhoneNumber().isEmpty()){
            dto.setPhoneNumber(user.getSoDT());
        }
        if(dto.getGender().isEmpty()){
            dto.setGender(user.getGioiTinh());
        }

        user.setTenDangNhap(dto.getUsername());
        user.setHoTen(dto.getFullName());
        user.setSoDT(dto.getPhoneNumber());
        user.setEmail(dto.getEmail());
        user.setGioiTinh(dto.getGender());
        user.setNgaySinh(birthday);
        user.setCmnd("000000000");
        Position p = new Position();
        p.setMaChucVu(3);
        user.setChucVu(p);
        dangnhapservice.save(user);
        return ResponseEntity.ok(1);
    }
    @GetMapping("/profile")
    public ResponseEntity<?> updateProfile(@RequestParam("username") String username){
        Account u = iTaikhoanServices.findByUsername(username);
        Account ac = new Account();
        ac.setTenDangNhap(u.getTenDangNhap());
        ac.setNgaySinh(u.getNgaySinh());
        ac.setGioiTinh(u.getGioiTinh());
        ac.setEmail(u.getEmail());
        ac.setHoTen(u.getHoTen());
        ac.setSoDT(u.getSoDT());
        return ResponseEntity.ok(ac);
    }

    @PostMapping("/feedback")
    public ResponseEntity<?> feedback(@RequestBody @ModelAttribute Feedback f ){
        if(f.getCreatedBy().isEmpty()){
            f.setCreatedBy(f.getHoTen());
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Feedback feed = new Feedback();
        feed.setCreatedBy(f.getCreatedBy());
        feed.setHoTen(f.getHoTen());
        feed.setEmail(f.getEmail());
        feed.setTitle(f.getTitle());
        feed.setContent(f.getContent());
        feed.setCreatedDate(timestamp);
        feedService.save(feed);
        return ResponseEntity.ok(1);
    }
}
