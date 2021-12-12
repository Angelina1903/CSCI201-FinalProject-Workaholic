# CSCI201-FinalProject-Workaholic

## Description ##

Web app for team collaboration. Users would be allowed to sign in as a team member or a team leader. All users share the same task dashboard and only leaders can assign new tasks to the dashoard as well as marking the urgency level.

Guests have limited uses of application.

## Runnning the Project
Step 1:
- Download and install IntelliJ (Community)
- Go to plugin in intelliJ, find Spring Assistant and install
- Pull the project from Github and import into intellij
- Trust project if an alert pops up

Step 2:
- Find application.properties under src/resources
- Find spring.dataresources.password = … , and change the value into your mySQL
password

Step 3: Do so if mySQL has not been set up
- Go to terminal and enter %open ~/.zshrc
- Paste the following line into the window that the previous command opens
- export PATH=${PATH}:/usr/local/mysql/bin/
- Then try restart your environment variables with the following command
- source ~/.zshrc #If you use Oh-My-Zsh
- source ~/.bashrc #If you use Default Bash

Step 4:
- Open a new terminal window and enter the following command
- mysql -u root -p
- create database codejavadb; // this command creates the database needed for
the application

Step 5:
- To run the project, you can either
1. Go to the terminal inside intelliJ and run with ./mvnw spring-boot:run
2. Click on the build button and then the run button of IntelliJ ide. Then go to
main/java/net.codejava/WorkaholicApplication and click the green triangle to run
The initial run will take some extra time to build all packages

Step 6:
- Go to browser and and type in http://localhost:8080/ to access the web
