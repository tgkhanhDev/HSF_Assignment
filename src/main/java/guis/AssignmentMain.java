package guis;

import repositories.AccountRepo;
import repositories.CarRepo;
import repositories.IAccountRepo;
import repositories.ICarRepo;

public class AssignmentMain {

	public static void main(String[] args) {
		String configFile = "";
		IAccountRepo accountRepo = new AccountRepo(configFile);
		ICarRepo carRepo = new CarRepo(configFile);
		
	}

}
