import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RatingManagement {
    private ArrayList<Rating> ratings;
    private ArrayList<Movie> movies;
    private ArrayList<User> users;

    // @Requirement 1
    public RatingManagement(String moviePath, String ratingPath, String userPath) {
        this.movies = loadMovies(moviePath);
        this.users = loadUsers(userPath);
        this.ratings = loadEdgeList(ratingPath);
    }

    private ArrayList<Rating> loadEdgeList(String ratingPath) {
        ArrayList<Rating> ratings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ratingPath))) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");

                int userId = Integer.parseInt(attributes[0]);
                int movieId = Integer.parseInt(attributes[1]);
                int rating = Integer.parseInt(attributes[2]);
                long timestamp = Long.parseLong(attributes[3]);

                Rating r = new Rating(userId, movieId, rating, timestamp);
                ratings.add(r);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ratings;
    }

    private ArrayList<Movie> loadMovies(String moviePath) {
        ArrayList<Movie> movies = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(moviePath))) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }

    private ArrayList<User> loadUsers(String userPath) {
        ArrayList<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(userPath))) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(",");

                int userId = Integer.parseInt(attributes[0]);
                String gender = attributes[1];
                int age = Integer.parseInt(attributes[2]);
                String occupation = attributes[3];
                String zipcode = attributes[4];

                User u = new User(userId, gender, age, occupation, zipcode);
                users.add(u);
            }
        } catch (IOException e) {
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
            Movie m = getMovieById(r.getMovieId());
            moviesByNameAndMatchRating.add(m);
        }

        moviesByNameAndMatchRating.sort(Comparator.comparing(Movie::getName));

        return moviesByNameAndMatchRating;
    }

    private Movie getMovieById(int movieId) {
        for (Movie movie : movies) {
            if (movie.getId() == movieId) {
                return movie;
            }
        }
        return null;
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
            User u = getUserById(r.getUserId());
            usersHavingSameRatingWithUserId.add(u);
        }

        return usersHavingSameRatingWithUserId;
    }

    private User getUserById(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
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
                Movie m = getMovieById(entry.getKey());
                movieNames.add(m.getName());
            }
        }

        movieNames.sort(String::compareTo);

        return movieNames;
    }

    // @Requirement 5
    public ArrayList<String> findMoviesMatchOccupationAndGender(String occupation, String gender, int k, int rating) {
        ArrayList<User> usersMatchOccupationAndGender = new ArrayList<>();
        ArrayList<Rating> ratingsMatchRequest = new ArrayList<>();
        ArrayList<String> movieNames = new ArrayList<>();

        for (User u : users) {
            if (u.getOccupation().equals(occupation) && u.getGender().equals(gender)) {
                usersMatchOccupationAndGender.add(u);
            }
        }

        for (Rating r : ratings) {
            for (User u : usersMatchOccupationAndGender) {
                if (r.getUserId() == u.getId() && r.getRating() == rating) {
                    ratingsMatchRequest.add(r);
                    break;
                }
            }
        }

        for (Rating r : ratingsMatchRequest) {
            Movie m = getMovieById(r.getMovieId());
            movieNames.add(m.getName());
        }

        return getDistinctSortedKMovieNames(movieNames, k);
    }

    private ArrayList<String> getDistinctSortedKMovieNames(ArrayList<String> movieNames, int k) {
        Set<String> setOfMovieNames = new HashSet<>(movieNames);
        ArrayList<String> stringMovieNames = new ArrayList<>(setOfMovieNames);

        stringMovieNames.sort(String::compareTo);

        return new ArrayList<>(stringMovieNames.subList(0, Math.min(stringMovieNames.size(), k)));
    }

    // @Requirement 6
    public ArrayList<String> findMoviesByOccupationAndLessThanRating(String occupation, int k, int rating) {
        ArrayList<User> usersMatchOccupation = new ArrayList<>();
        ArrayList<Rating> ratingsMatchRequest = new ArrayList<>();
        ArrayList<String> movieNames = new ArrayList<>();

        for (User u : users) {
            if (u.getOccupation().equals(occupation)) {
                usersMatchOccupation.add(u);
            }
        }

        for (Rating r : ratings) {
            for (User u : usersMatchOccupation) {
                if (r.getUserId() == u.getId() && r.getRating() < rating) {
                    ratingsMatchRequest.add(r);
                    break;
                }
            }
        }

        for (Rating r : ratingsMatchRequest) {
            Movie m = getMovieById(r.getMovieId());
            movieNames.add(m.getName());
        }

        return getDistinctSortedKMovieNames(movieNames, k);
    }

    // @Requirement 7
    public ArrayList<String> findMoviesMatchLatestMovieOf(int userId, int rating, int k) {
        ArrayList<String> movieNames = new ArrayList<>();
        ArrayList<Rating> userIdRatings = new ArrayList<>();
        int latestMovieId = -1;

        for (Rating r : ratings) {
            if (r.getUserId() == userId) {
                userIdRatings.add(r);
            }
        }
        userIdRatings.sort(Comparator.comparingLong(Rating::getTimestamp).reversed());
        latestMovieId = userIdRatings.get(0).getMovieId();
        Movie latestMovieOfUserId = getMovieById(latestMovieId);

        User user = getUserById(userId);
        String genderOfUserId = user.getGender();

        for (Movie m : movies) {
            if (m.getId() != latestMovieId && hasCommonGenre(m, latestMovieOfUserId)
                    && hasRatingGreaterThanOrEqualTo(m.getId(), rating)
                    && hasSameGender(genderOfUserId, m)) {
                movieNames.add(m.getName());
            }
        }

        return getDistinctSortedKMovieNames(movieNames, k);
    }

    private boolean hasCommonGenre(Movie movie, Movie latestMovieOfUserId) {
        for (String genre : movie.getGenres()) {
            if (latestMovieOfUserId.getGenres().contains(genre)) {
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

    private boolean hasSameGender(String genderOfUserId, Movie movie) {
        for (Rating r : ratings) {
            if (r.getMovieId() == movie.getId()) {
                User user = getUserById(r.getUserId());
                if (user != null && user.getGender().equals(genderOfUserId)) {
                    return true;
                }
            }
        }
        return false;
    }
}