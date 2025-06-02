import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        String url ="acme.com/getCatalog";
        Random ran = new Random();
        Integer urlId = ran.nextInt(99999);
        System.out.println(urlId);

        Integer myId = urlId;
        byte [] encodedBytes = Base64.getEncoder().encode(myId.toString().getBytes());
        System.out.println("Encoded "+new String(encodedBytes));
        byte[] decodeBytes = Base64.getDecoder().decode(encodedBytes);
        System.out.println("Decoded "+ new String(decodeBytes));
    }
}