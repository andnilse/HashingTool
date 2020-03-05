import java.io.File;
import java.nio.file.Files;
import java.security.MessageDigest;


public class HashClass {
	
	public String getHash(File file, String algorithm) {
		// TODO Auto-generated constructor stub
		String generatedHash = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(Files.readAllBytes(file.toPath()));
			byte[] bytes = md.digest();
			
			StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedHash = sb.toString();
            return generatedHash;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public static void main(String[] args) {
		HashClass hc = new HashClass();
		File file = new File("C:\\Users\\andni\\Downloads\\eclipse-inst-win64-1.exe");
		System.out.println("MD5: \t\t"+ hc.getHash(file, "MD5"));
		System.out.println("SHA1: \t\t"+ hc.getHash(file, "SHA-1"));
		System.out.println("SHA-256: \t"+hc.getHash(file, "SHA-256"));
		System.out.println("SHA-512: \t"+ hc.getHash(file, "SHA-512"));
	}
}
