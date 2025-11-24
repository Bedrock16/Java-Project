

# Student ID Card Generator

A simple Java application that generates clean and professional student ID cards.  
Users can enter student details, upload a photo, preview the front and back of the card, and save both sides as PNG images.

---

## 📌 Overview
This is a lightweight Java Swing project created to visually generate student ID cards.  
It is simple, clean, and suitable for academic project submissions.

---

## ✨ Features
- Enter student details (Name, ID, Course, DOB, Blood Group, Address)
- Upload and display student photo
- Live preview of **front** and **back** of the card
- Save both sides as PNG images
- Customizable via `.env` file (college name, colors, website etc.)

---

## 📁 Project Structure
- **IDCardApp.java** — Main GUI and event handling  
- **CardRenderer.java** — Draws the card (front & back)  
- **Theme.java** — Colors, fonts, card properties  
- **EnvLoader.java** — Loads values from `.env`  
- **.env** — Edit college details and theme colors  

---

## 🛠️ How to Run

### 1️⃣ Install Java 8+

### 2️⃣ Compile the project:
```bash
javac *.java
````

### 3️⃣ Run the application:

```bash
java IDCardApp
```

---

## 🖼️ Preview (Add Your Images)

### Front Side

![Front Preview](add_link_here)

### Back Side

![Back Preview](add_link_here)

---

## 🎥 Demo Video (Optional)

Add your video link here.

---

## 🎨 Example `.env` File

```
COLLEGE_NAME=My College Name
COLLEGE_ADDRESS=City, Country
PRIMARY_COLOR=#1a237e
ACCENT_COLOR=#ffd700
TEXT_COLOR=#333333
WEBSITE=www.example.com
```

---

## 🛠️ Technologies Used

* Java Swing
* Java2D
* ImageIO
* .env Configuration

---

## 🚀 Future Improvements

* Export card as PDF
* Multiple card templates
* Drag & drop photo support

---
