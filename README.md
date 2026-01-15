# 🌦️ Weather Reading – Stevenson Screen Simulation (Java)

This repository contains a Java implementation of a **weather station reading model** based on measurements collected from a **Stevenson Screen**, the standard enclosure used in meteorology to protect weather instruments.

The project focuses on modeling a single weather reading and computing derived “feels-like” values such as **relative humidity**, **heat index**, and **wind chill** using established meteorological formulas.

---

## 📌 Features

- Object-oriented Java design
- Input validation for meteorological readings
- Accurate calculation of:
  - Relative Humidity
  - Heat Index
  - Wind Chill (US standard)
- Clean and human-readable `toString()` output
- Comprehensive **JUnit 4** test coverage
- Clear and maintainable code structure

---

## 🧠 Concepts Demonstrated

- Java classes and constructors
- Accessor (getter) methods
- Mathematical modeling with real-world formulas
- Unit testing with **JUnit 4**
- Defensive programming
- Method overriding (`toString()`)

---

## 📂 Project Structure

Weather/
├── src/
│ ├── Main.java
│ └── WeatherReading.java
├── test/
│ └── WeatherReadingTest.java
└── README.md
