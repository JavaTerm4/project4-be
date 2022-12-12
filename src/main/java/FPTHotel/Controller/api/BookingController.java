package FPTHotel.Controller.api;

import FPTHotel.Dto.RoomDto;
import FPTHotel.Dto.RoomTypeDto;
import FPTHotel.Model.Room;
import FPTHotel.Services.QuanLyPhongService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookingController {

    @Autowired
    QuanLyPhongService quanLyPhongService;

    @GetMapping("/search-available")
    public ResponseEntity<?> searchAvailable(@RequestParam("checkin") String checkin,
                                  @RequestParam("checkout") String checkout,
                                  @RequestParam("typeRoom") String typeRoom,
                                  @RequestParam("maxPrice") double maxPrice) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date checkinDate = formatter.parse(checkin);
        Date checkoutDate = formatter.parse(checkout);
        List<Room> rooms = quanLyPhongService.findValidRoom(checkinDate, checkoutDate, typeRoom, maxPrice);
        List<RoomDto> roomDtos = rooms.stream().map(room -> {
            RoomDto roomDto = new RoomDto();
            roomDto.setMaPhong(room.getMaPhong());
            roomDto.setGiaPhong(room.getGiaPhong());
            roomDto.setSoPhong(room.getSoPhong());
            roomDto.setTang(room.getTang());
            roomDto.setTrangThai(room.getTrangThai());

            RoomTypeDto roomTypeDto = new RoomTypeDto();
            roomTypeDto.setMaLoaiPhong(room.getLoaiPhong().getMaLoaiPhong());
            roomTypeDto.setTenLoaiPhong(room.getLoaiPhong().getTenLoaiPhong());
            roomTypeDto.setMoTa(room.getLoaiPhong().getMoTa());

            roomDto.setLoaiPhong(roomTypeDto);
            roomDto.setGiaPhongGioDau(room.getGiaPhongGioDau());
            roomDto.setHinhAnh(room.getHinhAnh());
            roomDto.setKhuyenMai(room.getKhuyenMai());
            roomDto.setTienNghi(room.getTienNghi());
            roomDto.setGiaPhongGioSau(room.getGiaPhongGioSau());
            return roomDto;
        }).collect(Collectors.toList());
       return ResponseEntity.ok(roomDtos);
    }
}
