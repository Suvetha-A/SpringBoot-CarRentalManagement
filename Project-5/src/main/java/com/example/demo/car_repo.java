package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface car_repo extends JpaRepository<Car,Integer>{
	
	 @Query(value = "SELECT * FROM car c where c.car_id = ?1", nativeQuery = true)
	 List<Car> findById(int id);
	    
	 @Modifying
	 @Transactional 
	 @Query(value = "DELETE FROM car WHERE car_id = ?1 ", nativeQuery = true)
	 void deleteAllByIdInBatch(int id);
	 
	 @Transactional
	 @Modifying
	 @Query(value = "Update car c set c.car_id = ?1 ,c.car_model=?2, c.car_no =?3 , c.status=?4  where c.car_id = ?5", nativeQuery = true)
	 void update(int id1, String model,String no,String status,int id);


		

}
