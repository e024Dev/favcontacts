package br.com.albertoferes.favcontacts;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.albertoferes.favcontacts.model.Contato;
import br.com.albertoferes.favcontacts.repositories.ContatoRepository;

@SpringBootApplication
public class FavcontactsApplication implements CommandLineRunner{

	@Autowired
	private ContatoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(FavcontactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Contato c1 = new Contato("Luccas Arruda", "99999-1111", "luccas@gmail.com");
		Contato c2 = new Contato("Renata Zorzenon", "99999-2222", "renata@gmail.com");
		Contato c3 = new Contato("Marina Borges", "99999-333", "marina@gmail.com");
		
		repository.saveAll(Arrays.asList(c1, c2, c3));

		List<Contato> contatos = repository.findAll();

		contatos.forEach(System.out::println);

		Optional<Contato> renata = repository.findById(2L);

		System.out.println(renata.get());

		Contato luccas = repository.findByNome("Luccas Arruda");

		System.out.println(luccas);

		repository.delete(c1);

		repository.findAll().forEach(System.out::println);


	}

}
