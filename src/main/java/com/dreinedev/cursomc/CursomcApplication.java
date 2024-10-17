package com.dreinedev.cursomc;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.dreinedev.cursomc.domain.Categoria;
import com.dreinedev.cursomc.domain.Cidade;
import com.dreinedev.cursomc.domain.Cliente;
import com.dreinedev.cursomc.domain.Endereco;
import com.dreinedev.cursomc.domain.Estado;
import com.dreinedev.cursomc.domain.Produto;
import com.dreinedev.cursomc.domain.enums.TipoCliente;
import com.dreinedev.cursomc.repositories.CategoriaRepository;
import com.dreinedev.cursomc.repositories.CidadeRepository;
import com.dreinedev.cursomc.repositories.ClienteRepository;
import com.dreinedev.cursomc.repositories.EnderecoRepository;
import com.dreinedev.cursomc.repositories.EstadoRepository;
import com.dreinedev.cursomc.repositories.ProdutoRepository;

@RestController
@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository; 
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args)  {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
				
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
						
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "mariasilva@gmail.com", "12345678900", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("12345678", "987653245"));
		
		Endereco e1 = new Endereco(null, "Rua das Camélias", "234" ,"Qd.42" , "Centro", "12345678", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Tulipas", "249", "Qd.42", "Centro", "45678976", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		
	}

}
