package com.itwill.jpa.repository;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.SpringJpaApplicationTests;
import com.itwill.jpa.entity.Guest;

class GuestRepositoryTest extends SpringJpaApplicationTests {
	@Autowired
	GuestRepository guestRepository;
	
	@Disabled
	@Test
	@DisplayName("방명록저장")
	void save() {
		Guest guest1=Guest.builder()
					.guestName("뉴경호1")
					.guestEmail("newkim1@gmail.com")
					.guestHomepage("http://www.kim1.co.kr")
					.guestTitle("새제목1")
					.guestContent("새내용1")
					.build();
		Guest savedGuest1=guestRepository.save(guest1);
		System.out.println(guest1);
		System.out.println(savedGuest1);
		
		Guest guest2=Guest.builder()
				.guestName("뉴경호2")
				.guestEmail("newkim2@gmail.com")
				.guestHomepage("http://www.kim2.co.kr")
				.guestTitle("새제목2")
				.guestContent("새내용2")
				.build();
		Guest savedGuest2=guestRepository.save(guest2);
		System.out.println(guest2);
		System.out.println(savedGuest2);
	}
	@Disabled
	@DisplayName("방명록수정")
	@Test
	void update() {
		Guest guest1=guestRepository.findById(1L).get();
		System.out.println("guest 1L :"+guest1);
		guest1.setGuestName("제임스딘");
		guestRepository.save(guest1);
		List<Guest> guestList=guestRepository.findByGuestNoBetween(1L, 10L);
		for (Guest tempGuest : guestList) {
			tempGuest.setGuestName("제임수"+ tempGuest.getGuestNo());
		}
		guestRepository.saveAll(guestList);
		
	}
	
	@Test
	@Disabled
	void delete() {
		
		guestRepository.delete(new Guest(1L, null, null, null, null, null, null));
		guestRepository.deleteById(2L);
		
	}
	@Transactional
	@Rollback(value = false)
	@Test
	//@Disabled
	void custom_method() throws Exception{
		System.out.println(">>> "+guestRepository.count());
		System.out.println(">>> "+guestRepository.existsById(31L));
		System.out.println(">>> "+guestRepository.countByGuestName("guest1"));
		System.out.println(">>> "+guestRepository.existsByGuestName("guest1"));
		System.out.println(">>>delet count --> "+guestRepository.removeByGuestName("guest1"));
		
		System.out.println(">>> "+
				guestRepository.findByGuestDateGreaterThan(
						new SimpleDateFormat("yyyy/MM/dd").parse("2023/10/08")).size());
		
	}

}









