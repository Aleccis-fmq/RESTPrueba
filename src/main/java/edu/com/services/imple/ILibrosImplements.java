package edu.com.services.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.com.model.Libros;
import edu.com.repo.ILibrosRepo;
import edu.com.service.ILibrosService;

@Service
public class ILibrosImplements extends IGenericImplements<Libros, Integer> implements ILibrosService{

	//impl
	@Autowired
	private ILibrosRepo rep;
	
	@Override
	protected JpaRepository<Libros, Integer> getRepo() {
		
		return rep;
	}

	

	
}
