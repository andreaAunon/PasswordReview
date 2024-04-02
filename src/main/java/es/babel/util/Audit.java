package es.babel.util;

import es.babel.services.*;

public class Audit {

    private static final int UMBRAL = 8;
    private boolean isLessThanUmbral;


    public Audit(){
        this.isLessThanUmbral = false;
    }

    public String auditPassword(String password){
        if(password.equals("")){
            return "Contraseña vacia";
        }

        int puntuacion = review(password);
        comprobateUmbral(puntuacion);

        if(puntuacion > 0 && puntuacion <= 2){
            return "Muy debil";
        } else if(puntuacion > 2 && puntuacion <= 5) {
            return "Debil";
        } else if(puntuacion == 6 || puntuacion == 7) {
            return "Moderada";
        } else if(puntuacion == 8 || puntuacion == 9) {
            return "Fuerte";
        } else {
            return "Muy fuerte";
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

    private int review(String password){
        ReviewGeneral reviewMethod = new ReviewGeneral();

        IReviewMethodInterface review1 = new ReviewLongitud();
        IReviewMethodInterface review2 = new ReviewMayus();
        IReviewMethodInterface review3 = new ReviewMinus();
        IReviewMethodInterface review4 = new ReviewNumbers();
        IReviewMethodInterface review5 = new ReviewSpecialCharac();

        reviewMethod.addReviewMethod(review1);
        reviewMethod.addReviewMethod(review2);
        reviewMethod.addReviewMethod(review3);
        reviewMethod.addReviewMethod(review4);
        reviewMethod.addReviewMethod(review5);

        reviewMethod.addReviewMethod(new ReviewMayusAndMinus(review2,review3));
        reviewMethod.addReviewMethod(new ReviewAllCharac(review1,review2,review3,review4,review5));

        return reviewMethod.review(password);
    }
}
