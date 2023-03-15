package other;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String input = "Admin1@monorail";
        System.out.println(new test().getMD5(input));
        input = "Admin2@monorail";
        System.out.println(new test().getMD5(input));
        input = "Admin3@monorail";
        System.out.println(new test().getMD5(input));
        input = "Admin4@monorail";
        System.out.println(new test().getMD5(input));
        input = "Admin5@monorail";
        System.out.println(new test().getMD5(input));
        
	}
	
	public String getMD5(String input) throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance("MD5");
		  
        // digest() method is called to calculate message digest
        //  of an input digest() return array of byte
        byte[] messageDigest = md.digest(input.getBytes());

        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, messageDigest);

        // Convert message digest into hex value
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
	}

}
