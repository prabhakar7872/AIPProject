# AIPProject :-- TIC TAC TOE GAME




1. INTRODUCTION	04
1.1 Overview of the Project	04
1.2 Purpose of the Project	04
2. System Requirements	05
2.1 Hardware Requirements	05
2.2Software Requirements	05
3. Implementation & Apache Server Setup.	06-08
4. Development of the Web page & Deployment	09-13
5. Testing and Evaluation.	14
6. Conclusion.	15
7. References	15
INTRODUCTION

Games have always been a source of entertainment, learning, and skill development. With the advancement of programming technologies, even classic games like Tic Tac Toe can be transformed into modern applications incorporating real-world functionality such as user authentication and persistent score tracking.
This project brings together the elements of Java programming, graphical user interface (GUI) development, and MySQL database integration to build a fully functional desktop-based Tic Tac Toe game. This application is designed for single-machine usage but demonstrates concepts applicable in broader software engineering contexts. Users can register, log in, and play games while their results are stored and displayed.
        1.1  Overview of the Project
This project is a Java Swing-based Tic Tac Toe game with user registration, login, and score tracking using a MySQL database. Users log in or register before playing, and each game result (Win/Lose/Draw) is stored with a timestamp. The application includes a game history view that displays scores in a table. Its modular design separates the game logic, UI, and database, making the system maintainable and scalable while reflecting real-world software integration.
        1.2  Purpose of the Project

The primary aim of this project is to demonstrate how a simple game can be enhanced by integrating core software development concepts such as:
            ▪ User registration and login authentication
            ▪ Game logic implementation using Java
            ▪ Graphical user interface development with Java Swing
            ▪ Database connectivity using JDBC
            ▪ Storing and retrieving data using MySQL
This project helps in understanding the practical implementation of CRUD operations, event handling, and data visualization within a game environment. It is particularly useful for students and developers who wish to learn how to combine frontend and backend technologies in a desktop application.
SYSTEM REQUIREMENTS

To develop and run the Tic Tac Toe game with user registration, login, and MySQL-based score tracking, certain hardware and software prerequisites are required. These requirements ensure that the application functions efficiently in a desktop environment and integrates seamlessly with the database.
        2.1  Hardware Requirements

            ▪ Processor: Intel Core i3 or higher
            ▪ RAM: Minimum 4 GB (8 GB recommended for smooth database operations)
            ▪ Storage: At least 500 MB of free disk space
            ▪ Display: Minimum resolution of 1024x768
            ▪ Input Devices: Keyboard and mouse for gameplay and form interaction
        2.2  Software Requirements

            ▪ Operating System: Windows, Linux (e.g., CentOS 9), or macOS
            ▪ Java Development Kit (JDK): Version 8 or above
            ▪ Java IDE: NetBeans, Eclipse, or IntelliJ IDEA (NetBeans recommended)
            ▪ MySQL Server: Version 5.7 or later
            ▪ JDBC Driver: MySQL Connector/J
            ▪ Apache Server (Optional): If deploying HTML components for registration externally
            ▪ Libraries Used:
                • javax.swing for GUI
                • java.sql for database interaction
                • java.util for date and time handling
IMPLEMENTATION & APACHE SERVER SETUP

To successfully implement the Tic Tac Toe game with user registration, login, and MySQL score tracking, both the software and hardware must be configured appropriately. The application is developed using Java Swing for the GUI and MySQL for managing user data and game results. Apache server setup is optional and can be used for deploying web-based components like an HTML registration page if needed.
The following setup ensures that the game runs smoothly and integrates all required features:
        3.1  Application Implementation Steps
            1. Create GUI using Java Swing
                • Build interactive interfaces for registration, login, and game window.
                • Use components like JTextField, JPasswordField, JButton, JTable etc.
            2. User Registration & Login Logic
                • Collect username and password using form fields.
                • Store new user data in a MySQL database using JDBC.
                • Authenticate users at login by matching credentials with the database records.
            3. Game Logic
                • Implement turn-based Tic Tac Toe logic with 2-player functionality.
                • Track win, lose, or draw conditions.

            4. Database Integration with JDBC
                • Use java.sql.Connection, PreparedStatement, and ResultSet for communication with MySQL.
                • Store each game's result with username, timestamp, and outcome.
                • Display game history using JTable.


            5. Modular Design
                • Separate classes for GUI, database operations, and game logic ensure code maintainability.

        3.2  Apache Server Setup (Optional for Web-Based Registration Page in NetBeans)
