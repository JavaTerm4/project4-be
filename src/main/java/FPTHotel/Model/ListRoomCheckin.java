package FPTHotel.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ListRoomCheckin {
    private int maDatPhong;
    private int maPhong;
    private int soPhong;
    private String khuyenMai;
    private int tang;
    private String tenLoaiPhong;
}
