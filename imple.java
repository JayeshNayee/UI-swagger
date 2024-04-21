package com.swagger.imple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.swagger.entity.entity;
import com.swagger.interFace.interfaceSwagger;
import com.swagger.repoInterface.repoInterface;
import com.swagger.swaagerDto.swaagerDto;
@Component
public class imple implements interfaceSwagger {

	@Autowired
	private repoInterface repoInterface;
	
	@Autowired
	 private Faker faker;
	@Override
	public List<swaagerDto> getAll() {
		List<entity>allEntities  =  (List<entity>)repoInterface.findAll();

		List<swaagerDto> dtos = new ArrayList<>();
		
		for(entity entity : allEntities) {
			
			swaagerDto swaagerDto = new swaagerDto();
			swaagerDto.setId(entity.getId());
			swaagerDto.setPname(entity.getPname());
			swaagerDto.setPrice(entity.getPrice());
			
			dtos.add(swaagerDto);
		}
		return dtos;
	}

	@Override
	public String saveProdut(swaagerDto swaagerDto) {
	entity mainEntity = new entity();
		

		mainEntity.setPname(swaagerDto.getPname());
		mainEntity.setPrice(swaagerDto.getPrice());
		
		repoInterface.save(mainEntity);
		return "Data will  be saved";
	}

	@Override
	public String deleteAllProduct() {
		repoInterface.deleteAll();
		return "All data will be deleted";
	}

	@Override
	public String singleDelete(Long id) {
	
		try {
			repoInterface.deleteById(id);
			return "One row will be deleted ";
		} catch (Exception e) {
			System.out.println("Your id is not found , so its not possiable ..");
			return "Your id is not found , so its not possiable ..";
		}
	}

	@Override
	public String updateProduct(swaagerDto swaagerDto, Long id) {

		try {
			Optional< entity>optionalres =repoInterface.findById(id);
			if(optionalres.isPresent())
				{
					entity mainEntity1 = optionalres.get();
					
					mainEntity1.setPname(swaagerDto.getPname());
					mainEntity1.setPrice(swaagerDto.getPrice());
					repoInterface.save(mainEntity1);
					return "Data will be updated";
				}
		} catch (Exception e) {

		}
				return "Data will be not updated";
	}

}
