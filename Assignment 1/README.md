A conole application that consist of two main components, which are Tuition Management System (TMS) and an administrative component

The  administrative  section  will  allow,  through  text-based  menus,  the  login  and  logout  of  administrators,  the 
addition and removal of students in the system, the display of students records, the display of a certain student 
with name, and the update of student’s accounts. 
 
The TMS component will store a list of all the tuition information of the students and a list of the summary of 
the tuitions. The TMS component will also allow the creation and display of the collective tuition report as TMS 
record log. Finally, the TMS component will also handle the display of a certain student tuition information. 
 
Each student record will include the student’s ID, name, email, phone, address, type, credits, payPerCredit, 
scholarship, deduction, deductionRate, totalFee, netFee and faculty fields. 
 
Each tuition record will include the student’s name, scholarship, deduction, total tuition and net tuition. 

A class diagram has been drawn to better visualise the design of the system

<img width="485" alt="image" src="https://user-images.githubusercontent.com/48937488/209455602-8bc56537-2ec9-47e0-8dba-1435a648237c.png">

* Classes - The design consists of 8 classes:
  1. Session
  2. Faculty
  3. Faculties
  4. Student
  5. Students
  6. Slip
  7. TMS
  8. TMSLog
  
* Fields – All the fields have been clarified in each class and they should not be modified. The fields also have some additional requirements and structures:

    Lists all have the abstract type of List<>, but must be instantiated with a concrete type that implements the List<> behavior (you can choose either – you may also want to think about why you might do things this way).
