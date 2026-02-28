# 🎬 MovieStore Management System — Java + Gradle (Pinned)

![Java](https://img.shields.io/badge/Java-17.0.18--tem-blue)
![Gradle](https://img.shields.io/badge/Gradle-7.6.4%20(wrapper)-green)
![Build](https://img.shields.io/badge/Build-Gradle%20Application-brightgreen)
![Platform](https://img.shields.io/badge/Platform-macOS%20%7C%20Windows-lightgrey)

A small **object-oriented Java** project that models a movie rental store using classes from a UML spec:
**Actor**, **Studio**, **Movie**, and **MovieStore**.  
Packaged with the **Gradle Wrapper** for reproducible builds and an **SDKMAN `.sdkmanrc`** to pin Java.

---

## ✨ What it does

- Represents **actors**, **studios**, and **movies** with proper relationships
- Tracks store inventory: **add copies**, **rent copies**, and handle **out-of-stock**
- Queries:
  - `getMoviesByStudio(studio)` → set of movies produced by a studio
  - `getMoviesWithoutCopyright()` → list of movies that are out of copyright
- `Movie.copyrighted()` uses the rule: **copyright expires 50 years after release**
  - Current year for the assignment logic: **2024**

---

## ✅ Versions (Important)

This repo is pinned to a known-working combo:

| Component | Version |
|---|---|
| **Java** | **17.0.18-tem** |
| **Gradle** | **7.6.4** (via `./gradlew`) |

### Why Java 17?
Gradle 7.6.4 is compatible with Java 17.  
Running Gradle 7.6.x under Java 21 can trigger errors like **“Unsupported class file major version 65”**.  
This repo avoids that by pinning **Java 17**.

---

## 📁 Project Structure

Matches the current VS Code tree:

```
moviestore-management-system/
├── src/
│   ├── main/java/moviestore/
│   │   ├── Actor.java
│   │   ├── Studio.java
│   │   ├── Movie.java
│   │   ├── MovieStore.java
│   │   └── Main.java
│   └── test/java/moviestore/
├── gradle/wrapper/
│   ├── gradle-wrapper.jar
│   └── gradle-wrapper.properties
├── .sdkmanrc
├── build.gradle
├── gradlew
├── gradlew.bat
└── README.md
```

> Note: `build/` and `.gradle/` are generated locally and should not be committed.

---

## 🚀 Quick Start (Mac / Linux)

From the project root:

```bash
# 1) Pin Java (recommended: SDKMAN)
sdk install java 17.0.18-tem
sdk env   # reads .sdkmanrc

# 2) Run using the Gradle wrapper
./gradlew clean run
```

---

## 🪟 Quick Start (Windows)

```bat
:: Run from project root
gradlew.bat clean run
```

---

## 🧠 Core Classes (UML → Implementation)

### `Actor`
- `name`
- `movies` (collection of movies the actor appears in)

### `Studio`
- `name`
- `location`
- `movies` produced by the studio

### `Movie`
- `name`
- `studio`
- `releaseYear`
- `actors`
- `copyrighted()`
  - Returns `true` if **2024 - releaseYear < 50**
  - Otherwise returns `false`

### `MovieStore`
- `name`, `location`
- Inventory methods:
  - `addMovie(movie)` → adds movie or increments copy count
  - `rentMovie(movie)` → decrements copy count, returns `true` if available else `false`
- Queries:
  - `getMoviesByStudio(studio)`
  - `getMoviesWithoutCopyright()`

---

## 🧪 Running Tests (Optional)

If/when you add tests under `src/test/java/...`:

```bash
./gradlew test
```

---

## 🧩 Reproducible Setup (No version drift)

This repo includes `.sdkmanrc`:

```
java=17.0.18-tem
```

Enable auto-switching Java when you `cd` into the folder:

1. Edit SDKMAN config:
```bash
nano ~/.sdkman/etc/config
```

2. Ensure:
```
sdkman_auto_env=true
```

Then simply:
```bash
cd moviestore-management-system
sdk env
```

---

## 💼 What this demonstrates (Graduate-role ready)

- Translating **UML → clean OOP design** (encapsulation + relationships)
- Managing collections and state (inventory counts, queries)
- Writing maintainable, readable code with clear responsibilities
- Reproducible builds with **Gradle wrapper**
- Environment pinning with **SDKMAN** to avoid “works on my machine” problems

---

## 👩‍💻 Author

**Bhakthi Salimath**  
University of Sydney
