package africa.semicolon.studentprofile.util;

import java.security.SecureRandom;
import java.util.Arrays;
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
        int[] tokenNumber = new int[3];
        StringBuilder string = new StringBuilder();
        for (int i = 1; i <= tokenNumber.length-1; i++) {
          tokenNumber[i]=  secureRandom.nextInt(1, 100);
            string.append(tokenNumber[i]);

        }
        System.out.println(string);
    }
}

