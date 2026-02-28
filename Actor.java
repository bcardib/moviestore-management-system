import java.util.List;
import java.util.ArrayList;

public class Actor {
    private String name;
    private List<Movie> movies;

    public Actor(String name, Movie[] movies) {
        this.name = name;
        this.movies = new ArrayList<>();
        for (Movie movie : movies) {
            this.movies.add(movie);
        }
    }

    public String getName() {
        return name;
    }

    public Movie[] getMovies() {
        return movies.toArray(new Movie[0]);
    }
}

