package com.mobile.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.dao.MobileDAO;
import com.mobile.model.Mobile;

@Service
public class MobileService {
	
	@Autowired
	MobileDAO mobileDao;
	
	public List<Mobile> allMobile(){
		return (List<Mobile>) mobileDao.findAll();
	}
	
	public List<Mobile> topFiveMobile(){
		return (List<Mobile>) mobileDao.findTopFiveMobiles();
	}
	
	public Mobile searchMobileById(int id){
		Optional<Mobile> s = mobileDao.findById(id);
		if(s.isPresent()){
			return s.get();
		}
		return null;
	}
	
	public Mobile searchMobileByName(String name){
		Optional<Mobile> s = mobileDao.findByMobileName(name);
		if(s.isPresent()){
			return s.get();
		}
		return null;
	}
	
	public List<Mobile> searchMobileByPrice(Double startPrice, Double endPrice){
		return (List<Mobile>) mobileDao.findByPriceBetween(startPrice,endPrice);
	}
	
	
	
	public List<Mobile> searchMobileByDate(Date startDate, Date endDate){
		return (List<Mobile>) mobileDao.findByDateBetween(startDate,endDate);
	}
	
}
