# Java Platformer Game

A **2D platformer game** built in **Java** using the **CityEngine** physics library, featuring multiple themed levels, 
interactive gameplay, and a polished GUI system

---

## 🎮 Features

- **Three uniquely designed levels**, each with its own theme:
  - 🏴‍☠️ **Pirate**
  - 🚀 **Space**
  - ✨ **Magic**
- **Player abilities**: movement, jumping, shooting (levels 2 & 3), and interaction with the environment
- **Collectibles** such as coins, stars, books, gravity boots, and more
- **Enemies** with patrol and collision-based damage
- **Player health & lives system**
- **Background music & sound effects** unique to each level
- **Main menu GUI**: start game, level select, instructions, quit
- **Pause menu GUI**: resume, toggle music, quit
- **HUD** showing live player statistics
- **End-game summary screen** displayed after all levels are completed

---

## 🛠️ Technologies Used

### Core Language & APIs
- **Java** (Object-Oriented Programming, event-driven design, error handling)
- **Java Swing** (`JFrame`, `JPanel`, `Timer`, `KeyListener`, `MouseListener`, `ActionListener`, `ActionEvent`) for GUIs and input handling
- **Java AWT** (`Graphics`, `Color`, `Image`) for rendering and visuals
- **Java Sound API** (`javax.sound.sampled`) for audio playback
- **Java Collections Framework** (`ArrayList`, `HashMap`) for storing and managing game objects and sounds

### Frameworks & Libraries
- **CityEngine** (provided by City, University of London) – physics engine for 2D games
  - Provides `StepListener` (game loop updates) and `CollisionListener` (collision detection & handling)
- **JBox2D** (`org.jbox2d.common.Vec2`) – vector math for physics calculations

### Utilities
- **Exception handling** (`IOException`, `LineUnavailableException`, `UnsupportedAudioFileException`) for robust asset management

---

## 📖 What I Learned

- Applying **Object-Oriented Programming (OOP)** concepts (inheritance, polymorphism, abstraction, encapsulation) in a large-scale project
- Designing and structuring code into **modular packages** (`core`, `level1`, `level2`, `level3`) for maintainability
- Managing **game states and transitions** (switching levels, handling resources, and ensuring performance)
- Implementing **event-driven programming** via listeners:
  - **Java Swing / AWT** → `KeyListener`, `MouseListener`, `ActionListener`, `ActionEvent` (GUI & user input)
  - **CityEngine** → `StepListener`, `CollisionListener` (game physics & collision handling)
- Creating a polished **GUI** using Java Swing components
- Handling **multimedia assets** (images, sounds, and music) with appropriate error handling and fallbacks
- Writing **comprehensive documentation** with Javadocs and inline comments

---

## 🖼️ Screenshots

<p align="center">
  <img src="docs/screenshots/level1.png" alt="Level 1" width="30%"/>
  <img src="docs/screenshots/level2.png" alt="Level 2" width="30%"/>
  <img src="docs/screenshots/level3.png" alt="Level 3" width="30%"/>
</p>

--- 

## 📌 Future Improvements

- **Save & Load System** → Extend the GUI to allow saving/loading player progress, state, and attributes
- **Smarter Enemy AI** → Enable enemies to **actively attack the player** (ranged/projectile attacks) rather than only causing damage on contact
- **Enhanced Animations** → Improve player and enemy sprite animations for smoother and more lifelike movement

---

## 🙏 Acknowledgements

- The **PolygonEditor** class was provided by **City, University of London** as part of the coursework framework
- It was used to create precise collision shapes and hitboxes for in-game objects, ensuring accurate physics interactions

---