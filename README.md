## What web scraping
It is a project that presents web scraping, a technique that allows you to collect website data, to collect data in mass it is a good practice (but not for the servers of the scrapper sites, because the scraping is hard test the servers in particular on the number of requests that can be sent by a scrap program). scraping is often classified as theft of giving but how can one steal what is made public that anyone can copy and paste and use afterwards (the offense will be in the way in which the data is used? 'we collected). Web scraping is a very effective data collection technique.

## How to design a good web scraping program
1. Choosing a good programming language for my part I took java, but others like python, c #, etc ... will do well  
2. The choice of web browser is very important because you will be simulating a lot of actions that a normal user would have to do. There are two categories of browser: classic web browsers like Chrome, Mozilla and many more.the second  Category is headless browser, the specificity of this browser is that it has no graphical interface.
3. The output format of your data is very important to then be able to use it efficiently. The formats are multiple: just in text file, json, ... 

## How I made my scraper
I chose to use a classic web browser (with graphical interface) because I need to inject javascript for proper functioning. I took the notion of REST API and I can adapt it (I know how to adapt the word is a strong one, what I mean is that I replaced the database layer with the website resources and that we can only make calls in GET) to my code to have an output in JSON

## how to start the program
Install java and the apache tomcat server on your system, place the whois.war file in the webapps folder located in the tomcat installation folder (../tomcat/webapps), start the tomcat server and then with the link
localhost:your_port_number/whois/q?ipOrDomainName=your_ip_number.
You will have appros information of the IP or the domain name, the scrap program the whois site to have this information