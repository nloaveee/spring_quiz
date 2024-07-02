package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String bookingListView(Model model) {

		// db select
		List<Booking> bookingList = bookingBO.getBookingList();

		// Model에 담기
		model.addAttribute("bookingList", bookingList);

		return "booking/bookingList";
	}

	// AJAX - 예약 id로 삭제
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(@RequestParam("id") int id) {

		// db select
		int rowCount = bookingBO.deleteBookingById(id);

		// 응답값
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 데이터가 없습니다.");
		}

		return result;
	}

	// 예약하기 화면
	// http://localhost:8080/booking/make-booking-view
	@GetMapping("/make-booking-view")
	public String makeBooking() {
		return "booking/makeBooking";
	}

	// AJAX 요청 - add 예약
	@ResponseBody
	@PostMapping("/make-booking")
	// date의 경우 String도 가능하다.
	public Map<String, Object> makeBooking(@RequestParam("name") String name, @RequestParam("date") LocalDate date,
			@RequestParam("day") int day, @RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {

		// db insert
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);

		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");

		return result;
	}

	// 예약 조회 기능
	// http://localhost:8080/booking/check-booking-view
	@GetMapping("/check-booking-view")
	public String checkBooking() {
		return "booking/checkBooking";
	}

	// AJAX 요청 - 예약 조회
	@ResponseBody
	@PostMapping("/check-booking")
	public Map<String, Object> checkBooking(@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {

		// db select - 최신 한개만 가져온다.
		Booking booking = bookingBO.getLatestBookingByNamePhoneNumber(name, phoneNumber);

		// 응답값 => json
		Map<String, Object> result = new HashMap<>();

		if (booking != null) {
			// {"code":200, "result":booking 객체}
			// {"code":200, "result":{"id":3, "name":"홍길동"...}}
			result.put("code", 200);
			result.put("result", booking);
		} else {
			// {"code":500, "error_message":"예약 내역이 없습니다."}
			result.put("code", 500);
			result.put("error_message", "예약 내역이 없습니다.");
		}
		return result;
	}
}
