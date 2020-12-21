# Problem Statement - AG School

The final exams of class IX of the AG School have concluded and the evaluation of the answer scripts is underway. The marks entry for each student must be made into an application. 

Write a Java program to enable the operations team of the school to enter marks and publish results. In this challenge, the following are the requirements:

### Task 1

1.	The number of students for whom marks entry needs to be done should be provided as an input from the user
2.	The Name and Roll Number of each student should be taken as input from the user and stored for easy retrieval.
3.	The students of class IX have been evaluated on the following subjects:
    -	Math
    -	Science
    -	English
    -	Language
    -	Social Studies

The marks in each of the subject should be taken as input from the user and stored. Please note that the marks scored can have up to two digits after the decimal point.
4.	The application should be able:

- Find the total marks scored by each student and store them.
- Find the top scorer in the class and display his name and Roll Number on the screen.
- Find the average marks of the students in the class in each subject and store them.
- Find the number of students who have cleared the examination and display their name and Roll No.

### Task 2
- Find the number of students who needs to mandatorily repeat the examination and display their name and Roll No.
The pass mark for each subject is 35, which means that to pass the exam, a student needs to score at least 35 in all of the five subjects. 

### Task 3

- Based on average marks scored, each student is graded. The grading strategy is as follows:
- Average Marks >=95 -- 'A'
- Average Marks >=80 and <90 -- 'B'
- Average Marks >=70 and <80 -- 'C'
- Average Marks >=60 and <70 -- 'D'
- Average Marks >=50 and <60 -- 'E'
- Average Marks <50 -- 'F'

### Task 4

Generate the grade, store it and display the grade for each student along with their total and average marks.
2.	the list should be sorted based on the grade in ascending order. 
3.	Generate a score card for a student based on his Roll No. which should contain the following details:
    - Name
    - Roll No.
    - Subject names and marks
    - Total marks obtained
    - Grade achieved

### Task 5

•	Plot a histogram using asterisk('*') symbol to show the average marks scored by each student distribution of the class.

## Sample Output

```
100
 90  *
 80  *  *           *     *
 70  *  *     *     *  *  *  *
 60  *  *  *  *     *  *  *  *  *
 50  *  *  *  *  *  *  *  *  *  *
 40  *  *  *  *  *  *  *  *  *  *
 30  *  *  *  *  *  *  *  *  *  *
 20  *  *  *  *  *  *  *  *  *  *
 10  *  *  *  *  *  *  *  *  *  *
     1  2  3  4  5  6  7  8  9 10

```

#### Note:
> The information related to the student should be stored in a > class and appropriate methods to be used to find total marks, > average marks, status, grade and to print a score card


