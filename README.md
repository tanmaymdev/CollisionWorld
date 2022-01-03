Slip Day - 1 
Heroku App -->https://tm67-hw4-collision.herokuapp.com/
Design Decisions:

Design Decisions Taken to make the Application Robust and extensible:

Across the application:

1. Factory Design Pattern has been used to make Balls, Strategies and Collision Strategies. This helps in making the code highly extensible and modular.
2. Command Design Pattern has been used to execute Canvas state update, making the state update  seamless.
3. To make the user experience more enriching and customised , user is provided with options to highly customise the type,behavior and collision strategy of the object which they want to create.
4. User has full option to create switchable and removable objects as per his/her liking. Rather than hardcoding which balls can be removed , user is given option to choose which balls he/she wants to remove at a later point while creating the ball.
5. To ensure robustness Null Objects have been created to avoid null pointer exceptions
6. No logic is mainted in the controller and dispatch adapter is used to maintain communication with the model , controller and from there to view
7. Additional details have been provided to the user in the View so that they can better understand the application and make good use of it.
8. Varitions strategies have been created in based on 4 core properties of the Ball Object, this shows the extensibility of the code.
9. Composite Design has been used to full effect, it helped in creating multiple unique behaviors by blending the individual behaviors using Composite Design.
10. PropertyChange Listerns and PropertyChange Support were used to good effect by implementing them in Command Design Pattern.
11. Location of the Random Point for the Shape creation is kept in check so that shapes don’t go out of bound (Inside 8% of the canvas). Same goes for randomly selecting size giving size of Object.
12. Semantics were taken into consideration while designing the strategies especially for Fish for example Rotation of Fish and collision with Walls. Fish cannot just hit a wall and return 180 at the same location, so there was changes done to its location in order to give it a real world feel.
13. Design decisions were driven by the user experience and required modulation/change were done in models to accomodate the same. For ex. Giving Radio buttons to select the Switchable behavior, Removable Behvior and giving dropdowns to users to select the required startegies to handle such customised behavior model's functionality for extended all such features.
<br/>
14.Strategies were designed based on the semantics of the collision world. Ball to Ball interaction, Fish avoids Balls.
<br/>
15.Different type of Collision scenarios have been treated, for example it not necessary that in all collision balls bounce of each other and go in different direction in some they just pass over each other but provide a different kind on impact on the other Ball (could be color change, could be size change or could be strategy change).
