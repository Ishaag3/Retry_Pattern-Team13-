# Weather Retry Pattern Demo (Spring Boot)

A resilient Spring Boot application demonstrating the **Retry Pattern** using Spring Retry, with a beautiful weather UI frontend.

---

## 🚀 Features
- **Weather API Integration**: Fetches real-time weather data for any city
- **Retry Pattern**: Automatically retries failed API calls (with exponential backoff)
- **Fallback Handling**: Graceful error handling and fallback response
- **Modern UI**: Responsive, animated weather dashboard (HTML/CSS/JS)
- **Spring Boot**: Easy to run, test, and extend

---

## 🏗️ Project Structure
```
├── src/
│   ├── main/
│   │   ├── java/com/example/retrydemo/
│   │   │   ├── AppConfig.java
│   │   │   ├── RetrydemoApplication.java
│   │   │   ├── ServletInitializer.java
│   │   │   ├── WeatherController.java
│   │   │   └── WeatherService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/index.html
│   └── test/java/com/example/retrydemo/RetrydemoApplicationTests.java
├── pom.xml
└── ...
```

---

## ⚙️ How It Works
- **User** enters a city in the UI
- **Controller** receives the request and calls the service
- **Service** fetches weather from an external API
- **@Retryable**: If the API call fails, it retries up to 3 times with a delay
- **@Recover**: If all retries fail, a fallback response is returned
- **UI** displays weather or error message

---

## 🖥️ Running the Project

1. **Clone the repository:**
   ```sh
   git clone https://github.com/Ishaag3/Retry_Pattern-Team13-.git
   cd Retry_Pattern-Team13-
   ```
2. **Configure Weather API Key:**
   - Get a free API key from [OpenWeatherMap](https://openweathermap.org/api)
   - Edit `src/main/resources/application.properties`:
     ```properties
     weather.api.key=YOUR_API_KEY
     weather.api.url=https://api.openweathermap.org/data/2.5/weather
     ```
3. **Run the application:**
   ```sh
   ./mvnw spring-boot:run
   # or on Windows
   mvnw.cmd spring-boot:run
   ```
4. **Open in browser:**
   - Go to [http://localhost:8080](http://localhost:8080)

---

## 🌐 API Usage
- `GET /weather/{city}`
  - Example: `/weather/London`
  - Returns: Weather data as JSON

---

## 🛠️ Technologies Used
- Java 17+ / Spring Boot
- Spring Retry
- RestTemplate
- HTML, CSS, JavaScript (frontend)
- Maven

---

## 🤝 Team 13
- [Isha Agrawal](https://github.com/Ishaag3)
- ...add your team members here...

---

## 📦 License
MIT

---

## 📝 How to Upload to GitHub

1. **Initialize git (if not already):**
   ```sh
   git init
   git remote add origin https://github.com/Ishaag3/Retry_Pattern-Team13-.git
   ```
2. **Add and commit your files:**
   ```sh
   git add .
   git commit -m "Initial commit: Weather Retry Pattern Demo"
   ```
3. **Push to GitHub:**
   ```sh
   git branch -M main
   git push -u origin main
   ```

---

**Happy Coding!** 🚀
