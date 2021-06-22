package kodlamaio.hrms.fakeService;

public class MernisServiceFake {
	public boolean ValidateByHuman(String nationalId, String firstName, String lastName, int yearOfBirth) {
		System.out.println(firstName + " "+ lastName + "Kişi onaylanmış");
		return true;

	}

}
