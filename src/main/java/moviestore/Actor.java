package moviestore;

public class Actor {
    private final String name;
    private final java.util.Set<Movie> movies;

    // Allows: new Actor("Matt Smith")
    public Actor(String name) {
        this(name, new Movie[0]);
    }

    public Actor(String name, Movie[] movies) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        this.name = name;
        this.movies = new java.util.HashSet<>();

        if (movies != null) {
            for (Movie movie : movies) {
                if (movie != null) this.movies.add(movie);
            }
        }
    }

    public String getName() {
        return name;
    }

    public Movie[] getMovies() {
        return movies.toArray(new Movie[0]);
    }

    // Optional helper (used by Movie to keep relationships consistent)
    public void addMovie(Movie movie) {
        if (movie != null) movies.add(movie);
    }

    @Override
    public String toString() {
        return "Actor{" + name + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return name.equals(actor.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}