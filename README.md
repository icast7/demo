This JAVA project implements the TFTP Protocol (RFC 1350) and front ends it with a RESTful WS.

- This project is developed in eclipse, all depencies are includeed in here but you might need to map the location of the JDK on your machine. JDL 1.7.* is required. Future releases will inlcude a maven pom for building the project.

Packages:
com.ikaz.demo.tftp.service: Contains a simple jersey-based RESTful WS with a CRUD API to interact with the TFTP Server.
com.ikaz.demo.tftp.net.Util.TFTPPackets: Contains classes that represent the TFTP packets defined on the RFC.
com.ikaz.demo.tftp.net.Util: Contains a utility classes for the TFTP implementation

Packages (Work In Progress):
com.ikaz.demo.tftp.net.Server: Contains a netty based TFTP Server implementation
com.ikaz.demo.tftp.net.Client: Contains a netty based TFTP Client implementation
