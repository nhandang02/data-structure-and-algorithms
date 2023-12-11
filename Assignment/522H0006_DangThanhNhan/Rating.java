public class Rating {

    private int userId;
    private int movieId; 
    private int rating;
    private long timestamps;

    public Rating(int userId, int movieId, int rating, long timestamps) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.timestamps = timestamps;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public long getTimestamp() {
        return timestamps;
    }

    public void setTimestamp(long timestamps) {
        this.timestamps = timestamps;
    }

    @Override
    public String toString() {
        return "Rating[" + userId + ", " + movieId + ", " + rating + ", " + timestamps + "]";
    }

}