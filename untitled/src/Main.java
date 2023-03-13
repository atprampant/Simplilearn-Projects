import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<MyFile> files=new HashSet<>();
        System.out.println("Hello world!");
            String df;                                       // df- display files
            File f = new File("E://Oreshura");

            for(String ef:f) {
                System.out.println(ef);
            }

        }
    }

