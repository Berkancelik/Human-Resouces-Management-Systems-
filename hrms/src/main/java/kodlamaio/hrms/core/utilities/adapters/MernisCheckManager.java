package kodlamaio.hrms.core.utilities.adapters;

import kodlamaio.hrms.fakeService.FakeService;

public class MernisCheckManager {
	public static boolean isRealPerson(String identityNumber) {
		FakeService fakeService = new FakeService();
		return FakeService.mernisCheck(identityNumber);
	}

}
