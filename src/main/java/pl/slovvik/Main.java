package pl.slovvik;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
//        Arrays.stream(args).forEach(System.out::println);
        App app = new App();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println(app.readFileName(reader));
        System.out.println(app.readStuff());
    }
}
