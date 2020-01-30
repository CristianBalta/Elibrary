# team-project-elibrary
team-project-elibrary created by GitHub Classroom
Team
    •	Patrick Pop
    •	Cristian Balta
    •	Ovidiu Todea
    •	Lucia Jurj
    •	Tudor Hosu
Main goal
      •	Develop an eLibrary where the end users can check the availability of the books in store. 
      Security & Access
      •	There are two types of users in the system: Reader & Admin
      •	Both users are able to search for books based on author, book name or other criteria.
      •	Readers
      o	They should have limited and read-only access to the system. 
      o	They should be able to view their member profile and the list of the borrowed books.
      •	Admins 
      o	They should be able to enter and update book/author data and enter an entry in the table of loans. 
      o	They should also be able to search for the list of borrowed books per user.
      Persistance
      •	All entities should be read from files. Input parameters can be read from console.
UI
      •	Write a console application in which the user should log in via username and based on his role (Admin or Reader) to be given a menu in which to choose what is the operation he wants to run. 
      Business requirements
      Query the system as to show: 
      •	Admin:
      o	the user who borrowed the most books in the last 6 months
      o	add a loan to the list of borrowed books
      o	given a user, show thh most common day of the week when he borrowed books
      •	Reader:
      o	user profile for the currently logged in user
      •	Both roles: 
      o	top 5 books as per number of people who borrowed them 
      o	the most read author 
      o	given the author name, search for his most popular books 
Technical details
      •	The output of the queries should be printed in output.txt file.
      •	Treat exception in case unexpected inputs are provided.
      •	Use github classroom for version control
      o	Be very careful when you create the team, only one team: eLibrary
      o	If there is already an existing one, please join to it and don't create a new one
      o	Group Assignment: https://classroom.github.com/g/RK83PZyH
Optional
      •	Use two design patterns in your system and take extra care about OOP principles.
      •	Create the UML diagrams for the classes.
      •	Use local jenkins and run the build via Maven.
      •	Create a branch for each member of the team. Merge the changes to the main branch via pull requests, but make sure the branch is being merged only after at least one member of the team has reviewd the changes.
