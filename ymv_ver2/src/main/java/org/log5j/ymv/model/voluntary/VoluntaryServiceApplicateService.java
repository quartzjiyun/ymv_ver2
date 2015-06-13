package org.log5j.ymv.model.voluntary;

public interface VoluntaryServiceApplicateService {
	public void registerVolunteerApplicant(VoluntaryServiceApplicateVO vsavo);
	public boolean checkVolunteerApplicant(int recruitNo, int memberNo);
}