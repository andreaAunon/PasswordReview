package es.babel.util;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private boolean isInSession;
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
