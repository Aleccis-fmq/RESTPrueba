package edu.com.services.imple;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.com.service.IGenericService;

public abstract class IGenericImplements <T,ID> implements IGenericService<T, ID>{
	
	//
	protected abstract JpaRepository<T, ID> getRepo();
	
	//
	@Override
	public T registrar (T t) throws Exception{
		return getRepo().save(t);
	}
	
	@Override
	public T modificar (T t) throws Exception{
		return getRepo().save(t);
	}
	
	@Override
	public List<T> listar() throws Exception{
		return getRepo().findAll();
	}
	
	@Override
	public T listarPorId(ID id) throws Exception{
		return getRepo().findById(id).orElse(null);
	}
	
	@Override
	public void eliminar(ID id) throws Exception {
		getRepo().deleteById(id);
	}

}
