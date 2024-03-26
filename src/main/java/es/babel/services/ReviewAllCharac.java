package es.babel.services;

public class ReviewAllCharac implements IReviewMethodInterface{

    private IReviewMethodInterface review1;
    private IReviewMethodInterface review2;
    private IReviewMethodInterface review3;
    private IReviewMethodInterface review4;
    private IReviewMethodInterface review5;

    public ReviewAllCharac(IReviewMethodInterface review1, IReviewMethodInterface review2,
                           IReviewMethodInterface review3, IReviewMethodInterface review4,
                           IReviewMethodInterface review5){
        this.review1 = review1;
        this.review2 = review2;
        this.review3 = review3;
        this.review4 = review4;
        this.review5 = review5;
    }

    @Override
    public int review(String password) {
        if(review1.review(password) > 0 && review2.review(password) > 0 &&
                review3.review(password) > 0 && review4.review(password) > 0
                && review5.review(password) > 0){
            return 1;
        }

        return 0;
    }
}
