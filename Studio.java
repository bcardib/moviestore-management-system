public class Studio {
    private String name;
    private String location;
    private Movie[] movies;

    public Studio(String name, String location, Movie[] movies) {
        this.name = name;
        this.location = location;
        this.movies = movies;
    }

    public Studio(String name, String location) {
        this.name = name;
        this.location = location;
        this.movies = null; 
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Movie[] getMovies() {
        return movies;
    }
}