If you want to implement or simulate a web-based registration form in your Java desktop project using NetBeans, Apache server setup is optional and typically not required. However, if you're using NetBeans for web development (HTML/CSS/Servlets/JSP) and want to simulate a browser-based registration flow, follow these steps:
Using NetBeans for Web-Based Registration

            1. Create a New Web Application Project
                • Open NetBeans
                • Go to File > New Project > Java Web > Web Application
                • Name your project (e.g., TicTacToeWeb)
                • Select a server (Apache Tomcat or GlassFish; you can download one if not available)
            2. Add HTML/CSS Registration Form
                • Create an HTML file under Web Pages folder (e.g., register.html)
                • Design the form to collect user data (username, password)
            3. Link to a Servlet (Optional)
                • Add a servlet class to handle form submissions and store data into the database using JDBC
                • Example: RegisterServlet.java connects to MySQL and inserts user data
            4. Run the Project
                • Right-click the project → Run
                • NetBeans will host it on localhost (e.g., http://localhost:8080/TicTacToeWeb/register.html)
                • You can test registration in the browser
DEVELOPMENT OF THE WEB PAGE & DEPLOYMENT


        4.1  Development of the GUI Interface
In this project, instead of a traditional HTML web page, the graphical user interface (GUI) is developed using Java Swing components within the NetBeans IDE. The interface includes:
            ▪ Registration Page:
Built using JFrame, JLabel, JTextField, JPasswordField, and JButton. It collects user credentials for registration and stores them in a MySQL database.

            ▪ Login Page:
Accepts credentials, authenticates the user via JDBC, and provides access to the game window if verified.


            ▪ Tic Tac Toe Game Board:
Created using a 3x3 grid of JButtons with logic implemented for turn-taking, win/draw detection, and score updates.












            ▪ Game History Page:
Displays previously played games using JTable, with data fetched from the MySQL database.



















The design follows a modular structure, separating concerns:
            ▪ DatabaseConnection.java handles database interactions
            ▪ Registration.java and Login.java manage user-related interfaces
            ▪ TicTocGUI.java contains the game logic
            ▪ ScoreViewer.java (optional) shows score history
        4.2  Deployment Process
The project is deployed and run directly through NetBeans, with the following steps:
    1. Connect to MySQL Database
        ◦ Ensure MySQL Server is running
        ◦ Create a database and required tables (e.g., users, game_results)
        ◦ Use JDBC to connect (mysql-connector-j must be in your project libraries)

       
       
       
       
       
       
    2. Compile and Run
        ◦ Build the project using NetBeans (Clean and Build)
        ◦ Run the main class (TicToc.java)
        ◦ The application starts with the registration or login interface
    3. Data Storage
        ◦ All registered users and game results are stored in the database
        ◦ You can query the database externally or view history within the app



       




       
       
       
    4. Optional JAR Deployment
        ◦ If you want to share the app:
            ▪ Go to Build > Clean and Build Project
            ▪ Navigate to the /dist/ folder
            ▪ Run the .jar file using:
bash CopyEdit
java -jar TicTacToeApp.jar


TESTING AND EVALUATION
The Tic Tac Toe application was rigorously tested to ensure functional accuracy, performance, and user experience.
        5.1  Unit Testing
Each module was tested independently:
            ▪ Registration/Login: Validated user input and database insertion.
            ▪ Game Logic: Verified win, draw conditions, and correct turn switching.
            ▪ Score Tracking: Ensured game results were stored accurately in the database.
            ▪ History Viewer: Confirmed correct retrieval and display of past results.
        5.2  Integration Testing
Modules were tested together to ensure smooth flow:
            ▪ Successful login redirects to the game.
            ▪ Game outcomes are correctly saved in the database.
            ▪ User game history displays accurate records.
        5.3  User Acceptance Testing (UAT)
Sample users reported:
            ▪ Smooth gameplay and navigation
            ▪ No errors or crashes
            ▪ Simple and clean UI
        5.4  Summary
The application passed all tests. Its modular design and integration of GUI with database functions ensure maintainability and real-world applicability.
						CONCLUSION

The Tic Tac Toe project successfully demonstrates the integration of core software development concepts within a desktop application. By combining Java Swing for the graphical user interface, MySQL for persistent data storage, and JDBC for database connectivity, the project provides a real-world implementation of a complete CRUD-based system.
The inclusion of user registration, login, score tracking, and game history enhances the traditional game by adding functionality and user interactivity. The modular approach ensures that the application is easy to maintain and scalable for future enhancements, such as multiplayer modes or leaderboard integration.
Overall, this project not only delivers a functional and engaging game but also reflects practical experience in combining frontend and backend technologies, making it a valuable learning tool for aspiring developers.


REFERENCES
      GITHUB LINK: https://github.com/prabhakar7872/AIPProject.git
