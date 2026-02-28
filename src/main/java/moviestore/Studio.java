package moviestore;

public class Studio {
    private final String name;
    private final String location;
    private final java.util.Set<Movie> movies;

    public Studio(String name, String location) {
        this(name, location, new Movie[0]);
    }

    public Studio(String name, String location, Movie[] movies) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (location == null) throw new IllegalArgumentException("location cannot be null");

        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public Movie[] getMovies() {
        return movies.toArray(new Movie[0]);
    }

    // Optional helper (used by Movie)
    public void addMovie(Movie movie) {
        if (movie != null) movies.add(movie);
    }

    @Override
    public String toString() {
        return "Studio{" + name + ", " + location + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Studio)) return false;
        Studio studio = (Studio) o;
        return name.equals(studio.name) && location.equals(studio.location);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + location.hashCode();
    }
}