package FPTHotel.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "feedback")
public class Feedback {
	@Id
	private int id;
	private String hoTen;
	private String content;
	private String title;
	private String email;
	private Timestamp createdDate;
	private String createdBy;

}
