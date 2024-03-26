package es.babel.services;

public class ReviewMayusAndMinus implements IReviewMethodInterface{

    private IReviewMethodInterface review1;
    private IReviewMethodInterface review2;

    public ReviewMayusAndMinus(IReviewMethodInterface review1, IReviewMethodInterface review2){
        this.review1 = review1;
        this.review2 = review2;
    }

    @Override
    public int review(String password) {
        if(review1.review(password) > 0 && review2.review(password) > 0){
            return 1;
        }

        return 0;
    }
}
