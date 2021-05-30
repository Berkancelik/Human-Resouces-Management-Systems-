package kodlamaio.hrms.fakeService;

public class MernisServiceFake {
	public boolean ValidateByHuman(long nationalId, String firstName, String lastName, int yearOfBirth) {
		System.out.println(firstName + " "+ lastName + "Kişi onaylanmış");
		return true;

	}

}
