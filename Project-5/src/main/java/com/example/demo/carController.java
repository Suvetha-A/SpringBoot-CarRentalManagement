package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class carController {
	
	@Autowired car_repo ob;

	@PostMapping("/addCars")
	public String saveSeries(@RequestBody Car car)
	{
		Car a= new Car();
		
		
		int id=car.getCarId();
		String model=car.getCarModel();
		String no=car.getCarNo();
		String status=car.getStatus();
		
		a.setCarId(id);
		a.setCarModel(model);
		a.setCarNo(no);
		a.setStatus(status);
		Car first = new Car(id,model,no,status);
		ob.save(first);
		
	return "Added successfully";
	}
	
	@GetMapping("/car")
    public List<Car> getAllcars()
    {

        return ob.findAll();

    }
    
    @GetMapping("car/{id}")
    public List<Car> getCarById(@PathVariable("id") int id){
    

    	return ob.findById(id);

        
    }
    		
	@PostMapping("/update/{id}")
	public String update(@RequestBody Car c,@PathVariable("id") int id)
    {
		
		int id1=c.getCarId();
		String model=c.getCarModel();
		String no=c.getCarNo();
		String status=c.getStatus();
	
		ob.update(id1,model,no,status,id);
			 
		return "successfully updated";
}

	
	@GetMapping("delete/{id}")
    public String deleteById(@PathVariable("id") int id)
    {
	 
		ob.deleteAllByIdInBatch(id);
		
		return "deleted successfully";
}

}
