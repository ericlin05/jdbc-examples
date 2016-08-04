# Examples on how to connect to Hive and Impala through Cloudera's JDBC Driver

Firstly you will need to download Cloudera's Impala and Hive JDBC Drivers. I have setup a script to do this for you, simply run:

```
./setup-jdbc.sh
```

and the Drivers will be installed under jars directory of the project

Then you will need to install both downloaded Drivers into maven so that they can be added to project's dependencies:

```
mvn initialize
```

And then compile the project:

```
mvn clean compile
```

To run Hive examples:

```
mvn exec:java -Dexec.mainClass=com.example.ClouderaJDBCHiveExample
```

And Impala examples:

```
mvn exec:java -Dexec.mainClass=com.example.ClouderaJDBCImpalaExample
```
