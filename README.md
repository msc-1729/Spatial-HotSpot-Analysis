<h2 align="center"> Spatial HotSpot Analysis </h2>

#### Introduction

In this project, we performed spatial hot spot data analysis over the recorded dataset of NYC taxis from
2009 to 2012. The implementation was done through Scala and SparkSQL, and two types of analysis
were performed: hot zone and hot cells.

#### Hotzone Analysis

This analysis examines dataset records to identify the demand associated with different regions. A
proof-of-concept of what the Hot Zone Analysis looks like is shown in Figure 1, which displays four
rectangles and several points within each of them. For proper analysis, we count the geographical points
associated with each zone. As a result, areas with higher demands are considered Hot Zones.
Throughout this project, we examined the data of taxis' pickup locations through rectangular regions in
NYC and identified hot zones. As a result, business personnel can adjust the offered services accordingly
to increase profit or meet expectations later on.

<img src = "https://github.com/msc-1729/Spatial-HotSpot-Analysis/blob/main/assets/hot%20zone.png" />

#### Hot Cell Analysis:
We applied spatial statistical analysis to determine statistically significant spatial hotspots. We utilized a statistical metric known as the Getis-ord statistic (Gi* score) to determine this. The following sections include more information about this analysis.

#### Implementation :
Parameters: SparkSession spark, String point path </br>
Return data: Sorted data frame denoting cells and their hotness
1. By adding time dimensions to the data points, they are turned into spatiotemporal cubes.
2. The x-axis indicates latitude, the y-axis represents longitude, and the z-axis represents the time dimension
in the spatial cube.
3. The mean and standard deviation of the spatial-temporal points must be calculated in order to determine
the z score.
4. We figure out if the point is inside the cube, as well as the cell's neighbors.
5. Using spark-sql, we get the z-score values in descending order.

#### Testing:
1. Go to the main directory in the cmd prompt and run the command sbt assembly.
2. This will result in the creation of a jar file in the target folder.
3. Copy this jar file into the main folder.
4. Run the command spark-submit command as given in the canvas.
5. Executing this command will create a test folder with four output* subfolders with the desired csv
output files.



