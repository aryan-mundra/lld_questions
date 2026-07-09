

Building a logger system 
Understand the system



Gather requirements (Product point of view)
	1.	Logger system should have three types of logs debug , info and error
   2. there will be two env : sit and prod
        a) for sit all three types of log should be visible 
         b) for prod only info and error lots should be      
shown .
	3.	Timestamp and which type of logger it is should be printed on each logger


Build individual requirements (Developer point of view )

	1.	we will create enum class which contains debug info and error . Logger vo will be created which will have timestamp in it with this enum type also 
	2.	We will have envChecker.java : that will have a check if the env is prod and type is info then continue that log 
	3.	





Focused code 
