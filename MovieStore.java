import java.time.LocalDate;
import java.util.*;

public class MovieStore {
    private String name;
    private String location;
    private Map<Movie, Integer> movies;

    public MovieStore(String name, String location) {
        this.name = name;
        this.location = location;
        this.movies = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Map<Movie, Integer> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        if (movie != null) {
            movies.put(movie, movies.getOrDefault(movie, 0) + 1);
        }
    }

    public boolean rentMovie(Movie movie) {
        if (movie != null && movies.containsKey(movie) && movies.get(movie) > 0) {
            movies.put(movie, movies.get(movie) - 1);
            return true;
        }
        return false;
    }

    public List<Movie> getMoviesByGenre(String genre) {
        List<Movie> result = new ArrayList<>();
        if (genre != null) {
            for (Map.Entry<Movie, Integer> entry : movies.entrySet()) {
                Movie movie = entry.getKey();
                if (movie.getGenre().equals(genre)) {
                    result.add(movie);
                }
            }
        }
        return result;
    }

    public Set<Movie> getMoviesWithActors(Actor[] actors) {
        Set<Movie> result = new HashSet<>();
        if (actors != null) {
            List<Actor> actorList = Arrays.asList(actors);
            for (Map.Entry<Movie, Integer> entry : movies.entrySet()) {
                Movie movie = entry.getKey();
                List<Actor> movieActors = Arrays.asList(movie.getActors());
                if (movieActors.containsAll(actorList)) {
                    result.add(movie);
                }
            }
        }
        return result;
    }

    public HashSet<Movie> getMoviesByStudio(String studioName) {
        HashSet<Movie> result = new HashSet<>();
        if (studioName != null) {
            for (Map.Entry<Movie, Integer> entry : movies.entrySet()) {
                Movie movie = entry.getKey();
                if (movie.getStudio().getName().equals(studioName)) {
                    result.add(movie);
                }
            }
        }
        return result;
    }

    public LinkedList<Movie> getMoviesWithoutCopyright() {
        LinkedList<Movie> result = new LinkedList<>();
        LocalDate currentYear = LocalDate.now();
        for (Map.Entry<Movie, Integer> entry : movies.entrySet()) {
            Movie movie = entry.getKey();
            if (!movie.copyrighted()) {
                result.add(movie);
            }
        }
        return result;
    }
}

