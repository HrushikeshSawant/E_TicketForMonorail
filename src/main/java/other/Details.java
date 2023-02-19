package other;

import java.security.*;
import java.text.*;
import java.util.*;

public class Details {
	
	public String hashCal(String type, String str) throws NoSuchAlgorithmException {
		
		byte[] hashseq = str.getBytes();
		StringBuffer hexString = new StringBuffer();
		
		MessageDigest algorithm = MessageDigest.getInstance(type);
		algorithm.reset();
		algorithm.update(hashseq);
		byte messageDigest[] = algorithm.digest();
		
		for(int i=0; i<messageDigest.length; i++) {
			String hex = Integer.toHexString(0xFF & messageDigest[i]);
			if(hex.length() == 1) hexString.append("0");
			hexString.append(hex);
		}
		
		return hexString.toString();
	}
	
	public String dateTime() {
		
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String dateTime = f.format(new Date());
		
		return dateTime;
	}
	
}
