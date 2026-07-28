# Encrypted-message
<img width="2880" height="1620" alt="Daily stock check at 8 AM Report damaged goods ASAP Update vendor prices Monday Keep fridge temps stable Archive physical receipts" src="https://github.com/user-attachments/assets/dd783bb9-83ac-41b7-8aa8-d40b49aa0960" />
<pre>
This message is designed to give a simple idea of how a messageing app works
it features ceasar encryption and decription, sending between the server and the client both ways locally,
and simple pop up messaging screens that allow the user to try sending and receving messages
</pre>
###How To Run It
<pre>
To use the code firt instal "javafx-sdk-26.0.1" from the link
and any additional classes that may need instalation use the "npm i" command
</pre>
https://gluonhq.com/products/javafx/
<img width="978" height="48" alt="Screenshot 2026-06-01 at 23 57 47" src="https://github.com/user-attachments/assets/0d57187e-cdfe-418c-ac59-35669ff224d5" />
<pre>
when downloading for mac use this one
then download the folder src
put the "javafx-sdk-26.0.1" folder into the src folder and open the terminal
Change the directory to where the code files are located
cd ~/JavaFXEncryptor
//skip if no changed code
if changes are made in code 
Delete the ones that end with .class
find src -name "*.class" -delete
//....
then 
Compile the code(creates the .class files)
javac --module-path javafx-sdk-26.0.1/lib \
--add-modules javafx.controls,javafx.fxml \
$(find src -name "*.java")
then
Run the code (pop up two UI’s client and server)
java --module-path javafx-sdk-26.0.1/lib \
--add-modules javafx.controls,javafx.fxml \
-cp src ui.Main
</pre>
