package edu.com.services.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edu.com.model.Prestamos;
import edu.com.repo.IPrestamoRepo;
import edu.com.service.IPrestamoService;

@Service
public class IPrestamoImplements extends IGenericImplements<Prestamos, Integer> implements IPrestamoService {

	
	//impl
	@Autowired
	private IPrestamoRepo rep;

	@Override
	protected JpaRepository<Prestamos, Integer> getRepo() {
		return rep;
	}
	

}
