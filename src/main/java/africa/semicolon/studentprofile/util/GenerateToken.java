package africa.semicolon.studentprofile.util;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class GenerateToken {

    SecureRandom secureRandom = new SecureRandom();

    public static void main(String[] args) {
        GenerateToken token = new GenerateToken();
        token.generateTokenOfFourNumber();
    }

    public void generateTokenOfFourNumber() {
        int count = 1;
        Set<String> value= new HashSet<>();
        int number=0;
        int number2=0;
        for (int i = 0; i <= 2; i++) {

          number = secureRandom.nextInt(1, 100);
          number2= secureRandom.nextInt(1,100);
        }
         value= Collections.singleton(String.valueOf(number + "" + number2));

        System.out.print(value);
    }


}
