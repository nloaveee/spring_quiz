package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;

	// input: x
	// output: List<Booking>
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}

	// input: id
	// output: int
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}

	public void addBooking(String name, LocalDate date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}

	// input : name, phoneNumber
	// output: Booking(최신) or null
	public Booking getLatestBookingByNamePhoneNumber(String name, String phoneNumber) {
		// 없을 때: [] (없을 때는 null이 아니다.)
		// 있을 때: [booking1, booking2...]
		List<Booking> bookingList = bookingMapper.selectBookingListByNamePhoneNumber(name, phoneNumber);

		// 마지막 index 값이 제일 최신 데이터
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
	}
}
