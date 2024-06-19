Refactoring Solution
===================================

Based on the game rules defined in this kata, here is how I would model the scoring system:

![Class Diagram](https://raw.githubusercontent.com/Julien-Fischer/Yatzy-Refactoring-Kata/main/java/src/main/resources/images/yatzy_model.png)

## Architectural choices

1. A dice roll is defined as a probability distribution, with integers 
being the concrete outcomes in our case. There is no need for a Die class.

2. Each category is designed as a strategy. Strategies are distributed by a factory 
based on the name of a category given as input. Since they are stateless, the factory
will reuse the same strategy instances over and over during the lifecycle of the application.

3. The layers communicate through dependency injection for better testability and modularity.

4. The abstractions are designed to be as agnostic of the game as possible; the specific rules
of this version of Yatzy are implemented in the concrete classes.


