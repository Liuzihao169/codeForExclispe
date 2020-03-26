package service;

import java.util.List;
import java.util.Timer;

import dao.BirthDao;
import daomain.customer;

public class Servicebirth {
		BirthDao dao=new BirthDao();

		public List<customer> selectbir(String birty) {
			// TODO Auto-generated method stub
			return  dao.selectbir(birty);
		}

		
}
