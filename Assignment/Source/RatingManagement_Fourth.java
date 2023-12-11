import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RatingManagement_Fourth {
    private ArrayList<Rating> ratings;
    private ArrayList<Movie> movies;
    private ArrayList<User> users;

    // @Requirement 1
    public RatingManagement_Fourth(String moviePath, String ratingPath, String userPath) {
        this.movies = loadMovies(moviePath);
        this.users = loadUsers(userPath);
        this.ratings = loadEdgeList(ratingPath);
    }

    private ArrayList<Rating> loadEdgeList(String ratingPath) {

        ArrayList<Rating> ratings = new ArrayList<>();
        try {
            File ratingFile = new File(ratingPath);
            Scanner sc = new Scanner(ratingFile);
            sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] attributes = line.split(",");

                int userId = Integer.parseInt(attributes[0]);
                int movieId = Integer.parseInt(attributes[1]);
                int rating = Integer.parseInt(attributes[2]);
                long timestamp = Long.parseLong(attributes[3]);

                Rating r = new Rating(userId, movieId, rating, timestamp);
                ratings.add(r);
            }

            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ratings;
    }

    private ArrayList<Movie> loadMovies(String moviePath) {

        ArrayList<Movie> movies = new ArrayList<>();
        try {
            File movieFile = new File(moviePath);
            Scanner sc = new Scanner(movieFile);
            sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] attributes = line.split(",");

                int movieId = Integer.parseInt(attributes[0]);
                String title = attributes[1];
                ArrayList<String> genres = new ArrayList<>();
                if (attributes[2].contains("-")) {
                    for (String genre : attributes[2].split("-")) {
                        genres.add(genre);
                    }
                } else {
                    genres.add(attributes[2]);
                }

                Movie m = new Movie(movieId, title, genres);
                movies.add(m);

            }

            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return movies;
    }

    private ArrayList<User> loadUsers(String userPath) {

        ArrayList<User> users = new ArrayList<>();
        try {
            File userFile = new File(userPath);
            Scanner sc = new Scanner(userFile);
            sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] attributes = line.split(",");

                int userId = Integer.parseInt(attributes[0]);
                String gender = attributes[1];
                int age = Integer.parseInt(attributes[2]);
                String occupation = attributes[3];
                String zipcode = attributes[4];

                User u = new User(userId, gender, age, occupation, zipcode);
                users.add(u);
            }

            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return users;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Rating> getRating() {
        return ratings;
    }

    // @Requirement 2
    public ArrayList<Movie> findMoviesByNameAndMatchRating(int userId, int rating) {

        ArrayList<Rating> ratingsMatchRequestOfUserId = new ArrayList<>();
        ArrayList<Movie> moviesByNameAndMatchRating = new ArrayList<>();

        for (Rating r : ratings) {
            if (r.getUserId() == userId && r.getRating() >= rating) {
                ratingsMatchRequestOfUserId.add(r);
            }
        }

        for (Rating r : ratingsMatchRequestOfUserId) {
            for (Movie m : movies) {
                if (m.getId() == r.getMovieId()) {
                    moviesByNameAndMatchRating.add(m);
                    break;
                }
            }
        }

        moviesByNameAndMatchRating.sort(Comparator.comparing(Movie::getName));

        return moviesByNameAndMatchRating;
    }

    // Requirement 3
    public ArrayList<User> findUsersHavingSameRatingWithUser(int userId, int movieId) {

        ArrayList<User> usersHavingSameRatingWithUserId = new ArrayList<>();
        ArrayList<Rating> ratingsHavingSameRatingWithUserId = new ArrayList<>();
        int ratingOfUserId = -1;

        for (Rating r : ratings) {
            if (r.getUserId() == userId && r.getMovieId() == movieId) {
                ratingOfUserId = r.getRating();
                break;
            }
        }

        for (Rating r : ratings) {
            if (r.getMovieId() == movieId && r.getRating() == ratingOfUserId && r.getUserId() != userId) {
                ratingsHavingSameRatingWithUserId.add(r);
            }
        }

        for (Rating r : ratingsHavingSameRatingWithUserId) {
            for (User u : users) {
                if (u.getId() == r.getUserId()) {
                    usersHavingSameRatingWithUserId.add(u);
                    break;
                }
            }
        }

        return usersHavingSameRatingWithUserId;
    }

    // Requirement 4
    public ArrayList<String> findMoviesNameHavingSameReputation() {

        Map<Integer, Integer> movieRatingCount = new HashMap<>();
        ArrayList<String> movieNames = new ArrayList<>();

        for (Rating r : ratings) {
            if (r.getRating() > 3) {
                int count = movieRatingCount.getOrDefault(r.getMovieId(), 0);
                movieRatingCount.put(r.getMovieId(), count + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : movieRatingCount.entrySet()) {
            if (entry.getValue() >= 2) {
                for (Movie m : movies) {
                    if (m.getId() == entry.getKey()) {
                        movieNames.add(m.getName());
                        break;
                    }
                }
            }
        }

        movieNames.sort(String::compareTo);

        return movieNames;
    }

    // @Requirement 5
    public ArrayList<String> findMoviesMatchOccupationAndGender(String occupation, String gender, int k, int rating) {

        ArrayList<String> movieNames = new ArrayList<>();
        ArrayList<User> userMatchOccupationAndGender = new ArrayList<>();
        ArrayList<Rating> ratingsMatchRequest = new ArrayList<>();

        for (User u : users) {
            if (u.getOccupation().equals(occupation) && u.getGender().equals(gender)) {
                userMatchOccupationAndGender.add(u);
            }
        }

        for (Rating r : ratings) {
            for (User u : userMatchOccupationAndGender) {
                if (r.getUserId() == u.getId() && r.getRating() == rating) {
                    ratingsMatchRequest.add(r);
                    break;
                }
            }
        }

        for (Rating r : ratingsMatchRequest) {
            for (Movie m : movies) {
                if (m.getId() == r.getMovieId()) {
                    movieNames.add(m.getName());
                    break;
                }
            }
        }

        Set<String> setOfMovieNames = new HashSet<>(movieNames);
        ArrayList<String> StringOfMovieNames = new ArrayList<>(setOfMovieNames);

        StringOfMovieNames.sort(String::compareTo);

        ArrayList<String> resultMovieNames = new ArrayList<>(
                StringOfMovieNames.subList(0, Math.min(StringOfMovieNames.size(), k)));

        return resultMovieNames;
    }

    // @Requirement 6
    public ArrayList<String> findMoviesByOccupationAndLessThanRating(String occupation, int k, int rating) {

        ArrayList<User> usersMatchOccupation = new ArrayList<>();
        ArrayList<Rating> ratingOfUsersMatchOccupation = new ArrayList<>();
        ArrayList<String> movieNames = new ArrayList<>();

        for (User u : users) {
            if (u.getOccupation().equals(occupation)) {
                usersMatchOccupation.add(u);
            }
        }

        for (Rating r : ratings) {
            for (User u : usersMatchOccupation) {
                if (r.getUserId() == u.getId() && r.getRating() < rating) {
                    ratingOfUsersMatchOccupation.add(r);
                    break;
                }
            }
        }

        for (Rating r : ratingOfUsersMatchOccupation) {
            for (Movie m : movies) {
                if (m.getId() == r.getMovieId()) {
                    movieNames.add(m.getName());
                    break;
                }
            }
        }

        Set<String> setOfMovieNames = new HashSet<>(movieNames);
        ArrayList<String> StringOfMovieNames = new ArrayList<>(setOfMovieNames);

        StringOfMovieNames.sort(String::compareTo);

        ArrayList<String> resultMovieNames = new ArrayList<>(
                StringOfMovieNames.subList(0, Math.min(StringOfMovieNames.size(), k)));

        return resultMovieNames;
    }

    // @Requirement 7
//    public ArrayList<String> findMoviesMatchLatestMovieOf(int userId, int rating, int k) {
//
//        String genderOfUserId = "";
//        Rating latestRating = null;
//        ArrayList<String> movieGenresOfLatestRating = new ArrayList<>();
//        ArrayList<User> usersSameGenderWithUserId = new ArrayList<>();
//        ArrayList<Rating> ratingsMachAllRequire = new ArrayList<>();
//        ArrayList<Movie> moviesMatchGenre = new ArrayList<>();
//        ArrayList<String> movieNames = new ArrayList<>();
//
//        for (User u : users) {
//            if (u.getId() == userId) {
//                genderOfUserId = u.getGender();
//                break;
//            }
//        }
//
//        for (Rating r : ratings) {
//            if (r.getUserId() == userId && r.getRating() >= rating) {
//                if (latestRating == null || latestRating.getTimestamp() < r.getTimestamp()) {
//                    latestRating = r;
//                }
//            }
//        }
//
//        for (Movie m : movies) {
//            if (m.getId() == latestRating.getMovieId()) {
//                movieGenresOfLatestRating = m.getGenres();
//                break;
//            }
//        }
//
//        for (User u : users) {
//            if (u.getGender().equals(genderOfUserId)) {
//                usersSameGenderWithUserId.add(u);
//            }
//        }
//
//        for (Rating r : ratings) {
//            if (r.getRating() >= rating) {
//                for (User u : usersSameGenderWithUserId) {
//                    if (r.getUserId() == u.getId()) {
//                        ratingsMachAllRequire.add(r);
//                        break;
//                    }
//                }
//            }
//        }
//
//        for (Movie m : movies) {
//            for (String genre : m.getGenres()) {
//                if (movieGenresOfLatestRating.contains(genre)) {
//                    moviesMatchGenre.add(m);
//                    break;
//                }
//            }
//        }
//
//        for (Rating r : ratingsMachAllRequire) {
//            for (Movie m : moviesMatchGenre) {
//                if (r.getMovieId() == m.getId()) {
//                    movieNames.add(m.getName());
//                    break;
//                }
//            }
//        }
//
//        Set<String> setOfMovieNames = new HashSet<>(movieNames);
//        ArrayList<String> StringOfMovieNames = new ArrayList<>(setOfMovieNames);
//
//        StringOfMovieNames.sort(String::compareTo);
//
//        ArrayList<String> resultMovieNames = new ArrayList<>(
//                StringOfMovieNames.subList(0, Math.min(StringOfMovieNames.size(), k)));
//
//        return resultMovieNames;
//    }

//    public ArrayList<String> findMoviesMatchLatestMovieOf(int userId, int rating, int k) {
//        ArrayList<String> result = new ArrayList<>();
//        ArrayList<Rating> userRatings = new ArrayList<>();
//        int latestMovieId = -1;
//
//        for (Rating r : ratings) {
//            if (r.getUserId() == userId) {
//                userRatings.add(r);
//            }
//        }
//
//        userRatings.sort(Comparator.comparingLong(Rating::getTimestamp).reversed());
//
//        if (userRatings.isEmpty()) {
//            return new ArrayList<>();
//        }
//
//        latestMovieId = userRatings.get(0).getMovieId();
//
//        for (Movie movie : movies) {
//            if (movie.getId() != latestMovieId) {
//                boolean hasCommonGenre = false;
//                for (String genre : movie.getGenres()) {
//                    for (Movie latestMovie : movies) {
//                        if (latestMovie.getId() == latestMovieId && latestMovie.getGenres().contains(genre)) {
//                            for (Rating r : ratings) {
//                                if (r.getMovieId() == movie.getId() && r.getRating() >= rating) {
//                                    result.add(movie.getName());
//                                    break;
//                                }
//                            }
//                            hasCommonGenre = true;
//                            break;
//                        }
//                    }
//                    if (hasCommonGenre) {
//                        break;
//                    }
//                }
//            }
//        }
//
//        Collections.sort(result);
//        return new ArrayList<>(result.subList(0, Math.min(k, result.size())));
//    }

    public ArrayList<String> findMoviesMatchLatestMovieOf(int userId, int rating, int k) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Rating> userRatings = new ArrayList<>();
        int latestMovieId = -1;

        for (Rating r : ratings) {
            if (r.getUserId() == userId) {
                userRatings.add(r);
            }
        }

        userRatings.sort(Comparator.comparingLong(Rating::getTimestamp).reversed());

        if (userRatings.isEmpty()) {
            return new ArrayList<>();
        }

        latestMovieId = userRatings.get(0).getMovieId();

        Movie latestMovie = getMovieById(latestMovieId);

        for (Movie movie : movies) {
            if (movie.getId() != latestMovieId && hasCommonGenre(movie, latestMovie) && hasRatingGreaterThanOrEqualTo(movie.getId(), rating)) {
                result.add(movie.getName());
            }
        }

        Collections.sort(result);
        return new ArrayList<>(result.subList(0, Math.min(k, result.size())));
    }

    private boolean hasCommonGenre(Movie movie, Movie latestMovie) {
        for (String genre : movie.getGenres()) {
            if (latestMovie.getGenres().contains(genre)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasRatingGreaterThanOrEqualTo(int movieId, int rating) {
        for (Rating r : ratings) {
            if (r.getMovieId() == movieId && r.getRating() >= rating) {
                return true;
            }
        }
        return false;
    }

    private Movie getMovieById(int movieId) {
        for (Movie movie : movies) {
            if (movie.getId() == movieId) {
                return movie;
            }
        }
        return null;
    }
}