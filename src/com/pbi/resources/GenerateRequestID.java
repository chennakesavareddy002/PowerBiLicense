package com.pbi.resources;

public class GenerateRequestID {
	private static  Integer freeLicenseCount=0;
	private static  Integer proLicenseCount=0;
	public static String generateRequestId(String typeOfLicense) {
		String requestId=null;
		if(typeOfLicense.equalsIgnoreCase("Free")) {
			freeLicenseCount=freeLicenseCount+1;
			requestId="PBIF".concat(Integer.toString(freeLicenseCount));
		}else {
			proLicenseCount=proLicenseCount+1;
			requestId="PBIP".concat(Integer.toString(proLicenseCount));
		}
		return requestId;
	}
	public static void revokeRequestId(String requestId) {
		if(requestId.contains("PBIF")) {
			freeLicenseCount=freeLicenseCount-1;
		}else {
			proLicenseCount=proLicenseCount-1;
		}
	}
	public Integer getProLicenseCount() {
		return proLicenseCount;
	}
	public Integer getFreeLicenseCount() {
		return freeLicenseCount;
	}
	
}
