package com.rafael.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.helpdesk.domain.Tecnico;
import com.rafael.helpdesk.repositories.TecnicoRepository;
import com.rafael.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objecto não encontrado! ID: "+ id));
	}
}
