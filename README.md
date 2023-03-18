# The University of Mississippi
# CSCI 112: Programming Project 3

Due Date: Thursday March 23 by 11:59 pm 

* Late programs will have points deducted. If your program does not compile, it will not receive any credit. If you need help, come see me, the class TA, or a department tutor during our office hours.

Titan communications is a national communications company with most of its branches in the South. They are wanting you to create and test new software. You will read data about employees from a file and ensure that any field of data can be changed.
 You are NOT building or adding onto Project 2, but making a completely new Project. There is also no Inheritance in this project, the relationships between the classes are aggregations.

### The classes you will need:

Employee – the attributes: a name, a position with the company, and a
salary.

Branch – the attributes: the location, the year the branch opened, and an
Employee list (an array or ArrayList, it is up to you).

Business – the attributes: a business name, and a Branch list (again an
array or ArrayList, it is up to you).

DriverP3 -  The driver should not have any methods other than the main
and should not have the logic to make changes except for the Business name. Your driver should have a Business Object (none of the other classes should be instantiated in the Driver).
	
Junit test classes with necessary tests methods for each Object class
(does not include the Driver).

### Your program will need to:

Keep all attributes safe

read from the provided file and pass the data to create a Business with Branch’s including their Employees.

print Welcoming and Good-bye messages

allow the user to modify (change) any value stored by the Business, Branch, or Employee classes (e.g., any name, location, etc..), and the ability to remove an Employee from a Branch. These will require methods (some you will have already made by simply writing the normal methods of a class). 

be able to print all the info about the Business, Branch’s, and Employees as many times as the user wants to or to exit the program.

The text file:

The file “TitanCommunication.txt” is provided for you. It contains the Branch’s and Employee data.

You are only reading from the file not writing back to it. All changes to the data are made while the program is running and only to what the variables store, not the text file.
	
