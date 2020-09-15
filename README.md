# MiniGameProject
A project of mini game given to me by my friend to show java language knowledge.
<br><br>
<img src="https://raw.githubusercontent.com/KashPiasecki/KashPiasecki/master/images/dice-147157_640.png" alt="Game"><br>
<!-- Find out the average euro value rewarded when playing one round of this game, using a
simulation on 10 million rounds. -->
Ruleset:
Consider a mini-game.
The player sees 12 boxes. They open box after box until a "Game over sign" appears.
The boxes contain various rewards that are randomly divided between the boxes.
The contents are:
* 1x €100;
* 2x €20;
* 5x €5;
* 1x "Extra life". If one of these boxes are awarded, the next "Game over sign" is nullified.
* 3x "Game over sign" - ends the game.

When the game is over, the player gets an additional reward. It is chosen randomly from four options:
* €5 
* €10
* €20
* "Second chance" - return to the game in the previous state.

The next time the game finishes, the "Second chance" option is disabled (only the three
above options are available)
Technical requirements:
Use an object-oriented approach with the Java programming language;
Maven;
Junit;
