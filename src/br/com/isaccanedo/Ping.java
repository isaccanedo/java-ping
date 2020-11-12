package br.com.isaccanedo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Isac Canedo
 */

public class Ping {

    public static void main(String[] args) {

        ProcessBuilder processBuilder = new ProcessBuilder();
        // Windows
       processBuilder.command("cmd.exe","/c", "ping -n 4 192.168.99.1");

       try {
           Process process = processBuilder.start();
           BufferedReader reader =
                   new BufferedReader(new InputStreamReader(process.getInputStream()));
           String line;
           while ((line = reader.readLine())!= null) {
               System.out.println(line);
           }
           int exitCode = process.waitFor();
           System.out.println("\nExited with error code: " + exitCode);

       } catch (IOException e) {
           e.printStackTrace();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

    }

}
