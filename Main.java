public class Main {
    public static void main(String[] args) {
        Studio paramount = new Studio("Paramount", "Hollywood");
        Actor matt = new Actor("Matt Smith");
        Movie bond = new Movie("Casino Royale", paramount, 2008, new Actor[] { matt });
        MovieStore store = new MovieStore("Blockbuster", "Texas");
        store.addMovie(bond);

        System.out.println("Store Name: " + store.getName());
        System.out.println("Store Location: " + store.getLocation());

        System.out.println("Movies by Paramount: " + store.getMoviesByStudio("Paramount").size());
    }
}

