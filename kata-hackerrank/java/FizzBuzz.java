package com.rizkyjayusman;

public class FizzBuzz {

    public static void main(String [] args) {
        if (args.length != 1) {return;}

        StringBuilder builder = new StringBuilder();
        for (int i=0; i <= Integer.parseInt(args[0]); i++) {
            boolean isFizz = (i % 3) == 0;
            boolean isBuzz = (i % 5) == 0;
            if (isFizz) {
                builder.append("Fizz");                
            }

            if(isBuzz) {
                builder.append("Buzz");
            } else if (!isFizz) {
                builder.append(i);
            }

            System.out.println(builder.toString());
            builder.setLength(0);
        }
    }
}