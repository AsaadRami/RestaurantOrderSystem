# Restaurant Order System

A JavaFX GUI application for managing restaurant orders with TCP socket networking.

## Project: CS244 – Advanced Programming Applications

---

## Features

- User registration and login (with input validation)
- Browse menu (food & drink items)
- Build and place orders
- Order confirmation screen
- View order history
- User profile screen
- Admin panel (view all orders and users)
- TCP socket networking (client sends order to server)
- Multithreading (server handles multiple clients simultaneously)

---

## Screens (10 total)

| Screen | Description |
|---|---|
| Login | User login with validation |
| Register | New user registration |
| Home | Dashboard with navigation |
| Menu | Browse menu items, add to order |
| Order | Review cart before placing |
| Order Confirmation | Success screen after placing |
| Order History | View past orders |
| Profile | View user info |
| Admin | Admin-only: view all users/orders |
| Logout | Confirmation before logging out |

---

## OOP Concepts Applied

- **Encapsulation**: All model fields are private with getters/setters
- **Polymorphism**: `MenuItem` is abstract; `FoodItem` and `DrinkItem` extend it and override `getCategory()` and `getDescription()`
- **Exceptions**: Input validation in Login, Register, Menu screens
- **Multithreading**: Server spawns a new thread per client; GUI uses background thread for networking
- **Networking**: TCP Sockets between `Server` (console) and `OrderClient` (JavaFX)

---

## Classes (6+ excluding controllers and FXML)

| Class | Package | Purpose |
|---|---|---|
| `User` | model | Represents a system user |
| `MenuItem` | model | Abstract base for menu items |
| `FoodItem` | model | Food menu item (extends MenuItem) |
| `DrinkItem` | model | Drink menu item (extends MenuItem) |
| `Order` | model | Represents a customer order |
| `DataStore` | util | In-memory data store (singleton) |
| `SceneManager` | util | Scene switching utility |
| `Server` | network | TCP server (console app) |
| `ClientHandler` | network | Handles one client per thread |
| `OrderClient` | network | Sends order over TCP from GUI |

---

## How to Run

### Step 1 – Start the Server

```
cd RestaurantOrderSystem
mvn compile
mvn exec:java -Dexec.mainClass="com.restaurant.network.Server"
```

Or run `Server.java` directly from your IDE.

### Step 2 – Start the JavaFX Client

```
mvn javafx:run
```

Or run `MainApp.java` from your IDE.

### Default Credentials

| Username | Password | Role |
|---|---|---|
| admin | admin123 | Admin |
| john | john123 | Customer |

---

## Project Structure

```
RestaurantOrderSystem/
├── pom.xml
└── src/main/
    ├── java/com/restaurant/
    │   ├── MainApp.java
    │   ├── model/
    │   │   ├── User.java
    │   │   ├── MenuItem.java
    │   │   ├── FoodItem.java
    │   │   ├── DrinkItem.java
    │   │   └── Order.java
    │   ├── network/
    │   │   ├── Server.java
    │   │   ├── ClientHandler.java
    │   │   └── OrderClient.java
    │   ├── util/
    │   │   ├── DataStore.java
    │   │   └── SceneManager.java
    │   └── controller/
    │       ├── LoginController.java
    │       ├── RegisterController.java
    │       ├── HomeController.java
    │       ├── MenuController.java
    │       ├── OrderController.java
    │       ├── OrderConfirmationController.java
    │       ├── OrderHistoryController.java
    │       ├── ProfileController.java
    │       ├── AdminController.java
    │       └── LogoutController.java
    └── resources/com/restaurant/fxml/
        ├── Login.fxml
        ├── Register.fxml
        ├── Home.fxml
        ├── Menu.fxml
        ├── Order.fxml
        ├── OrderConfirmation.fxml
        ├── OrderHistory.fxml
        ├── Profile.fxml
        ├── Admin.fxml
        └── Logout.fxml
```
