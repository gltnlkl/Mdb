package controller;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.List;

import dao.ActorDao;
import dto.ActorDto;

public class ActorController implements Readable {

	
	private ActorDao actorDao;

	public ActorController() {
	
		actorDao = new ActorDao();

	 } 

	public List<ActorDto> object(String s) {
		return actorDao.object(s);
	}

	@Override
	public int read(CharBuffer cb) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	

}