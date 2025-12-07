## ☕ Java Backend Journey — Order Analytics Mini Project

Welcome to my ongoing **Java Backend Developer Journey (2026 Track)**! 👋

This repository contains my hands-on implementations of **core Java, DSA patterns, and backend engineering principles** as I prepare for real-world backend roles and interview expectations. This mini-project demonstrates how a backend service processes and analyzes order data using clean Java, OOP, and industry-grade problem-solving techniques.

---

### 🚀 About This Mini Project

The `OrderAnalyticsService` is a **production-style Java service class** that implements several real-world and interview-essential algorithms.

All algorithms follow:
* **Clean Naming** and **Input Validation**
* **No Side Effects** and **No Static Methods** (backend-friendly)
* **O(n) Efficient Patterns**
* **Reusability** and **Modular Design**

---

### 📂 Project Structure

 core-java/
└── java-core-lab/
    └── src/
        └── main/
            └── java/
                └── dev.pawan/
                    ├── basics/
                    └── miniprojects/orders/
                        ├── OrderAnalyticsService.java 
                        └── DemoMain.java

* **`OrderAnalyticsService.java`** → Main service with **12+ analytics methods**.
* **`DemoMain.java`** → Runnable demo to test the service.

---

### 🧠 Core Algorithms Implemented

These are not random problems — they form the foundation of backend data processing seen in: **analytics pipelines, windowed event processing, caching strategies, rate-limiting,** and **fraud detection**.

#### ✔ Array Analytics
* Total orders
* Average orders
* Maximum/minimum order
* Index of max/min order

#### ✔ Running Computations
* Cumulative **prefix sums**
* Running maximums

#### ✔ Sliding Window Techniques
* Max sum of subarray of size $k$
* Max average of window size $k$
* Longest subarray with sum $\leq S$
* Longest subarray after deleting one element
* Longest subarray with at most $K$ distinct integers

#### ✔ HashMap + Frequency Problems
* First non-repeating element
* First unique element in a stream
* Count subarrays with sum $= K$ (**prefix sum + HashMap**)

---

### ▶️ How to Run

1.  **Clone the repo**
    ```bash
    git clone [https://github.com/](https://github.com/)<Pawan028>/Backend-Journey.git
    ```

2.  **Navigate to module**
    ```bash
    cd core-java/java-core-lab
    ```

3.  **Run Demo**
    * **If using IntelliJ** – open the project and run `DemoMain`.
    * **If using CLI:**
        ```bash
        mvn clean install
        mvn exec:java -Dexec.mainClass="dev.pawan.miniprojects.orders.DemoMain"
        ```

### 🔍 Example Output

Example with sample orders:

Total Orders: 92
Average Orders: 13.14
Maximum Orders: 20
Running Maximums: 10, 12, 12, 15, 20,...
Cumulative Orders: 10, 22, 30, 45,...
---

### 🏆 What I Learned

* Writing **modular backend services** (NO static, NO side effects).
* Implementing **efficient algorithms** in Java ($\text{O}(n)$ patterns).
* Applying **sliding window, HashMap, prefix sums** to real-world data cases.
* Designing classes with **clean architecture** and validation.
* Using Java as a **backend engineering language** (not just syntax).

---

### 📌 Next Steps (Roadmap)

1.  Convert this service into a **Spring Boot REST API**.
2.  Add **JUnit test coverage**.
3.  Create an e-commerce-style analytics dashboard using this service.
4.  Integrate **Redis** for caching results.
5.  Build major capstone project (2026 target).

---

### 🤝 Connect With Me

If you’re also learning Java or backend engineering, feel free to collaborate or discuss ideas!

* **LinkedIn:** `www.linkedin.com/in/pawan-yadav-810612171`
* **GitHub:** `https://github.com/Pawan028`
