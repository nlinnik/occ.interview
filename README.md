# occ.interview
Sample Project for OCC Interview 

Used IntelliJ IDEA to create with Java 11 

How to package: ./gradlew clean build 

How to run: 

    java -jar occ.interview-1.0-SNAPSHOT.jar {full path file name} 
    
    use IntelliJ run configuration for com.nlinnik.occ.interview.NameScoreApplication and pass {full path file name} in program arguments

Expected results - file contains [value]=[score] for each string(name) 

Expected results file name - {passed full path of the file with names}_scored - {total score}

