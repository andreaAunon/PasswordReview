package es.babel.services;

public class Puntuacion implements IPuntuacionInterface{

    // Estaría mejor si se le pasa usando una lista las reviews pero
    // sin Springboot en este caso no puedo hacerlo óptimamente
    @Override
    public int getPuntuacion(String password) {
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
