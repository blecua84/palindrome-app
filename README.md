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
    