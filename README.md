#Palindrome Application

This application detects the three longest palindromes in a word.

Previous notes:
1) The application was written in a Mac Book Pro, model of 2013, with macOS High Sierra.
2) Your System must have a Gradle installation. The application was written with Gradle's version 4.6.
3) Your system has to have Docker installation. 
    - Version used: Community edition: 18.03.0-ce-mac60
    - By default, the application will look for a Docker installation in the default address 127.0.0.1:2375.

Running instructions:
1) Clone the project in your local environment following the instruction below:
    
    ```
    git clone git@github.com:blecua84/palindrome-app.git
    ```
    
2) In the root of the new project, execute the following instruction:
    
    ```
    gradle docker
    ```
    
    After that, if you type in your terminal:
    
    ```
    docker images
    ```
    
    You can see the image below:
    
    ![Alt text](docker1.png?raw=true "Docker images")
    

3) The application is going to expose in the Docker container the 8080 port. We have to redirect this port in our local 
environment. We can use the same port or we can use another(in this example, we are using the 8085 port). The following 
instruction tell us how to launch the container:

    ```
    docker run -p 8085:8080 com.blecua84/palindrome-app
    ```
    
4) So, we can access to the application typing in our browser the next address:
    
    ```
    http://localhost:8085/palindromes/
    ```
    
    And now we can see the application running in our machine:
    
    ![Alt text](docker2.png?raw=true "Application view")
    
