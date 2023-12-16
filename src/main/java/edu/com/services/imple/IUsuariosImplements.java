package edu.com.services.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.com.model.Usuarios;
import edu.com.repo.IUsuariosRepo;
import edu.com.service.IUsuariosService;

@Service
public class IUsuariosImplements extends IGenericImplements<Usuarios, Integer> implements IUsuariosService{

	//implementada
	@Autowired
	private IUsuariosRepo rep;
	
	
	@Override
	protected JpaRepository<Usuarios, Integer> getRepo() {
		
		return rep;
	}
	

}
