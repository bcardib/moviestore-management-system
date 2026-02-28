package moviestore;

public class Movie {
    private static final int CURRENT_YEAR = 2024; // per assignment note

    private final String name;
    private final Studio studio;
    private final int releaseYear;
    private final java.util.Set<Actor> actors;

    public Movie(String name, Studio studio, int releaseYear, Actor[] actors) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (studio == null) throw new IllegalArgumentException("studio cannot be null");

        this.name = name;
        this.studio = studio;
        this.releaseYear = releaseYear;

        this.actors = new java.util.HashSet<>();
        if (actors != null) {
            for (Actor actor : actors) {
                if (actor != null) this.actors.add(actor);
            }
        }

        // Keep bidirectional links consistent (helpful for debugging)
        studio.addMovie(this);
        for (Actor actor : this.actors) {
            actor.addMovie(this);
        }
    }

    public String getName() {
        return name;
    }

    public Studio getStudio() {
        return studio;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Actor[] getActors() {
        return actors.toArray(new Actor[0]);
    }

    // Copyright expires 50 years after release
    public boolean copyrighted() {
        return (CURRENT_YEAR - releaseYear) < 50;
    }

    @Override
    public String toString() {
        return "Movie{" + name + ", " + studio.getName() + ", " + releaseYear + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return releaseYear == movie.releaseYear
                && name.equals(movie.name)
                && studio.equals(movie.studio);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + studio.hashCode();
        result = 31 * result + releaseYear;
        return result;
    }
}