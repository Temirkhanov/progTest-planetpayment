# Test Program
This program reads users' records from a txt file sorts, formats and then outputs all the records to another text file. 

## About
Required fields for each record:
* First name
* Last name
* Start date

Default values:
* State -> CA
* Country -> USA

**_Note:_** If any of the fields are missing, there should still be a separator.
*_ _Example:_ _ 

> Ron,Warner,20170403,123 Bentf Ave,Building 6,Wornstown,CA,USA,45312

> Ron,Warner,20170403,123 Bentf Ave,Building 6,,CA,USA,45312

Included txt files with dummy entries:
- input1.txt - record formated with spaces.
- input2.txt - records formatted with commas.

Types of sort:
* 1 - first name
* 2 - last name
* Any other integer - date

## How to run
Pull this repository. Change the input files if desired.
In the terminal/cmd navigate to the folder with jar and input files.

Example of running this program with input file **input1.txt** and sort type **2**
```bash
java -jar progTest.jar input1.txt 2
```
