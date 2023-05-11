package review.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {

	@GetMapping("reviewList")
	public String reviewList() {
		return "mypage/reviewList";
	}
}
