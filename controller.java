package com.swagger.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.interFace.interfaceSwagger;
import com.swagger.swaagerDto.swaagerDto;

import jakarta.validation.Valid;

@RestController
public class controller {
	
	@Autowired
	private interfaceSwagger interfaceSwagger;
	
	@GetMapping(value = "/getAll")
	public ResponseEntity< List<swaagerDto>> getAll() {
		return new ResponseEntity<List<swaagerDto>>(interfaceSwagger.getAll(),HttpStatus.OK);
	}
	


	@PostMapping(value = "/saveProdut")
	public ResponseEntity<String> saveProdut(@Valid	@RequestBody swaagerDto pDto) {
		
		return new ResponseEntity<>(interfaceSwagger.saveProdut(pDto), HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(value = "/updateProduct/{id}")
	public  ResponseEntity<String> updateProduct(@Valid	@RequestBody swaagerDto pDto , @PathVariable Long id) {
		return new ResponseEntity<>(interfaceSwagger.updateProduct(pDto, id), HttpStatus.CONTINUE);

		
	}
	@DeleteMapping(value =  "/deleteAllStu")
	public  String deleteAllStu() {
		return interfaceSwagger.deleteAllProduct() ;
	}
	
	@DeleteMapping(value = "/singleDelete/{id}")
	public  ResponseEntity<String> singleDelete(@Valid	@PathVariable Long id) {
		return new ResponseEntity<>(interfaceSwagger.singleDelete(id), HttpStatus.CONTINUE);
		
	}
}
