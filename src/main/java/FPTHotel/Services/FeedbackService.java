package FPTHotel.Services;

import FPTHotel.Model.Feedback;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author macos
 */
public interface FeedbackService extends CrudRepository<Feedback, Integer>{
    
}
