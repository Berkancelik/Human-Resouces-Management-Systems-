package kodlamaio.hrms.core.utilities.adapters;

import kodlamaio.hrms.fakeService.MernisServiceFake;

public class MernisServiceAdapter implements ValidationService {

	@Override
	public boolean validateByMernis(long nationalId, String firstname, String lastName, int yearOfBirth) {
		MernisServiceFake client = new MernisServiceFake();

		boolean result = true;
		try {
			result = client.ValidateByHuman(nationalId, firstname, lastName, yearOfBirth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
