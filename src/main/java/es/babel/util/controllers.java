package es.babel.util;

import es.babel.services.*;

public class controllers {

    private static final int UMBRAL = 8;
    private boolean isLessThanUmbral;

    // Estaría mejor si se le pasa usando una lista las reviews pero
    // sin Springboot en este caso no puedo hacerlo óptimamente
    private IPuntuacionInterface puntuacionInterface;


    public controllers(){
        this.isLessThanUmbral = false;
        this.puntuacionInterface = new Puntuacion();
    }

    public String auditPassword(String password) {
        int puntuacion = puntuacionInterface.getPuntuacion(password);
        comprobateUmbral(puntuacion);

        if (puntuacion > 0 && puntuacion <= 2) {
            return "Muy debil";
        } else if (puntuacion > 2 && puntuacion <= 5) {
            return "Debil";
        } else if (puntuacion == 6 || puntuacion == 7) {
            return "Moderada";
        } else if (puntuacion == 8 || puntuacion == 9) {
            return "Fuerte";
        } else if(puntuacion == 10){
            return "Muy fuerte";
        } else {
            return "Hay alguna contraseña no valida";
        }
    }

    public boolean isLessThanUmbral() {
        return isLessThanUmbral;
    }

    private void comprobateUmbral(int puntuacion){
        if(puntuacion < UMBRAL){
            this.isLessThanUmbral = true;
        }
    }
}
