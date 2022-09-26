package com.rafael.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rafael.helpdesk.domain.Chamado;
import com.rafael.helpdesk.domain.Cliente;
import com.rafael.helpdesk.domain.Tecnico;
import com.rafael.helpdesk.domain.enums.Perfil;
import com.rafael.helpdesk.domain.enums.Prioridade;
import com.rafael.helpdesk.domain.enums.Status;
import com.rafael.helpdesk.repositories.ChamadoRepository;
import com.rafael.helpdesk.repositories.ClienteRepository;
import com.rafael.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
//	@Autowired
//	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDbB() {
		Tecnico tec1 = new Tecnico(null, "Valdir cezar", "06539588380", "email@gmail.com", encoder.encode("1234567"));
		tec1.addPerfil(Perfil.ADMIN);
		
		Tecnico tec2 = new Tecnico(null, "Rafael araujo", "33229854314", "rafaeel@gmail.com", encoder.encode("84616518"));
		tec1.addPerfil(Perfil.TECNICO);
		
		Cliente cli1 = new Cliente(null, "Linux Tovars", "27712889821", "linus@gmail.com", encoder.encode("84646846486"));
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamdo 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
