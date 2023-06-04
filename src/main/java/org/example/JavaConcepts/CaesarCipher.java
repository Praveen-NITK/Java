package JavaConcepts;

public class CaesarCipher {
    char[] encoder= new char[26];
    char[] decoder= new char[26];
    public CaesarCipher(int rotation){
        for (int i = 0; i <26 ; i++) {
            encoder[i]=(char) ('A'+(i+rotation)%26);
            decoder[i]=(char) ('A'+(i+26-rotation)%26);
        }
    }
    public String encrypt(String message){
        return transform(message,encoder);
    }

    public String dncrypt(String message){
        return transform(message,decoder);
    }
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        System.out.println("Encryption code = " + new String(cipher.encoder));
        System.out.println("Decryption code = " + new String(cipher.decoder));
        String message = "I LOVE YOU";
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        String answer = cipher.dncrypt(coded);
        System.out.println("Message: " + answer);
    }

    private String transform(String message, char[] code) {
        char[] msg= message.toCharArray();
        for (int i = 0; i <message.length() ; i++) {
            if(Character.isUpperCase(msg[i])){
                int j= msg[i]-'A';
                msg[i]=code[j];
            }
        }
        return new String(msg);
    }
}
