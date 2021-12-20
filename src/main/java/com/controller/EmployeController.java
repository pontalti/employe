package com.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.record.EmployeRecord;
import com.service.EmployeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employe")
public class EmployeController {
    
    @Autowired
    private EmployeService service;

	@GetMapping
	public String home() {
		return "Home!!!!! teste";
	}

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<EmployeRecord> findById(@PathVariable("id") @NotNull @NotBlank String id) {
        var employes = this.service.employeById(id);
		ResponseEntity<EmployeRecord> response =  new ResponseEntity<EmployeRecord>(employes, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(path = "/salary/range/{from}/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<EmployeRecord>> findSalaryRange(	@PathVariable("from") @NotNull @NotBlank Integer init, 
																				@PathVariable("to") @NotNull @NotBlank Integer end) {
        var employes = this.service.getEmployesBySalaryRange(init, end);
		ResponseEntity<List<EmployeRecord>> response =  new ResponseEntity<List<EmployeRecord>>(employes, HttpStatus.OK);
		return response;
	}

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<EmployeRecord>> findAll() {
        var employes = this.service.listAll();
		ResponseEntity<List<EmployeRecord>> response =  new ResponseEntity<List<EmployeRecord>>(employes, HttpStatus.OK);
		return response;
	}

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<EmployeRecord> save(@RequestBody(required = true) @Valid EmployeRecord employe) {
		ResponseEntity<EmployeRecord> response = saveOrupdate(employe, HttpStatus.CREATED);
		return response;
	}

    @PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<EmployeRecord> update(@RequestBody(required = true) @Valid EmployeRecord employe) {
		ResponseEntity<EmployeRecord> response = saveOrupdate(employe, HttpStatus.OK);
		return response;
	}

    @DeleteMapping(path = "/id/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody ResponseEntity<String> delete(@PathVariable("id") @NotNull @NotBlank String id) {
        var msg =  this.service.delete(id);
		ResponseEntity<String> response =  new ResponseEntity<String>(msg, HttpStatus.OK);
		return response;
	}

    private ResponseEntity<EmployeRecord> saveOrupdate(EmployeRecord employe, HttpStatus http) {
        var newEmploye = this.service.saveOrUpdate(employe);
		ResponseEntity<EmployeRecord> response = new ResponseEntity<EmployeRecord>(newEmploye, http);
        return response;
    }

}
