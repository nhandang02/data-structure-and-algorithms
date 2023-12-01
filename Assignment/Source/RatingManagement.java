import java.io.File;
import java.io.FileNotFoundException;
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
       
        ArrayList<Movie> MoviesByNameAndMatchRating = new ArrayList<>();
    
        for (Rating r : ratings) {
            if (r.getUserId() == userId && r.getRating() >= rating) {
    
                for (Movie m : movies) { 
                    if (m.getId() == r.getMovieId()) {
                        MoviesByNameAndMatchRating.add(m);
                        break;
                    }
                }
            }
        }
        
        Collections.sort(MoviesByNameAndMatchRating, new Comparator<Movie>() {
            @Override 
            public int compare(Movie m1, Movie m2) {
                return m1.getName().compareTo(m2.getName()); 
            }
        });

        return MoviesByNameAndMatchRating; 
    }

    // Requirement 3
    public ArrayList<User> findUsersHavingSameRatingWithUser(int userId, int movieId) {
       
        ArrayList<User> UsersHavingSameRatingWithUser = new ArrayList<>();
        int ratingOfUserId = -1;

        for (Rating r : ratings) {
            if (r.getUserId() == userId && r.getMovieId() == movieId) {
                ratingOfUserId = r.getRating();
                break;
            }
        }
        
        for (Rating r : ratings) {
            if (r.getMovieId() == movieId && r.getRating() == ratingOfUserId && r.getUserId() != userId) {
            
                for (User u : users) {
                    if (u.getId() == r.getUserId()) {
                        UsersHavingSameRatingWithUser.add(u);
                        break;
                    }
                }
            }
        }
        
        return UsersHavingSameRatingWithUser; 
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
    
        Collections.sort(movieNames, new Comparator<String>() {
            @Override 
            public int compare(String m1, String m2) {
                return m1.compareTo(m2); 
            }
        });
    
        return movieNames; 
    }

    // @Requirement 5
    public ArrayList<String> findMoviesMatchOccupationAndGender(String occupation, String gender, int k, int rating) {
        
        ArrayList<String> movieNames = new ArrayList<>();
        ArrayList<User> userMatchOccupationAndGender = new ArrayList<>();
        ArrayList<Rating> ratingOfUserMatchOccupationAndGender = new ArrayList<>();
        
        for(User u : users){
            if(u.getOccupation().equals(occupation) && u.getGender().equals(gender)){
                userMatchOccupationAndGender.add(u);
            }
        }

        for(Rating r : ratings){
            for(User u : userMatchOccupationAndGender){
                if(r.getUserId() == u.getId() && r.getRating() == rating){
                    ratingOfUserMatchOccupationAndGender.add(r);
                }
            }
        }

        for(Movie m : movies){
            for(Rating r : ratingOfUserMatchOccupationAndGender){
                if(m.getId() == r.getMovieId()){
                    movieNames.add(m.getName());
                }
            }
        }
        
        Set<String> setOfMovieNames = new HashSet<>(movieNames);
        ArrayList<String> StringOfMovieNames = new ArrayList<>(setOfMovieNames);
        
        Collections.sort(StringOfMovieNames, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        });

        ArrayList<String> resultMovieNames = new ArrayList<>(StringOfMovieNames.subList(0, Math.min(StringOfMovieNames.size(), k)));

        return resultMovieNames;
    }

    // @Requirement 6
    public ArrayList<String> findMoviesByOccupationAndLessThanRating(String occupation, int k, int rating) {
        /* code here */
        ArrayList<String> movieNames = new ArrayList<>();
        ArrayList<User> userMatchOccupation = new ArrayList<>();
        ArrayList<Rating> ratingOfUserMatchOccupation = new ArrayList<>();
        
        for(User u: users){
            if(u.getOccupation().equals(occupation)){
                userMatchOccupation.add(u);
            }
        }

        for(Rating r : ratings){
            for(User u : userMatchOccupation){
                if(r.getUserId() == u.getId() && r.getRating() < rating){
                    ratingOfUserMatchOccupation.add(r);
                }
            }
        }

        for(Movie m : movies){
            for(Rating r: ratingOfUserMatchOccupation){
                if(m.getId() == r.getMovieId()){
                    movieNames.add(m.getName());
                }
            }
        }
        
        Set<String> setOfMovieNames = new HashSet<>(movieNames);
        ArrayList<String> StringOfMovieNames = new ArrayList<>(setOfMovieNames);
        
        Collections.sort(StringOfMovieNames, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        });

        ArrayList<String> resultMovieNames = new ArrayList<>(StringOfMovieNames.subList(0, Math.min(StringOfMovieNames.size(), k)));

        return resultMovieNames;
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
        
        Collections.sort(StringOfMovieNames, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        });

        ArrayList<String> resultMovieNames = new ArrayList<>(StringOfMovieNames.subList(0, Math.min(StringOfMovieNames.size(), k)));

        return resultMovieNames;
    }
}