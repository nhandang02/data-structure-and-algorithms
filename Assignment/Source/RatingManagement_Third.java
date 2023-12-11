import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RatingManagement_Third {
    private ArrayList<Rating> ratings;
    private ArrayList<Movie> movies;
    private ArrayList<User> users;

    // @Requirement 1
    public RatingManagement_Third(String moviePath, String ratingPath, String userPath) {
        this.movies = loadMovies(moviePath);
        this.users = loadUsers(userPath);
        this.ratings = loadEdgeList(ratingPath);
    }

    private ArrayList<Rating> loadEdgeList(String ratingPath) {
        
        ArrayList<Rating> ratings = new ArrayList<>();
        try {
            File ratingFile = new File(ratingPath);
            Scanner sc = new Scanner(ratingFile);
            sc.nextLine(); // skip header
            
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
            sc.nextLine(); // skip header
            
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
                }
                else {
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
            sc.nextLine(); // skip header

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
        HashMap<Integer, Movie> movieMap = new HashMap<>();
        HashSet<Integer> userRatedMovies = new HashSet<>();
        ArrayList<Movie> moviesByNameAndMatchRating = new ArrayList<>();
    
        for (Movie m : movies) {
            movieMap.put(m.getId(), m);
        }
    
        for (Rating r : ratings) {
            if (r.getUserId() == userId && r.getRating() >= rating) {
                userRatedMovies.add(r.getMovieId());
            }
        }
    
        for (int movieId : userRatedMovies) {
            if (movieMap.containsKey(movieId)) {
                moviesByNameAndMatchRating.add(movieMap.get(movieId));
            }
        }
    
        moviesByNameAndMatchRating.sort(Comparator.comparing(Movie::getName));
        return moviesByNameAndMatchRating;
    }

    // Requirement 3
    public ArrayList<User> findUsersHavingSameRatingWithUser(int userId, int movieId) {
    HashMap<Integer, Integer> userRatings = new HashMap<>();
    for (Rating r : ratings) {
        if (r.getMovieId() == movieId) {
            userRatings.put(r.getUserId(), r.getRating());
        }
    }

    ArrayList<User> usersHavingSameRatingWithUser = new ArrayList<>();
    int ratingOfUserId = userRatings.getOrDefault(userId, -1);

    for (Map.Entry<Integer, Integer> entry : userRatings.entrySet()) {
        if (entry.getKey() != (userId) && entry.getValue() == (ratingOfUserId)) {
            for (User u : users) {
                if (u.getId() == entry.getKey()) {
                    usersHavingSameRatingWithUser.add(u);
                    break;
                }
            }
        }
    }

    usersHavingSameRatingWithUser.sort(Comparator.comparing(User::getId));

    return usersHavingSameRatingWithUser;
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
        HashSet<Integer> userIdsMatchingCriteria = new HashSet<>();
        HashSet<Integer> movieIdsMatchingRating = new HashSet<>();
        HashSet<Integer> finalMovieIds = new HashSet<>();
        ArrayList<String> movieNames = new ArrayList<>();
    
        for (User u : users) {
            if (u.getOccupation().equals(occupation) && u.getGender().equals(gender)) {
                userIdsMatchingCriteria.add(u.getId());
            }
        }
    
        for (Rating r : ratings) {
            if (userIdsMatchingCriteria.contains(r.getUserId()) && r.getRating() == rating) {
                movieIdsMatchingRating.add(r.getMovieId());
            }
        }
    
        for (Rating r : ratings) {
            if (movieIdsMatchingRating.contains(r.getMovieId()) && userIdsMatchingCriteria.contains(r.getUserId())) {
                finalMovieIds.add(r.getMovieId());
            }
        }
    
        for (int movieId : finalMovieIds) {
            for (Movie m : movies) {
                if (m.getId() == movieId) {
                    movieNames.add(m.getName());
                    break;
                }
            }
        }
    
        Collections.sort(movieNames);
        return new ArrayList<>(movieNames.subList(0, Math.min(movieNames.size(), k)));
    }
    

    // @Requirement 6
    public ArrayList<String> findMoviesByOccupationAndLessThanRating(String occupation, int k, int rating) {
        HashSet<Integer> userIdsMatchingCriteria = new HashSet<>();
        HashSet<Integer> movieIdsMatchingRating = new HashSet<>();
        HashSet<Integer> finalMovieIds = new HashSet<>();
        ArrayList<String> movieNames = new ArrayList<>();
    
        for (User u : users) {
            if (u.getOccupation().equals(occupation)) {
                userIdsMatchingCriteria.add(u.getId());
            }
        }
    
        for (Rating r : ratings) {
            if (userIdsMatchingCriteria.contains(r.getUserId()) && r.getRating() < rating) {
                movieIdsMatchingRating.add(r.getMovieId());
            }
        }
    
        for (Rating r : ratings) {
            if (movieIdsMatchingRating.contains(r.getMovieId()) && userIdsMatchingCriteria.contains(r.getUserId())) {
                finalMovieIds.add(r.getMovieId());
            }
        }
    
        for (int movieId : finalMovieIds) {
            for (Movie m : movies) {
                if (m.getId() == movieId) {
                    movieNames.add(m.getName());
                    break;
                }
            }
        }
    
        Collections.sort(movieNames);
        return new ArrayList<>(movieNames.subList(0, Math.min(movieNames.size(), k)));
    }
    

    // @Requirement 7
    public ArrayList<String> findMoviesMatchLatestMovieOf(int userId, int rating, int k) {
        /* code here */
        ArrayList<String> movieNames = new ArrayList<>();

        String genderOfUserId = "";
        for (User u : users) { 
            if (u.getId() == userId) {
                genderOfUserId = u.getGender();
            }
        }

        Rating latestRating = null;
        for (Rating r : ratings) {
            if (r.getUserId() == userId && r.getRating() >= rating) {
                if (latestRating == null || latestRating.getTimestamp() < r.getTimestamp()) {
                    latestRating = r;
                }
            }
        }

        ArrayList<String> movieGenresOfLatestRating = new ArrayList<>();
        for (Movie m : movies) {
            if (m.getId() == latestRating.getMovieId()) {
                movieGenresOfLatestRating = m.getGenres();
                break;
            }
        }

        ArrayList<User> userMatchRequest = new ArrayList<>();
        for (Rating r : ratings) {
            if (r.getUserId() == userId && r.getRating() >= rating) {
                for (User u : users) {
                    if (u.getGender().equals(genderOfUserId)) {
                        userMatchRequest.add(u);
                        break;
                    }
                }
            }
        }
    
        for (User u : userMatchRequest) {
            for (Movie m : movies) {
                for (String genre : m.getGenres()) {
                    if (movieGenresOfLatestRating.contains(genre)) {
                        movieNames.add(m.getName());
                    }
                }
            }
        }

        Set<String> setOfMovieNames = new HashSet<>(movieNames);
        ArrayList<String> StringOfMovieNames = new ArrayList<>(setOfMovieNames);
        
        Collections.sort(StringOfMovieNames);

        ArrayList<String> resultMovieNames = new ArrayList<>(StringOfMovieNames.subList(0, Math.min(StringOfMovieNames.size(), k)));

        return resultMovieNames;
    }
    
}