package edu.com.services.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.com.model.Autores;
import edu.com.repo.IAutorRepo;
import edu.com.repo.IUsuariosRepo;
import edu.com.service.IAutorService;

@Service
public class IAutoresImplements extends IGenericImplements<Autores, Integer> implements IAutorService{

	//IMPL
	@Autowired
	private IAutorRepo rep;
	
	
	@Override
	protected JpaRepository<Autores, Integer> getRepo() {
		
		return rep;
	}
	

}
