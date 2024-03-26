package es.babel.services;

public class ReviewLongitud implements IReviewMethodInterface{


    /**
     * Comprueba la longitud de la contraseña.
     *
     * @return
     * [0,6] devuelve 0
     * [7,8] devuelve 1
     * [8,12] devuelve 2
     * > 12 devuelve 3
     */
    @Override
    public int review(String password) {
        int longitud = password.length();

        if(longitud >= 0 && longitud <= 6){
            return 0;
        } else if(longitud == 7 || longitud == 8) {
            return 1;
        } else if(longitud >= 9 && longitud <= 12){
            return 2;
        } else {
            return 3;
        }
    }
}
