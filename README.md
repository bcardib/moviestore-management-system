# 🎬 MovieStore Management System (Java OOP)

![Java](https://img.shields.io/badge/Java-8%2B-blue)
![Paradigm](https://img.shields.io/badge/Paradigm-Object--Oriented-success)
![Data%20Structures](https://img.shields.io/badge/Concept-Collections%20%26%20Sets-orange)

A small **object-oriented Java model** of a movie rental store. It implements core domain objects (**Actor**, **Studio**, **Movie**, **MovieStore**) based on UML-style specs, and supports inventory operations like adding and renting movies, plus simple querying (e.g., movies by studio, and copyright checks).

---

## ✨ What this project demonstrates

- **OOP modelling** (classes, composition, relationships)
- **Collections** (`ArrayList`, `HashSet`)
- **Basic business rules**
  - inventory copy tracking
  - copyright expiry rule (50 years after release, current year fixed at **2024**)
- Writing maintainable, readable Java with clear responsibilities

---

## ✅ Assignment Requirements mapped to implementation

### Classes

- **Actor(name, movies)**
- **Studio(name, location, movies)**
- **Movie(name, studio, releaseYear, actors)**
  - `copyrighted()` → returns `true` if still under copyright.
  - **Rule:** copyright expires **50 years** after release.
  - **Current year is 2024** (per task spec).
- **MovieStore(name, location)**
  - `addMovie(movie)` → add to collection; if already exists, increment copies by 1
  - `rentMovie(movie)` → remove a copy and return `true`; if none available, return `false`
  - `getMoviesByStudio(studio)` → set of movies produced by the given studio
  - `getMoviesWithoutCopyright()` → list of movies that exceeded copyright period

---

## 📁 Project structure

Typical layout:

```
.
├── Actor.java
├── Studio.java
├── Movie.java
├── MovieStore.java
└── Main.java
```

---

## ▶️ How to run

### Option A — Compile + run from terminal (no Gradle/Maven)

From the folder containing the `.java` files:

```bash
javac *.java
java Main
```

---

## 🧠 Key design choices

- **MovieStore inventory**
  - Uses a `HashMap<Movie, Integer>` to track **copies per movie**.
  - This provides **O(1)** expected-time updates and lookups.
- **Queries**
  - Returning a `Set<Movie>` avoids duplicates for studio-based queries.
- **Copyright**
  - `Movie.copyrighted()` compares `releaseYear + 50` with the fixed year **2024**.

---

## 🛠️ Notes / sanity checks

If you’re using the included `Main.java`, make sure your constructors match the usage:

- `Actor` currently expects both `name` and `movies` in the constructor.
- `Movie` currently expects a `genre` argument in the constructor.

**Quick fix (recommended for portfolio):**
- Add a convenience constructor to `Actor`:
  ```java
  public Actor(String name) { this(name, new Movie[0]); }
  ```
- Add a convenience constructor to `Movie`:
  ```java
  public Movie(String name, Studio studio, int releaseYear, Actor[] actors) {
      this(name, studio, releaseYear, actors, "Unknown");
  }
  ```

This keeps backwards compatibility and lets `Main` run cleanly.

---

## 💡 Suggested enhancements (if you want to level it up)

- Add **unit tests** (JUnit 5) for:
  - `addMovie` duplicate increments
  - `rentMovie` copy decrement & zero handling
  - `copyrighted()` boundary cases
- Improve equality rules:
  - implement `equals()` / `hashCode()` for `Movie` (and possibly `Studio`) so inventory and sets behave predictably
- Add a simple CLI menu for interactive store operations

---

## 👩‍💻 Author

**Bhakthi Salimath**  
University of Sydney
