package com.java.TouristManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.java.TouristManagementSystem.dao.ITouristRepo;
import com.java.TouristManagementSystem.exception.TouristNotFoundException;
import com.java.TouristManagementSystem.model.Tourist;
@Service
@Scope("prototype")
public class TouristService implements ITouristService {
	
	@Autowired
	private ITouristRepo repo;
	
	public TouristService()
	{
		System.out.println("TouristServiceBean created");
	}
	
	public Integer registerTourist(Tourist tourist) {
		Tourist t=repo.save(tourist);
		return +t.getId();
	}

	
	public Tourist fetchTouristById(Integer Id) throws TouristNotFoundException {
		/*
		 * Optional<Tourist> id=repo.findById(Id); if(id.isPresent()); id.get(); else
		 * throw TouristNotFoundException("Tourist with givenId not found"); return
		 * "Tourist register by Id:"+id.getId();
		 */
		return repo.findById(Id).orElseThrow(()->new TouristNotFoundException("Tourist with givenId not found"));
	}

	
	public List<Tourist> fetchAllTouristInfo() {
		return repo.findAll();
		 
	}


	@Override
	public String updateTouristInfo(Tourist tourist) {
		Optional<Tourist> opt=repo.findById(tourist.getId());	
		if(opt.isPresent())
		{
			//Tourist  tour=opt.get();
			repo.save(tourist);
			return "Tourist Info update Successfully";
		}
		else 
		{
			throw new TouristNotFoundException("Tourist with given info not present");
		}
		
	}


	@Override
	public String updateTouristBudget(Integer id, Double budget) {
		Optional<Tourist> opti= repo.findById(id);
		if(opti.isPresent())
		{
			Tourist tourist=opti.get();
			tourist.setBudget(budget);
			repo.save(tourist);
			return"tourist info update successfully";
		}else 
		
		{
			throw new TouristNotFoundException("Tourist with given info not found for updated");
		}
	}


	@Override
	public String deleteTouristBasedOnId(Integer id) 
	{
		Optional<Tourist> opti= repo.findById(id);
		if(opti.isPresent())
		{
			repo.deleteById(id);
			return"tourist record deleted with id:"+id;
		}else 
		
		{
			throw new TouristNotFoundException("Tourist with given info not found for deletion");
		}
	}

}
