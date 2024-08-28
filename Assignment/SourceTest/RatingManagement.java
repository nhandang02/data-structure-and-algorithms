import java.io.*;
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
        ArrayList<Rating> edgeList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(ratingPath))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int userId = Integer.parseInt(parts[0]);
                int movieId = Integer.parseInt(parts[1]);
                int ratingPoint = Integer.parseInt(parts[2]);
                long timeRating = Long.parseLong(parts[3]);
                Rating rating = new Rating(userId, movieId, ratingPoint, timeRating);
                edgeList.add(rating);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return edgeList;
    }

    private ArrayList<Movie> loadMovies(String moviePath) {
        ArrayList<Movie> movieList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(moviePath))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                // Xử lý danh sách thể loại (genres)
                ArrayList<String> genres = new ArrayList<>();
                String[] genresArray = parts[2].split("-");
                genres.addAll(Arrays.asList(genresArray));

                Movie movie = new Movie(id, title, genres);
                movieList.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    private ArrayList<User> loadUsers(String userPath) {
        ArrayList<User> edgeList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(userPath))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int userId = Integer.parseInt(parts[0]);
                String gender = parts[1];
                int age = Integer.parseInt(parts[2]);
                String occupation = parts[3];
                String zipCode = parts[4];
                User user = new User(userId, gender, age, occupation, zipCode);
                edgeList.add(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return edgeList;
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
        ArrayList<Movie> listMovies = new ArrayList<>();
        for (Rating rater : ratings) {
            if (rater.getUserId() == userId && rater.getRatingPoint() >= rating) {
                for (Movie mo : movies) {
                    if (mo.getId() == rater.getMovieId()) {
                        listMovies.add(mo);
                    }
                }
            }
        }
        Collections.sort(listMovies, Comparator.comparing(Movie::getName));
        return listMovies;
    }

    // Requirement 3
    public ArrayList<User> findUsersHavingSameRatingWithUser(int userId, int movieId) {
        ArrayList<User> listUsers = new ArrayList<>();
        int rate = -1;
        for (Rating rater : ratings) {
            if (rater.getUserId() == userId && rater.getMovieId() == movieId) {
                rate = rater.getRatingPoint();
            }
        }

        for (Rating rater : ratings) {
            if (rater.getUserId() != userId && rater.getMovieId() == movieId && rater.getRatingPoint() == rate) {
                for (User us : users) {
                    if (us.getId() == rater.getUserId()) {
                        listUsers.add(us);
                    }
                }
            }
        }
        return listUsers;
    }

    // Requirement 4
    private int getIndexOfMovie(ArrayList<Movie> listMovie, int movieId) {
        int first = 0, last = listMovie.size() - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (listMovie.get(mid).getId() < movieId) {
                first = mid + 1;
            } else if (listMovie.get(mid).getId() == movieId) {
                return mid;
            } else {
                last = mid - 1;
            }
        }
        return -1;
    }

    public ArrayList<String> findMoviesNameHavingSameReputation() {
        ArrayList<String> nameList = new ArrayList<>();

        ArrayList<Movie> listMovie = new ArrayList<Movie>(movies);
        Collections.sort(listMovie, Comparator.comparing(Movie::getId));

        int[] indexList = new int[movies.size()];
        for (Rating rating : ratings) {
            if (rating.getRatingPoint() > 3) {
                indexList[getIndexOfMovie(listMovie, rating.getMovieId())]++;
            }
        }
        for (int i = 0; i < indexList.length; i++) {
            if (indexList[i] >= 2) {
                nameList.add(movies.get(i).getName());
            }
        }
        Collections.sort(nameList);
        return nameList;
    }

    // @Requirement 5
    // Check dieu kien cua user
    private boolean checkUserSuitable(ArrayList<User> listUser, int userId, String occupation, String gender) {
        User userStan = null;
        int first = 0, last = listUser.size() - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (listUser.get(mid).getId() < userId) {
                first = mid + 1;
            } else if (listUser.get(mid).getId() == userId) {
                userStan = users.get(mid);
                break;
            } else {
                last = mid - 1;
            }
        }
        if (userStan.getOccupation().equals(occupation) && userStan.getGender().equals(gender)) {
            return true;
        }
        return false;
    }

    // lay ra movie phu hop
    private String binarySearchMovie(ArrayList<Movie> listMovie, int movieId) {
        int first = 0, last = listMovie.size() - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (listMovie.get(mid).getId() < movieId) {
                first = mid + 1;
            } else if (listMovie.get(mid).getId() == movieId) {
                return listMovie.get(mid).getName();
            } else {
                last = mid - 1;
            }
        }
        return null;
    }

    public ArrayList<String> findMoviesMatchOccupationAndGender(String occupation, String gender, int k, int rating) {
        HashSet<String> setMovie = new HashSet<>();

        ArrayList<User> listUser = new ArrayList<User>(users);
        Collections.sort(listUser, Comparator.comparing(User::getId));

        ArrayList<Movie> listMovie = new ArrayList<Movie>(movies);
        Collections.sort(listMovie, Comparator.comparing(Movie::getId));

        for (Rating rater : ratings) {
            if (rater.getRatingPoint() == rating) {
                if (checkUserSuitable(listUser, rater.getUserId(), occupation, gender)) {
                    String movieName = binarySearchMovie(listMovie, rater.getMovieId());
                    setMovie.add(movieName);
                }
            }
        }

        ArrayList<String> list = new ArrayList<>(setMovie);
        Collections.sort(list);

        if (list.size() <= k) {
            return list;
        } else {
            ArrayList<String> listFinal = new ArrayList<>();
            for (int i = 0; i < k && i < listMovie.size(); i++) {
                listFinal.add(list.get(i));
            }
            return listFinal;
        }
    }

    // @Requirement 6
    private boolean checkUserSuitable(ArrayList<User> listUser, int userId, String occupation) {
        User userStan = null;
        int first = 0, last = listUser.size() - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (listUser.get(mid).getId() < userId) {
                first = mid + 1;
            } else if (listUser.get(mid).getId() == userId) {
                userStan = users.get(mid);
                break;
            } else {
                last = mid - 1;
            }
        }
        if (userStan.getOccupation().equals(occupation)) {
            return true;
        }
        return false;
    }

    public ArrayList<String> findMoviesByOccupationAndLessThanRating(String occupation, int k, int rating) {
        HashSet<String> setMovie = new HashSet<>();

        ArrayList<User> listUser = new ArrayList<User>(users);
        Collections.sort(listUser, Comparator.comparing(User::getId));

        ArrayList<Movie> listMovie = new ArrayList<Movie>(movies);
        Collections.sort(listMovie, Comparator.comparing(Movie::getId));

        for (Rating rater : ratings) {
            if (rater.getRatingPoint() < rating) {
                if (checkUserSuitable(listUser, rater.getUserId(), occupation)) {
                    String movieName = binarySearchMovie(listMovie, rater.getMovieId());
                    setMovie.add(movieName);
                }
            }
        }

        ArrayList<String> list = new ArrayList<>(setMovie);
        Collections.sort(list);

        if (list.size() <= k) {
            return list;
        } else {
            ArrayList<String> listFinal = new ArrayList<>();
            for (int i = 0; i < k && i < listMovie.size(); i++) {
                listFinal.add(list.get(i));
            }
            return listFinal;
        }
    }

    // @Requirement 7]
    // lay gioi tinh
    private String getGender(ArrayList<User> listUser, int userId) {
        User userStan = null;
        int first = 0, last = listUser.size() - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (listUser.get(mid).getId() < userId) {
                first = mid + 1;
            } else if (listUser.get(mid).getId() == userId) {
                userStan = users.get(mid);
                break;
            } else {
                last = mid - 1;
            }
        }
        return userStan.getGender();
    }

    // lay ra genres tieu chuan
    private ArrayList<String> standarGenres(int userId, int rating, ArrayList<Movie> listMovie) {
        HashSet<Rating> listRating = new HashSet<>();
        // tim vi tri cua no
        int index = -1;
        int id = -1;
        int first = 0, last = ratings.size() - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (ratings.get(mid).getUserId() < userId) {
                first = mid + 1;
            } else if (ratings.get(mid).getUserId() == userId) {
                index = mid;
                id = ratings.get(mid).getUserId();
                break;
            } else {
                last = mid - 1;
            }
        }
        int index1 = index;
        while (ratings.get(index1).getUserId() == id) {
            if (ratings.get(index1).getRatingPoint() >= rating) {
                listRating.add(ratings.get(index1));
            }
            index1++;
        }

        while (ratings.get(index).getUserId() == id) {
            if (ratings.get(index).getRatingPoint() >= rating) {
                listRating.add(ratings.get(index));
            }
            index--;
        }

        ArrayList<Rating> list1 = new ArrayList<>(listRating);
        Collections.sort(list1, Comparator.comparing(Rating::getTimeRating));

        return getGenresOfMovie(listMovie, list1.get(list1.size() - 1).getMovieId());
    }

    // lay genres
    private ArrayList<String> getGenresOfMovie(ArrayList<Movie> listMovie, int movieId) {
        int first = 0, last = listMovie.size() - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;

            if (listMovie.get(mid).getId() < movieId) {
                first = mid + 1;
            } else if (listMovie.get(mid).getId() == movieId) {
                return listMovie.get(mid).getGenres();
            } else {
                last = mid - 1;
            }
        }
        return null;
    }

    private boolean checkGenres(ArrayList<String> standar, ArrayList<String> genres) {
        for (String str : genres) {
            if (standar.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> findMoviesMatchLatestMovieOf(int userId, int rating, int k) {
        HashSet<String> setMovie = new HashSet<>();

        ArrayList<User> listUser = new ArrayList<User>(users);
        Collections.sort(listUser, Comparator.comparing(User::getId));

        ArrayList<Movie> listMovie = new ArrayList<Movie>(movies);
        Collections.sort(listMovie, Comparator.comparing(Movie::getId));

        String gender = getGender(listUser, userId);

        ArrayList<String> standarGenres = standarGenres(userId, rating, listMovie);

        for (Rating rater : ratings) {
            if (rater.getRatingPoint() >= rating && rater.getUserId() != userId) {
                if (getGender(listUser, rater.getUserId()).equals(gender)) {
                    if (checkGenres(standarGenres, getGenresOfMovie(listMovie, rater.getMovieId()))) {
                        setMovie.add(binarySearchMovie(listMovie, rater.getMovieId()));
                    }
                }
            }
        }

        ArrayList<String> list = new ArrayList<>(setMovie);
        Collections.sort(list);
        if (list.size() <= k) {
            return list;
        } else {
            ArrayList<String> listFinal = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                listFinal.add(list.get(i));
            }
            return listFinal;
        }

    }
}