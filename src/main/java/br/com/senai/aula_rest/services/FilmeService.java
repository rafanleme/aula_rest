package br.com.senai.aula_rest.services;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.security.DenyAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senai.aula_rest.dao.FilmeDao;
import br.com.senai.aula_rest.vo.Filme;
import br.com.senai.aula_rest.vo.GenericResponse;

@Path("/ws/filmes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FilmeService {
	
	FilmeDao fDao;
	
	public FilmeService() {
		fDao = new FilmeDao(); 
	}
	
	@GET
	@Path("/todos")
	public List<Filme> buscarTodas(){
		try {
			
			return fDao.listar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@POST
	@Path("/add")
	public Response adicionarFilme(Filme f){
		GenericResponse response = new GenericResponse();
		try {
			fDao.inserir(f);
			response.setStatus(true);
			response.setMessage("Filme incluído com sucesso");
			return Response.ok(response).build();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	
}
