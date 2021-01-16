import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Scanner;
public class TestEncrypt {
    public static void main(String[] args) {
        try{
            Scanner sc =new Scanner(System.in);
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            String s = sc.nextLine();
            String key = sc.nextLine();
            KeySpec spec = new PBEKeySpec(key.toCharArray(), salt, 65536, 256); // AES-256
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] skey = f.generateSecret(spec).getEncoded();
            // KeySpec fakespec = new PBEKeySpec("567".toCharArray(), salt, 65536, 256);
            // byte[] fkey = f.generateSecret(fakespec).getEncoded();
            Key aesKey = new SecretKeySpec(skey, "AES");
            // Key fakekey= new SecretKeySpec(fkey,"AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(s.getBytes());
            
            System.out.println(new String(encrypted));
            StringBuilder sb = new StringBuilder();
            for (byte b : encrypted) {
                sb.append((char)b);
            }
            String message = sb.toString();
            // cipher.init(Cipher.DECRYPT_MODE,aesKey);
            

            // try {
            byte[] p = new byte[message.length()];
            for (int i = 0; i < message.length(); i++) {
                p[i]= (byte)message.charAt(i);
            }
            cipher.init(Cipher.DECRYPT_MODE,aesKey);
            byte[] text = cipher.doFinal(p);
            System.out.println(new String(text));
              
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}