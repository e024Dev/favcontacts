package br.com.albertoferes.favcontacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.albertoferes.favcontacts.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{
    
    public Contato findByNome(String model);
}
