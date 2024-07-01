package com.quiz.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@Controller
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingBO bookingBO;

	// 예약 목록
	// http://localhost:8080/booking/booking-list-view
	@GetMapping("/booking-list-view")
	public String bookingListView(@ModelAttribute Booking booking, Model model) {

		// db select
		List<Booking> bookingList = bookingBO.getBookingList(booking);
		model.addAttribute("bookingList", bookingList);

		return "booking/bookingList";
	}

	// 예약하기 페이지
	// http://localhost:8080/booking/make-booking-view
	@GetMapping("/make-booking-view")
	public String makeBooking() {
		return "booking/makeBooking";
	}

	// 예약 조회 기능
	// http://localhost:8080/booking/check-booking-view
	@GetMapping("/check-booking-view")
	public String checkBooking() {

		return "booking/checkBooking";
	}
}
