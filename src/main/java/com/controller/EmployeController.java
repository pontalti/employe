package com.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.record.EmployeRecord;
import com.service.EmployeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@RestController
public class EmployeController {
    
    private final EmployeService service;
    
    public EmployeController(EmployeService service) {
		super();
		this.service = service;
	}

	@GetMapping("/")
	public String home() {
		return "Home!!!!!";
	}

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<EmployeRecord> findById(@PathVariable("id") @NotNull @NotBlank String id) {
        var employes = this.service.employeById(id);
		var response =  new ResponseEntity<EmployeRecord>(employes, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(path = "/salary/range/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<EmployeRecord>> findSalaryRange(	@PathVariable("from") @NotNull Integer init, 
																				@PathVariable("to") @NotNull Integer end) {
        var employes = this.service.getEmployesBySalaryRange(init, end);
		var response =  new ResponseEntity<List<EmployeRecord>>(employes, HttpStatus.OK);
		return response;
	}

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<EmployeRecord>> findAll() {
        var employes = this.service.listAll();
		var response =  new ResponseEntity<List<EmployeRecord>>(employes, HttpStatus.OK);
		return response;
	}

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<EmployeRecord> save(@RequestBody(required = true) @Valid EmployeRecord employe) {
		var response = saveOrupdate(employe, HttpStatus.CREATED);
		return response;
	}

    @PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<EmployeRecord> update(@RequestBody(required = true) @Valid EmployeRecord employe) {
		var response = saveOrupdate(employe, HttpStatus.OK);
		return response;
	}

    @DeleteMapping(path = "/id/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody ResponseEntity<String> delete(@PathVariable("id") @NotNull @NotBlank String id) {
        var msg =  this.service.delete(id);
		var response =  new ResponseEntity<String>(msg, HttpStatus.OK);
		return response;
	}

    private ResponseEntity<EmployeRecord> saveOrupdate(EmployeRecord employe, HttpStatus http) {
        var newEmploye = this.service.saveOrUpdate(employe);
		var response = new ResponseEntity<EmployeRecord>(newEmploye, http);
        return response;
    }

}
