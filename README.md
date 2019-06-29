# API_Testing
This repository is containing the API automation project

Prerequisite:
Maven plugin, jar, jdk 1.8 installed and configured

Project details:
1. This is a maven project.

2. Dependencies are given in pom.xml

3. Due to proxy settings and if required than you may need to create settings.xml. Drop it into your .m2 folder and finally set its path in Preferences-->Maven-->User Settings.
OR
Alternatively, please add all the jar files in Java Build Path as mentioned in the pom.xml file.

4. Packages/Classes/Resources details.

a) scripts: this package has class named as "Assessment". This class contains 3 test cases for 3 verifications. To execute test cases, please run this class as TestNG Test. After execution, TestNG report (index.html) will be created in test-output folder.

b) filehandling : this package has class named as "PropertyFileHandler". Functions has been written to read the properties file.

c) common: this package has class named as "CommonActions". This class contains 2 functions. Please read their description inside the class.

d) resource: this folder has prop.properties file which stores the JSON key

Please let me know if you have any query.
