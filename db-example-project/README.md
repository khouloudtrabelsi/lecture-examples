# Java Example Project for JDBC and ORMLite

A Maven project with basic functionality to illustrate the usage of JDBC and an ORM (ORMLite) with MariaDB.
The code expects a MariaDB server running on `localhost:3306` with a user `root` that has a password `root`.

You can edit the examples `JDBCExamples.java` and `ORMExamples.java` to solve the exercise, then run `Main.java`.
If you want to run the ORM example, you need to uncomment lines 13 and 14 in `Main.java`.

```bash
# run via Maven:
mvn clean install
java -jar ./target/db-lecture-examples.jar
```