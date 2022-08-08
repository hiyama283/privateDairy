package com.github.distriful5061.privatedairy.privatedairy;

import java.util.Random;

public class Password {
    private final char[] CHARACTER_LIST = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z',
            ',','.','/','\\',';',':',']','[','@','^','-',
            '<','>','?','_','}','{','+','*','`','|','~','=',
            '!','\"','#','$','%','&','\'','(',')'};

    public static long defaultRandomSeed = 5110552820496832507L;
    public static long maxLongNumber = 9223372036854775807L;
    public static int maxIntegerNumber = 2147483647;
    

    public long generateMultipliedRandomLong(int count) {
        if (count < 1) {
            return defaultRandomSeed;
        }
        
        long next_seed = defaultRandomSeed;

        for (int i = 0; i < count; i++) {
            Random random = new Random(next_seed);
            next_seed = random.nextLong(maxLongNumber);
        }

        return next_seed;
    }

    public long generateMultipliedRandomLong(int count, long randomSeed) {
        if (count < 1) {
            return randomSeed;
        }

        long next_seed = randomSeed;

        for (int i = 0; i < count; i++) {
            Random random = new Random(next_seed);
            next_seed = random.nextLong(maxLongNumber);
        }

        return next_seed;
    }

    public String getRandomString(int length, long randomSeed) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            stringBuilder.append(CHARACTER_LIST[getRandomInt(CHARACTER_LIST.length, randomSeed)]);
        }

        return stringBuilder.toString();
    }

    public String getRandomString(int length) {
        return getRandomString(length, System.currentTimeMillis());
    }

    public String getRandomString() {
        return getRandomString(16);
    }

    public char[] getRandomCharList(int count, long randomSeed) {
        return getRandomString(count, randomSeed).toCharArray();
    }

    public char[] getRandomCharList(int count) {
        return getRandomString(count).toCharArray();
    }

    public char[] getRandomCharList() {
        return getRandomString().toCharArray();
    }

    public char[] shuffle(char[] content, long randomSeed) {
        char[] chars = content.clone();

        Random random = new Random(randomSeed);
        for (int i = chars.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);

            char tmp = chars[index];
            chars[index] = chars[i];
            chars[i] = tmp;
        }

        return chars;
    }

    public char[] shuffle(char[] content) {
        return shuffle(content, System.currentTimeMillis());
    }

    public String shuffle(String content, long randomSeed) {
        return new String(shuffle(content.toCharArray(), randomSeed));
    }

    public String shuffle(String content) {
        return shuffle(content, System.currentTimeMillis());
    }

    public char[] cutList(char[] list, int count) {
        char[] result = new char[count];

        if (list.length < count) {
            return result;
        }

        System.arraycopy(list, 0, result, 0, count);

        return result;
    }

    public char[] passwordPadding(char[] plain_password, long randomSeed, int defaultPasswordLength, int cutLength) {
        StringBuilder usePassword = new StringBuilder(new String(plain_password));

        if (defaultPasswordLength < 1) {
            defaultPasswordLength = 16;
        }

        if (usePassword.length() < 2) {
            usePassword = new StringBuilder(getRandomString(defaultPasswordLength));
        }

        if (usePassword.length() < cutLength) {
            usePassword = new StringBuilder(usePassword.substring(50));
        }

        while (usePassword.length() <= cutLength) {
            usePassword.append(getRandomString(getRandomInt(20, randomSeed)).repeat(getRandomInt(300, randomSeed)));
        }

        for (int i = 0; i < getRandomInt(5000, randomSeed) + 1; i++) {
            usePassword = new StringBuilder(shuffle(usePassword.toString()).substring(cutLength).repeat(10));
        }

        return cutList(usePassword.toString().toCharArray(), cutLength);
    }

    public String passwordPadding(String plain_password, long randomSeed, int cutLength) {
        return new String(passwordPadding(plain_password.toCharArray(), randomSeed, 16, cutLength));
    }

    public String passwordPadding(String plain_password, long randomSeed) {
        return new String(passwordPadding(plain_password.toCharArray(), randomSeed, 16,  128));
    }

    public int getRandomMaxInt(long randomSeed) {
        return new Random(randomSeed).nextInt(maxIntegerNumber) + 1;
    }

    public int getRandomMaxInt() {
        return getRandomMaxInt(System.currentTimeMillis());
    }

    public int getRandomInt(int max, long randomSeed) {
        return new Random(randomSeed).nextInt(max);
    }

    public int getRandomInt(int max) {
        return getRandomInt(max, System.currentTimeMillis());
    }

    public long getRandomMaxLong(long randomSeed) {
        return new Random(randomSeed).nextLong(maxLongNumber) + 1;
    }

    public long getRandomMaxLong() {
        return getRandomMaxLong(System.currentTimeMillis());
    }

    public long getRandomLong(long max, long randomSeed) {  
        return new Random(randomSeed).nextLong(max);
    }

    public long getRandomLong(long max) {
        return getRandomLong(max, System.currentTimeMillis());
    }
}
