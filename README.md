# Encrypted Messaging

<p align="center">
<img width="2880" height="1620" alt="Application Banner" src="https://github.com/user-attachments/assets/dd783bb9-83ac-41b7-8aa8-d40b49aa0960">
</p>

## Overview

**Encrypted Messaging** is a JavaFX desktop application created to demonstrate the fundamentals of encrypted client-server communication. The project simulates how messaging applications exchange information by allowing two local users to send encrypted messages between a client and a server in real time.

The application was developed as an educational project to better understand networking, socket programming, encryption, and graphical user interface development using JavaFX.

---

## Features

* Caesar Cipher encryption and decryption
* Two-way communication between client and server
* Local socket-based networking
* Real-time message transmission
* JavaFX graphical user interface
* Interactive messaging windows
* Demonstrates the fundamentals of client-server architecture
* Simple and lightweight educational implementation

---

## Technologies Used

* Java
* JavaFX 26
* TCP Socket Programming
* Client-Server Architecture
* Caesar Cipher Encryption

---

## Project Structure

```
src/
├── crypto/
├── network/
├── ui/
├── models/
├── storage/
├── history/
└── users/
```

---

# How It Works

1. The server starts and waits for incoming connections.
2. The client connects to the server through a TCP socket.
3. Messages entered by the user are encrypted using a Caesar Cipher.
4. The encrypted message is transmitted across the socket connection.
5. The receiving side decrypts the message before displaying it.
6. Both the encrypted and decrypted versions can be viewed, demonstrating how encrypted communication works internally.

---

# Installation

## 1. Download JavaFX

Download JavaFX SDK 26 from:

https://gluonhq.com/products/javafx/

For macOS, download the appropriate macOS SDK version.

After downloading, place the **javafx-sdk-26.0.1** folder inside the project directory.

Example:

```
JavaFXEncryptor/
│
├── javafx-sdk-26.0.1/
└── src/
```

---

## 2. Clone or Download the Repository

Download or clone this repository and navigate into the project folder.

```bash
cd ~/JavaFXEncryptor
```

---

## 3. Recompile the Project (Only Required After Editing Code)

Delete previously compiled class files:

```bash
find src -name "*.class" -delete
```

Compile the project:

```bash
javac --module-path javafx-sdk-26.0.1/lib \
--add-modules javafx.controls,javafx.fxml \
$(find src -name "*.java")
```

---

## 4. Run the Application

Launch the JavaFX application:

```bash
java --module-path javafx-sdk-26.0.1/lib \
--add-modules javafx.controls,javafx.fxml \
-cp src ui.Main
```

---

## Demonstration

The application opens separate messaging windows representing the communicating devices.

Users can:

* Type messages
* Encrypt text
* Decrypt received messages
* Exchange encrypted messages through the local server
* Observe how client-server communication functions behind the scenes

---

## Educational Objectives

This project was built to explore and better understand:

* Client-server communication
* TCP sockets
* Network message routing
* Encryption and decryption
* JavaFX user interface development
* Event-driven programming
* Object-oriented software architecture

---

## Future Improvements

The next planned version includes:

* User accounts
* Login and registration
* Persistent chat history
* Image sharing
* Multiple conversations
* Online user list
* Improved encryption algorithms
* Modern messaging interface
* Metadata storage (timestamps, IP addresses, delivery information)
* Better application architecture for scalability

---

## License

Copyright © 2026 Doruk Ersoy. All rights reserved.

This project is the intellectual property of Doruk Ersoy and is provided for portfolio and educational purposes only. No part of this project may be copied, modified, distributed, or used commercially without prior written permission from the author.
