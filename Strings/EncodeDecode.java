package Strings;
//Goldman sacs
public class EncodeDecode {
    public static void main(String[] args) {
        String result=secureChannel(2, "Oppeeen", "123");
        System.out.println(result);
    }

    static String secureChannel(int operation, String message, String key) {
        if (message == null || key == null || (message.isEmpty() && !key.isEmpty()))
            return "-1";
        if ((message.isEmpty() && key.isEmpty()) || (!message.isEmpty() && key.isEmpty()))
            return message;

        String output = "";
        if (operation == 1) {
            output = encode(message, key);
        } else if (operation == 2) {
            output = decode(message, key);
        } else
            output = "-1";

        return output;
    }

    private static String encode(String message, String key) {
        StringBuilder result = new StringBuilder();
        char[] keys = key.toCharArray();
        int index = 0;
        for (int i = 0; i < keys.length; i++) {
            if (index < message.length()) {
                for (int j = 0; j < keys[i] - '0'; j++) {
                    result.append(message.charAt(index));
                }
                index++;
            }
        }
        String remainingMessage = message.substring(index);
        result.append(remainingMessage);
        return result.toString();
    }

    private static String decode(String message, String key) {
        StringBuilder result = new StringBuilder();
        char[] keys = key.toCharArray();
        int index = 0;
        for (int i = 0; i < keys.length; i++) {
            if (index < message.length()) {
                int j = 1;
                while (j + index < message.length() && message.charAt(j + index) == message.charAt(index)) {
                    j++;
                }
                if (j == keys[i] - '0') {
                    result.append(message.charAt(index));
                }
                index += j;
            }
        }
        String remainingMessage = message.substring(index);
        result.append(remainingMessage);
        return result.toString();
    }
}