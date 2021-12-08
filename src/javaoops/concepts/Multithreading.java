package javaoops.concepts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Multithreading extends Thread {
    public static void main(String[] args) {
        Multithreading t1 = new Multithreading();
        Multithreading t2 = new Multithreading();

        t1.start();
        t1.setName("ReadFile1");
        t2.start();
        t2.setName("ReadFile2");
    }

    public void run() {
        try {
            System.out.println("Thread Name is :- " + Thread.currentThread().getName());
            if (Thread.currentThread().getName().equals("ReadFile1")) {
                readFromFile("file1.txt");
            } else if (Thread.currentThread().getName().equals("ReadFile2")) {
                readFromFile("file2.txt");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(String fileName) throws IOException {
        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader("resources/" + fileName));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
