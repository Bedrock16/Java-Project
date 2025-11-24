# ID Card Generator Application

A Java-based GUI application for generating customized student ID cards with dual-sided printing support (front and back).

---

## Quick Start

### Compile
```bash
javac *.java
```

### Run
```bash
java IDCardApp
```

---

## Project Files & Functions

### 1. **IDCardApp.java** (Main Application)
Main GUI window using Swing framework.

#### Key Functions:
- **`IDCardApp()`** - Constructor initializes GUI, loads theme, and sets up panels
- **`createInputPanel()`** - Creates left panel with form fields:
  - Student Photo upload button
  - Name, ID, Course, Date of Birth, Blood Group, Address fields
- **`createPreviewPanel()`** - Creates center panel for live card preview
- **`createButtonPanel()`** - Creates bottom panel with action buttons:
  - Generate Card: Renders front/back cards from form data
  - Flip Front/Back: Toggles preview between front and back
  - Save to PNG: Exports cards as PNG files
- **`selectPhoto()`** - File chooser dialog to upload student photo (JPG/PNG)
- **`generateCard()`** - Collects form data and calls renderer to create both sides
- **`toggleView()`** - Switches between front/back card preview
- **`saveImages()`** - Exports generated cards as `ID_{studentID}_Front.png` and `ID_{studentID}_Back.png`
- **`updatePreview()`** - Scales and displays card in preview panel
- **`main()`** - Entry point, starts application

---

### 2. **CardRenderer.java** (Graphics Engine)
Handles all card design and rendering using Graphics2D.

#### Key Functions:
- **`CardRenderer(EnvLoader env)`** - Constructor takes configuration loader
- **`createFront(Map<String, String> studentData, BufferedImage photo)`** - Renders front side:
  - Header background with college name (Theme.PRIMARY color)
  - Circular clipped photo with white border (120x120px)
  - Student details: Name, ID, Course, DOB, Blood Group, Address
  - Validity date (3 years from now)
  - Footer with Principal signature
- **`createBack()`** - Renders back side:
  - Terms & Conditions header
  - "If Found, Return To" section with college info
  - Card usage rules (4 numbered rules)
  - Mock barcode area with website
- **`setupGraphics(BufferedImage image)`** - Initializes Graphics2D with antialiasing
- **`drawField(Graphics2D g2d, String label, String value, int y)`** - Draws labeled data fields with truncation (max 25 chars)
- **`drawCenteredText(Graphics2D g2d, String text, Font font, int y)`** - Draws text centered horizontally

#### Design Details:
- **Card Size:** 400x600 pixels (vertical orientation)
- **Photo Clipping:** Uses Ellipse2D for circular photo effect
- **Colors:** PRIMARY (header/footer), ACCENT (divider), TEXT (labels)

---

### 3. **Theme.java** (Styling Constants)
Centralized configuration for fonts and colors.

#### Key Constants:
- **Card Dimensions:**
  - `CARD_WIDTH = 400`
  - `CARD_HEIGHT = 600`
- **Fonts:**
  - `FONT_HEADER` - Segoe UI Bold 22pt (college name)
  - `FONT_TITLE` - Segoe UI Bold 18pt (section headers)
  - `FONT_LABEL` - SansSerif Bold 12pt (field labels)
  - `FONT_VALUE` - SansSerif Plain 14pt (data values)
  - `FONT_SMALL` - SansSerif Plain 10pt (small text)
- **Colors (loaded from .env):**
  - `PRIMARY` - Main theme color (default: #1a237e dark blue)
  - `ACCENT` - Accent color (default: #ffd700 gold)
  - `TEXT` - Text color (default: #333333 dark gray)
  - `BACKGROUND` - Card background (always white)

#### Functions:
- **`loadColors(EnvLoader env)`** - Reads hex color values from .env file using Color.decode()

---

### 4. **EnvLoader.java** (Configuration Manager)
Parses .env file for institutional customization.

#### Key Functions:
- **`EnvLoader(String filepath)`** - Constructor reads .env file line by line:
  - Skips comments (lines starting with #) and empty lines
  - Parses `KEY=VALUE` format
  - Falls back to defaults if file missing
- **`get(String key)`** - Returns config value or empty string if not found
- **`get(String key, String defaultValue)`** - Returns config value or provided default

#### Configuration Keys (from .env):
- `COLLEGE_NAME` - Institution name
- `COLLEGE_ADDRESS` - Address for "Return To" section
- `PRINCIPAL_NAME` - Principal/Head name for signature
- `CONTACT_PHONE` - Contact number
- `WEBSITE` - Institution website (for back side)
- `PRIMARY_COLOR` - Hex color for headers (e.g., #1a237e)
- `ACCENT_COLOR` - Hex color for dividers (e.g., #ffd700)
- `TEXT_COLOR` - Hex color for text (e.g., #333333)

---

## Configuration (.env file)

```
COLLEGE_NAME=Your College Name
COLLEGE_ADDRESS=123 Main Street, City, State
PRINCIPAL_NAME=Dr. John Principal
CONTACT_PHONE=+1-234-567-8900
WEBSITE=www.college.edu
PRIMARY_COLOR=#1a237e
ACCENT_COLOR=#ffd700
TEXT_COLOR=#333333
```

---

## Usage Workflow

1. **Launch** the application
2. **Upload Photo** - Click "Browse Photo" to select student image (JPG/PNG)
3. **Fill Form** - Enter: Name, ID, Course, DOB, Blood Group, Address
4. **Generate** - Click "Generate Card" to create front/back designs
5. **Preview** - Use "Flip Front/Back" to view both sides
6. **Save** - Click "Save to PNG" to export files

### Output Files
- `ID_[StudentID]_Front.png` - Front card (400x600px)
- `ID_[StudentID]_Back.png` - Back card (400x600px)

---

## System Requirements

- Java 8 or higher
- 256MB RAM (minimum)
- 50MB disk space
- Image file support: JPG, PNG

---

## Troubleshooting

| Issue | Solution |
|-------|----------|
| "Error reading .env file" | Ensure `.env` file is in same directory as .class files |
| Photo not appearing on card | Supported formats: JPG, PNG. Verify image is valid |
| Card preview is blank | Click "Generate Card" first to create card from form data |
| PNG save fails | Check write permissions in current directory |

---

## Technical Architecture

- **Pattern:** MVC (Model-View-Controller)
- **GUI Framework:** Java Swing
- **Graphics:** Java 2D (Graphics2D, Ellipse2D for circular clipping)
- **File I/O:** ImageIO for PNG export, File operations for .env parsing
- **Code:** ~700 lines total across 4 classes
