package FPTHotel.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking {
    private Long id;
    private int maDatPhong;
    private String hoTen;
    private String sodt;
    private int trangThai;
    private int soPhong;
    private Date checkinDuKien;
    private Date checkoutDuKien;
    private Date checkinThuc;
    private Date checkoutThuc;
    private float tienThuePhong;
    private float tienCoc;
    private float tienDichVu;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
