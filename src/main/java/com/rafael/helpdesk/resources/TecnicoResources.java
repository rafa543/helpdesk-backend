package com.rafael.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.helpdesk.domain.Tecnico;
import com.rafael.helpdesk.domain.dtos.TecnicoDTO;
import com.rafael.helpdesk.services.TecnicoService;

@RestController
@RequestMapping(value="/tecnicos")
public class TecnicoResources {
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
		Tecnico obj = tecnicoService.findById(id);
		return ResponseEntity.ok(new TecnicoDTO(obj));
	}
}
