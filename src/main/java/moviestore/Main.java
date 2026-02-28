package moviestore;

public class Main {
    public static void main(String[] args) {
        Studio bbc = new Studio("BBC", "London");
        Studio warner = new Studio("Warner Bros.", "Burbank");

        Actor matt = new Actor("Matt Smith");
        Actor david = new Actor("David Tennant");
        Actor margot = new Actor("Margot Robbie");

        Movie doctorWho = new Movie("Doctor Who: Special", bbc, 2013, new Actor[]{matt, david});
        Movie barbie = new Movie("Barbie", warner, 2023, new Actor[]{margot});
        Movie classic = new Movie("Classic Film", bbc, 1960, new Actor[]{matt});

        MovieStore store = new MovieStore("MovieStore", "Sydney");
        store.addMovie(doctorWho);
        store.addMovie(doctorWho); // 2 copies
        store.addMovie(barbie);
        store.addMovie(classic);

        System.out.println("Copies of Doctor Who: " + store.getCopies(doctorWho));
        System.out.println("Rent Doctor Who: " + store.rentMovie(doctorWho));
        System.out.println("Copies of Doctor Who now: " + store.getCopies(doctorWho));

        System.out.println("Movies by BBC: " + store.getMoviesByStudio(bbc));
        System.out.println("Out of copyright: " + store.getMoviesWithoutCopyright());
    }
}