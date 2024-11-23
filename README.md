# **FitPeo Automation Assignment**

This project automates the steps required to interact with the FitPeo Revenue Calculator page using **Selenium WebDriver** with Java and Firefox.

---

## **Prerequisites**

### **1. Install Java**
- Ensure **Java 11 or later** is installed.
- Verify installation with:
  ```bash
  java -version
  ```

### **2. Install Maven**
- Download and install Maven from [Apache Maven](https://maven.apache.org/).
- Verify installation with:
  ```bash
  mvn -v
  ```

### **3. Install GeckoDriver**
- Download the correct version of **GeckoDriver** for your OS from the [GeckoDriver releases page](https://github.com/mozilla/geckodriver/releases).
- Extract the executable and place it in a directory (e.g., `drivers` folder in your project).

### **4. Install Firefox**
- Download and install the latest version of Firefox from the [Mozilla Firefox site](https://www.mozilla.org/firefox/).

---

## **Setup Instructions**

### **1. Clone or Download the Project**
- Clone the repository or download the source code files.

### **2. Set GeckoDriver Path**
- Update the `geckodriver` path in the script. Modify the following line in the Java code:
  ```java
  System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
  ```
  Replace `"path/to/geckodriver"` with the absolute path to your `geckodriver.exe`.

### **3. Install Maven Dependencies**
- Open a terminal in the project directory and run:
  ```bash
  mvn clean install
  ```

---

## **Running the Automation Script**

### **From an IDE (Eclipse/IntelliJ IDEA):**
1. Import the project into your IDE.
2. Right-click on the `FitPeoAutomation` class and select **Run as Java Application**.

### **From the Command Line:**
1. Compile the program:
   ```bash
   mvn compile
   ```
2. Run the program:
   ```bash
   mvn exec:java -Dexec.mainClass="FitPeoAutomation"
   ```

---

## **Project Structure**

```plaintext
FitPeo-Automation/
├── drivers/                  # Directory containing geckodriver
├── src/
│   └── main/
│       └── java/
│           └── FitPeoAutomation.java  # Main script
├── pom.xml                   # Maven configuration file
├── README.md                 # Documentation
```

---

## **Features Automated**
1. **Navigate to FitPeo Homepage**:
   Open the FitPeo website in Firefox.
2. **Revenue Calculator Page**:
   Navigate to the Revenue Calculator page.
3. **Slider Interaction**:
   Adjust the slider value and validate its synchronization with the text field.
4. **Checkbox Selection**:
   Select specified CPT codes.
5. **Reimbursement Validation**:
   Verify the "Total Recurring Reimbursement" amount.

---

## **Troubleshooting**

### **Common Issues**
1. **`CreateProcess error=5`**:
   - Ensure GeckoDriver has execution permissions.
   - Run the IDE or terminal as an administrator.

2. **`SessionNotCreatedException`**:
   - Ensure GeckoDriver version matches the installed Firefox version.

3. **Dependencies not resolving**:
   - Run:
     ```bash
     mvn dependency:resolve
     ```
