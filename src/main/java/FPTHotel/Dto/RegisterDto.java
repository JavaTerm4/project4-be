package FPTHotel.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RegisterDto {
    private String username;
    private String password;
    private String fullName;
    private String gender;
    private Date birthday;
    private String phoneNumber;
    private String email;
}
