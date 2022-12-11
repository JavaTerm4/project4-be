package FPTHotel.Controller.api;

import FPTHotel.Dto.RoomDto;
import FPTHotel.Model.Room;
import FPTHotel.Services.QuanLyPhongService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author macos
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    QuanLyPhongService room;
    
    @GetMapping()
    public ResponseEntity<?> listRoom(){
        return ResponseEntity.ok(1);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> roomDetail(@PathVariable int id){
        List<Room> rt = room.TimMaPhong(id);
        if(rt.size()>0){
            RoomDto room = new RoomDto();
            Room r = rt.get(0);
            room.setId(r.getMaPhong());
            room.setNumber(r.getSoPhong());
            room.setFloor(r.getTang());
            room.setConvenient(r.getTienNghi());
            room.setImage("/hinh/phong/"+r.getHinhAnh());
            room.setPrice(r.getGiaPhong());
            room.setPriceFirstHour(r.getGiaPhongGioDau());
            room.setPriceLastHour(r.getGiaPhongGioSau());
            room.setPromotion(r.getKhuyenMai());
            room.setStatus(r.getTrangThai());
            room.setCountHomestay(r.getCountHomestay());
            room.setCountBook(r.getCountDatLich());
            return ResponseEntity.ok(room);
        }
        return ResponseEntity.ok(null);
    }
}
