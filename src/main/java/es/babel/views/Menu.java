package es.babel.views;

import es.babel.controllers.Audit;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private Audit audit;

    public Menu(){
        this.scanner = new Scanner(System.in);
    }

    public void initMenu(){
        System.out.printf("Por favor introduzca contraseña: ");
        String password = scanner.nextLine();
        String nivel = audit(password);
        comprobateUmbral(nivel);
    }

    public void readFile(String directoryPath){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        String formattedDate = dateFormat.format(currentDate);

        String fileName = "password_" + formattedDate + ".txt";
        String filePath = directoryPath + File.separator + fileName;

        try (FileWriter writer = new FileWriter(filePath)) {
            String password = "Ab*1";
            String nivel = audit(password);
            writer.write(password + " - " + nivel);
        } catch (IOException e) {
            System.err.println("Error al generar el archivo: " + e.getMessage());
        }
    }

    private void comprobateUmbral(String nivel){
        if(audit.isLessThanUmbral()){
            Scanner myObj = new Scanner(System.in);
            System.out.printf("Su contraseña tiene baja seguridad, ¿desea saberla aún así? (S/N): ");

            String option = myObj.nextLine();
            if(option.equals("S") || option.equals("s")){
                System.out.printf("La puntuación de su contraseña es: " + nivel);
            } else if(option.equals("N") || option.equals("n")){
                System.out.println("Puede volver a ejecutar el programa si lo desea saber.");
            } else{
                System.out.println("Error, por favor introduzca (S/N).");
            }

        } else {
            System.out.println("La puntuación de su contraseña es: " + nivel);
        }
    }

    private String audit(String password){
        this.audit = new Audit();
        return audit.auditPassword(password);
    }

}
