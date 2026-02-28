import java.time.LocalDate;

public class Movie {
    private String Name;
    private Studio studio;
    private LocalDate releaseDate;
    private Actor[] actors;
    private String genre;

    public Movie(String Name, Studio studio, int releaseYear, Actor[] actors) {
        this.Name = Name;
        this.studio = studio;
        this.releaseDate = LocalDate.ofYearDay(releaseYear, 1);
        this.actors = actors;
        this.genre = genre;
    }

    public String getName() {
        return Name;
    }

    public Studio getStudio() {
        return studio;
    }

    public int getReleaseYear() {
        return releaseDate.getYear();
    }

    public Actor[] getActors() {
        return actors;
    }

    public String getStudioLocation() {
        return studio.getLocation();
    }


    public boolean copyrighted() {
        int currentYear = LocalDate.now().getYear();
        return (currentYear - releaseDate.getYear()) <= 50;
    }
        public String getGenre() { 
        return genre;
    }
}

