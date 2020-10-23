package com.mobile.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mobile.model.Mobile;
import com.mobile.service.MobileService;

@Controller
public class MobileController {
	
	@Autowired
	MobileService mobileService;
	
	@GetMapping(value="/allMobiles")
	public ResponseEntity<?> mobileList()
	{
		return new ResponseEntity<List<Mobile>>(mobileService.allMobile(),HttpStatus.OK);
	}
	
	@GetMapping(value="/topFiveMobiles")
	public ResponseEntity<?> topFiveMobiles()
	{
		return new ResponseEntity<List<Mobile>>(mobileService.topFiveMobile(),HttpStatus.OK);
	}
	
	@GetMapping(value="/searchMobileById/{id}")
	public ResponseEntity<?> searchMobileById(@PathVariable("id") int id)
	{
		Mobile stck = mobileService.searchMobileById(id);
		if(stck==null){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Mobile>(stck,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchMobileByName/{name}")
	public ResponseEntity<?> searchMobileById(@PathVariable("name") String name)
	{
		Mobile s = mobileService.searchMobileByName(name);
		if(s==null){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Mobile>(s,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchMobileByPrice/{startPrice}/{endPrice}")
	public ResponseEntity<?> searchMobileByPrice(@PathVariable("startPrice") Double startPrice, @PathVariable("endPrice") Double endPrice )
	{
		List<Mobile> s = mobileService.searchMobileByPrice(startPrice,endPrice);
		if(s.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Mobile>>(s,HttpStatus.OK);
	}
	
	
	
	@GetMapping(value="/searchMobileByDate/{startDate}/{endDate}")
	public ResponseEntity<?> searchMobileById(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate )
	{
		List<Mobile> s = mobileService.searchMobileByDate(startDate,endDate);
		if(s.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Mobile>>(s,HttpStatus.OK);
	}
}
