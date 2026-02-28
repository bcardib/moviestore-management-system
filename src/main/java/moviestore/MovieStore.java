package moviestore;

public class MovieStore {
    private final String name;
    private final String location;

    // Movie -> number of copies
    private final java.util.Map<Movie, Integer> inventory = new java.util.HashMap<>();

    public MovieStore(String name, String location) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (location == null) throw new IllegalArgumentException("location cannot be null");
        this.name = name;
        this.location = location;
    }

    public void addMovie(Movie movie) {
        if (movie == null) return;
        inventory.put(movie, inventory.getOrDefault(movie, 0) + 1);
    }

    public boolean rentMovie(Movie movie) {
        if (movie == null) return false;

        int copies = inventory.getOrDefault(movie, 0);
        if (copies <= 0) return false;

        if (copies == 1) inventory.remove(movie);
        else inventory.put(movie, copies - 1);

        return true;
    }

    public java.util.Set<Movie> getMoviesByStudio(Studio studio) {
        java.util.Set<Movie> result = new java.util.HashSet<>();
        if (studio == null) return result;

        for (Movie movie : inventory.keySet()) {
            if (studio.equals(movie.getStudio())) result.add(movie);
        }
        return result;
    }

    public java.util.List<Movie> getMoviesWithoutCopyright() {
        java.util.List<Movie> result = new java.util.ArrayList<>();
        for (Movie movie : inventory.keySet()) {
            if (!movie.copyrighted()) result.add(movie);
        }
        return result;
    }

    // Optional helper for debugging/demo
    public int getCopies(Movie movie) {
        return inventory.getOrDefault(movie, 0);
    }
}