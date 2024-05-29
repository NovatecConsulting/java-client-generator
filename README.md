# Getting Started

## Project Overview

This project demonstrates the creation of a SOAP web service using Spring Boot. The service provides book information based on a provided name. The project utilizes two libraries to generate Java clients from an XSD file (`books.xsd`) and a WSDL file (`BookService.wsdl`).

## Maven Plugins Configuration

### XSD to Java Client

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>jaxb2-maven-plugin</artifactId>
    <version>${jaxb2-maven-plugin.version}</version>
    <executions>
        <execution>
            <id>xjc</id>
            <goals>
                <goal>xjc</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <sources>
            <source>src/main/resources/wsdl/books.xsd</source>
        </sources>
        <outputDirectory>src/main/java</outputDirectory>
        <clearOutputDir>false</clearOutputDir>
    </configuration>
</plugin>
```

### WSDL to Java Client

```xml
<plugin>
    <groupId>org.jvnet.jaxb</groupId>
    <artifactId>jaxb-maven-plugin</artifactId>
    <version>${jaxb-maven-plugin.version}</version>
    <executions>
        <execution>
            <goals>
                <goal>generate</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <schemaLanguage>WSDL</schemaLanguage>
        <generateDirectory>${project.basedir}/src/main/java</generateDirectory>
        <generatePackage>com.novatec.wsdljavaclientgenerator.client.gen</generatePackage>
        <schemaDirectory>${project.basedir}/src/main/resources/wsdl</schemaDirectory>
        <noFileHeader>true</noFileHeader>
        <schemaIncludes>
            <include>BookService.wsdl</include>
        </schemaIncludes>
    </configuration>
</plugin>
```

### Generating Java Clients

To generate the Java clients from the XSD and WSDL files, run the following Maven command:

```
mvn clean install
```

### Running the Application

To start the Spring Boot application, use the following Maven command:

```
mvn spring-boot:run
```

The application will start and be accessible at:

http://localhost:8080/ws/books.wsdl

### Testing the SOAP Request
To test the SOAP web service, follow these steps:

1. Install the Wizdler plugin for Chrome or Firefox from the following link:

    Wizdler for Chrome: https://chromewebstore.google.com/detail/wizdler/oebpmncolmhiapingjaagmapififiakb?pli=1

2. Open the following URL in your browser:
   http://localhost:8080/ws/books.wsdl
3. Click on the Wizdler plugin icon and open the "Send Request" page.
4. Copy and paste the following SOAP request into the request editor:

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
xmlns:gs="http://www.novatec.com/wsdljavaclientgenerator/gen">
<soapenv:Header/>
<soapenv:Body>
<gs:getBookRequest>
<gs:name>The Great Gatsby</gs:name>
</gs:getBookRequest>
</soapenv:Body>
</soapenv:Envelope>
```

5. Send the request. If everything is configured correctly, you should receive the following response:

```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
<SOAP-ENV:Header/>
<SOAP-ENV:Body>
<ns2:getBookResponse xmlns:ns2="http://www.novatec.com/wsdljavaclientgenerator/gen">
<ns2:book>
<ns2:title>The Great Gatsby</ns2:title>
<ns2:author>F. Scott Fitzgerald</ns2:author>
</ns2:book>
</ns2:getBookResponse>
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
