# Example of the Spring application with DBUnit and Mockito test
 
Only model layer of MVC design pattern is presented in this example. Model contains **service** and **dao** packages, 
where service uses dao objects to access data, stored in Oracle Database. This example is very simplified version of Airbnb, where we have users
and apartments. User could do login, register, restore password and update his info operations. Also user could see the list of available apartments,
find apartment by title and by different criterias.


## [DAO layer](https://github.com/hustlestar/spring-dbunit-mockito-example/tree/master/src/main/java/com/hustlestar/airbnb/dao)
Uses dbcp pool to get connection with database and uses Spring JDBC to make queries. This layer is covered with [Spring DBUnit](https://github.com/springtestdbunit/spring-test-dbunit) tests,
which are stored [here](https://github.com/hustlestar/spring-dbunit-mockito-example/tree/master/src/test/java/dao).

## [Service layer](https://github.com/hustlestar/spring-dbunit-mockito-example/tree/master/src/main/java/com/hustlestar/airbnb/service)
Has simple validation of data and mostly does dao calls. This layer is covered with [Mockito tests](https://github.com/mockito/mockito), which
are stored [here](https://github.com/hustlestar/spring-dbunit-mockito-example/tree/master/src/test/java/service).

###Motivation
I'm new to Mockito and DBUnit so I wanted to create simple example of using these libraries, which could be helpful for those who are striving to get strated
with them. If you have any questions, I'd be glad to answer, feel free to mail me at z4zolton@gmail.com
