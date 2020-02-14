In this file you should include:

Any information you think we should know about your submission

Everything works and should be clear.
*NOTE - high numbers of dice/values/reroll clicks may cause the app to crash.




A description of the creative portion of the assignment
* Describe your feature

I created a histogram that show roll values on the x-axis and the number of rolls corresponding to each value on the y axis.

* Why did you choose this feature?

I chose to create this feature to learn how to create graphs and because it also shows the law of large numbers allowing the app to be applicable for more than just learning about craps.

* How did you implement it?

In order to implement this I used the chart and graph view for android (https://github.com/jjoe64/GraphView).
To create the graph, I 
1. Created an activity with a GraphView element in it and a corresponding kotlin class
2. Added a function to the class that uses a list of all individual rolls to add the totals of each set of rolls and place the results in a seperate results array
3. Looped through the results array and created data points which were appended to a series
4. Added the series to the graph and did some formatting of the graph
5. Added a x100 button next to the reroll button in rolls_activity.xml to allow the user to roll enough to see the formation of a Gaussian Curve
