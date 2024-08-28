public class Rating {
    private int userId;
    private int movieId;
    private int ratingPoint;
    private long timeRating;
    
    public Rating(int userId, int movieId, int ratingPoint, long timeRating) {
        this.userId = userId;
        this.movieId = movieId;
        this.ratingPoint = ratingPoint;
        this.timeRating = timeRating;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(int ratingPoint) {
        this.ratingPoint = ratingPoint;
    }

    public long getTimeRating() {
        return timeRating;
    }

    public void setTimeRating(long timeRating) {
        this.timeRating = timeRating;
    }

    @Override
    public String toString() {
        return String.format("User[%d, %d, %d, %ld]", userId, movieId, ratingPoint, timeRating);
    }
    
}
