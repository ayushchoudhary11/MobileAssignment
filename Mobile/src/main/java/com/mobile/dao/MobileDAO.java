package com.mobile.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.model.Mobile;

@Repository
public interface MobileDAO extends CrudRepository<Mobile, Integer> {
	
	@Query(nativeQuery = true, value = "select * from mobiles order by price desc limit 5;")
	public List<Mobile> findTopFiveMobiles();

	public Optional<Mobile> findByMobileName(String name);

	public List<Mobile> findByPriceBetween(Double startPrice, Double endPrice);



	public List<Mobile> findByDateBetween(Date startDate, Date endDate);
	
	
}
