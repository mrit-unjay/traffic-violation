# 🚦 Traffic Violation Monitoring System

A full-stack web application to monitor vehicle speed, detect traffic violations, calculate fines, and visualize analytics in real time.

---

🌐 Live Demo

🔗 https://traffic-violation-5b3k.onrender.com

## 📌 Features

* ➕ Add vehicle details (ID, Speed, Zone, Emergency)
* ⚠️ Automatic violation detection:

  * Safe
  * Overspeed
  * Severe
  * Emergency (no fine)
* 💰 Automatic fine calculation
* 📊 Dashboard with:

  * Total Vehicles
  * Violations Count
  * Total Fine
* 📈 Analytics (Chart visualization using Chart.js)
* 🗑️ Delete records with admin password protection
* 🎨 Clean UI with sidebar dashboard

---

## 🛠️ Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* MySQL

### Frontend

* HTML, CSS, JavaScript
* Chart.js (for analytics)
### Deployment
* Docker
* Render (Backend Hosting)
---

## ⚙️ How It Works

1. User adds vehicle details from UI
2. Backend processes:

   * Determines violation type
   * Calculates fine
3. Data is stored in MySQL database
4. Dashboard updates automatically
5. Analytics chart visualizes violations

---

## 🚀 Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/traffic-violation.git
cd traffic-violation
```

---

### 2️⃣ Configure Database (MySQL)

Create database:

```sql
CREATE DATABASE traffic;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/traffic
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
server.port=8081
```

---

### 3️⃣ Run Backend

In Eclipse / IntelliJ:

Run:

```text
TrafficappApplication.java → Run as Spring Boot App
```

---

### 4️⃣ Open Application

```text
http://localhost:8081
```

---



## 📊 Analytics

* Displays Normal vs Overspeed vehicles
* Built using Chart.js
* Updates dynamically

---

## 🧹 Important Note

If you see `undefined` in Type column:

```sql
TRUNCATE TABLE vehicle_data;
```

Then add fresh data again.

---

## 🌍 Deployment (Render)

* Push project to GitHub
* Connect repo to Render
* Use:

  * Build: `mvn clean install`
  * Start: `java -jar target/*.jar`

---

## 📷 Screenshot

<img width="1890" height="827" alt="image" src="https://github.com/user-attachments/assets/844f91af-74b0-43ba-9b64-c1140aa3154b" />

---

