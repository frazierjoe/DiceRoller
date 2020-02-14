# Dice Roller Project

**Android dice rolling app for viewing/displaying Gaussian Curves and the Law of Large Numbers**

The goal of this project was to practice creating/using Activities, Fragments, and Intents to create, maintain and display data throughout a session by creating a dice roller.

Upon opening the app, the user is prompted to enter a number of dice and the max value of the dice to roll.
<img src="https://github.com/frazierjoe/DiceRoller/blob/master/photos/Main.png" alt="Main Page" width="200px"/>

The user can enter any values that aren't zero or null. If the user attempts to roll zero or null they receive a toast telling them to enter a valid input. 

After entering valid inputs, the user is taken to the rolls activity and can view the value of the most recent roll, number of dice they entered and max value they entered.
<img src="https://github.com/frazierjoe/DiceRoller/blob/master/photos/Results.png" alt="Roll Activity" width="200px"/>

From here, the user can select to "See Results" to go to the result activity where the average value fragment is displayed and shows them the average value of their rolls.
<img src="https://github.com/frazierjoe/DiceRoller/blob/master/photos/Avg.png" alt="Average Roll" width="200px"/>

The result activity also hosts the highest value and lowest value fragments displaying the highest value and lowest value rolled thus far.
<img src="https://github.com/frazierjoe/DiceRoller/blob/master/photos/High.png" alt="Highest Roll" width="200px"/><img src="https://github.com/frazierjoe/DiceRoller/blob/master/photos/Low.png" alt="Lowest Roll" width="200px"/>

The user can then navigate back to the rolls activity and can click "See Graph" to vist the graph activity and view a historgram of thier rolls.
<img src="https://github.com/frazierjoe/DiceRoller/blob/master/photos/Hist2.png" alt="Histogram View" width="200px"/>

If the user would like to see the Law of Large Numbers in action they can navigate back to the rolls activity and click the "reroll" or "x100" buttons to roll more. After a few hundered trial clicking the "See Graph" button will result in a histogram simialar to the one below.
<img src="https://github.com/frazierjoe/DiceRoller/blob/master/photos/HistMany.png" alt="Histogram View" width="200px"/>

If the user would like to use a different value or number of dice, they can click the "Clear" button on the main activity to clear all previous data. A toast will appear telling the user they have cleared their data.
<img src="https://github.com/frazierjoe/DiceRoller/blob/master/photos/Clear.png" alt="Clear" width="200px"/>

Using dice with a larger value will result in a graph as below.
<img src="https://github.com/frazierjoe/DiceRoller/blob/master/photos/HistLarge.png" alt="Histogram View" width="200px"/>


__This was the second project for CSE-438 (Mobile App Development) Spring 2020__
