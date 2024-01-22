[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/x6ckGcN8)
# 3500 PA05 Project Repo

[PA Write Up](https://markefontenot.notion.site/PA-05-8263d28a81a7473d8372c6579abd6481)

[Week View Gui](
https://github.com/CS-3500-OOD/pa05-can/blob/4d177a411f14b4321bf540d2fcdcea99918bd880/WeekViewGui.jpeg)

Final Week View Gui: https://github.com/CS-3500-OOD/pa05-can/blob/main/FinalGui.jpeg


Our program showcases a calendar app to help you sort your day-to-day activities to keep you organized! Your week is displayed with sections allowing you to enter significant events and the tasks you need to do. You can even set a maximum number of events/tasks per day to ensure you do not overwhelm yourself. You can open a new bujo file to save your progress or open an old one to load your tasks and events. If the whole week is too much to see at once, you can see your tasks in a convenient sidebar. Our program is also customizable as you can choose from our preset themes or make a variation of your own. If you need extra motivation you can get it by seeing your progress bar, you’ll get energy for a second push. We also added a section where you can add anything significant to act as a reminder in quotes/notes. You can also see your stats on the side in your weekly overview. If you have any specific links you need to access, feel free to add and open them directly in our program. Enjoy your newfound organization!

We adhere to SOLID principles throughout our entire program.

We adhere to the single responsibility principles by having a surplus of classes with their own individual responsibility. In each class, the methods relate to the class responsibility as well as having their own individual purposes.

We adhere to the Open Closed principle by implementing interfaces and not modifying them besides their implemented methods.

We adhere to the Liskov substitution principle by all of our subclasses working in the same way as their superclasses without messing up the program.

The interface segregation principle is used by having all methods in our interfaces used.

We used the dependency inversion principle throughout as our high-level modules use abstraction as opposed to depending on low-level modules.


There are a multitude of ways to implement different features if we were to continue our program. This could be done in a mini viewer. Our program is set up to do so in the bullet control if we added the necessary buttons and event handlers to do this. We also have proper interfaces that can handle future events involving writing to files and reading files.