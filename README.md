# CSE-511 Data Procesing At Scale -  Phase2
This phase contains the development two types of spatial data analysis: 1) Hot zone analysis and 2) hot cell/hotspot analysis.
The project's overall instructions are provided below.
* Step 1: Set up wer Hadoop and Apache Spark test environment. The following setup instructions are specific to Ubuntu operating system.
spark_ubuntu_install
* Step 2: Complete the Hotspot Analysis programming assignment, including submitting wer own hotspot source code as a .jar file. 
* Step 3: Write and submit wer project report detailing wer work on this work.

In this project, we are required to do spatial hot spot analysis. In particular, we need to complete two different hot spot analysis tasks.
* Hot zone analysis
This task will need to perform a range join operation on a rectangle datasets and a point dataset. For each rectangle, the number of points located within the rectangle will be obtained. The hotter rectangle means that it includes more points. So this task is to calculate the hotness of all the rectangles.
Download the required templates here.
* Hot cell analysis
This task will focus on applying spatial statistics to spatio-temporal big data in order to identify statistically significant spatial hot spots using Apache Spark. The topic of this task is from ACM SIGSPATIAL GISCUP 2016.
The Problem Definition page is here: http://sigspatial2016.sigspatial.org/giscup2016/problem (Links to an external site.)
The Submit Format page is here: http://sigspatial2016.sigspatial.org/giscup2016/submit (Links to an external site.)
Special requirement (different from GIS CUP)
As stated in the Problem Definition page, in this task, we are asked to implement a Spark program to calculate the Getis-Ord statistic of NYC Taxi Trip datasets.
To reduce the computation power need, the following changes were made:
The input will be a monthly taxi trip dataset from 2009 - 2012. For example, "yellow_tripdata_2009-01_point.csv", "yellow_tripdata_2010-02_point.csv".
The following criteria is ensured for the analysis:
* Each cell unit size is 0.01 * 0.01 in terms of latitude and longitude degrees.
* One day should be used as the Time Step size. 
* The first day of a month is considered as step 1 and each month has 31 days.
* We only need to consider Pick-up Location.

### Coding template specification
Input parameters
Output path (Mandatory)
Task name: "hotzoneanalysis" or "hotcellanalysis"
Task parameters: (1) Hot zone (2 parameters): nyc taxi data path, zone path(2) Hot cell (1 parameter): nyc taxi data path
Example:
test/output hotzoneanalysis src/resources/point-hotzone.csv src/resources/zone-hotzone.csv hotcellanalysis src/resources/yellow_tripdata_2009-01_point.csv
##### Note:
The number/order of tasks do not matter.
But, the first 7 of our final test cases will be hot zone analysis, the last 8 will be hot cell analysis.
Input data format
The main function/entrace is "cse512.Entrance" scala file.
* Point data: the input point dataset is the pickup point of New York Taxi trip datasets. The data format of this phase is the original format of NYC taxi trip which is different from Phase 2. But the coding template already parsed it for we. Find the data in the .zip file below.
yellow_tripdata_2009-01_point.csv
* Zone data (only for hot zone analysis): at "src/resources/zone-hotzone" of the template
##### Hot zone analysis :
The input point data can be any small subset of NYC taxi dataset.
##### Hot cell analysis :
The input point data is a monthly NYC taxi trip dataset (2009-2012) like "yellow_tripdata_2009-01_point.csv"
### Output data format :
* Hot zone analysis : All zones with their count, sorted by "rectangle" string in an ascending order.
* The coordinates of top 50 hotest cells sorted by their G score in a descending order. Note, DO NOT OUTPUT G score.
| -7399 | 4075 | 15
| -7399 | 4075 | 29
| -7399 | 4075 | 22
### Testing the code in the Spark environment:
* Go to project root folder
* Run sbt clean assembly. You may need to install sbt in order to run this command.
* Find the packaged jar in "./target/scala-2.11/CSE511-Project-Hotspot-Analysis-Template-assembly-0.1.0.jar"
* Submit the jar to Spark using Spark command "./bin/spark-submit". A pseudo code example: ./bin/spark-submit
 ~/GitHub/CSE511-Project-Hotspot-Analysis-Template/target/scala-2.11/CSE511-Project-Hotspot-Analysis-Template-assembly-0.1.0.jar 
test/output hotzoneanalysis src/resources/point-hotzone.csv src/resources/zone-hotzone.csv hotcellanalysis src/resources/yellow_tripdata_2009-01_point.csv


