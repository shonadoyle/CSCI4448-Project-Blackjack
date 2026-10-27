# CSCI4448-Project-Blackjack

## Design Patterns

### 1. Strategy Pattern

The Strategy pattern controls automated players' decisions
to hit or stand. The DecisionStrategy interface defines
the shouldHit() method, while ConservativeStrategy and
DealerStrategy provide different implementations.

AutomatedPlayer receives a DecisionStrategy through
constructor-based dependency injection, allowing different
strategies to be used polymorphically without modifying
the AutomatedPlayer class.


### 2. Factory Pattern

The Factory pattern centralizes how players are created.
PlayerFactory provides createHumanPlayer(), createDealer(),
and createConservativePlayer(), so the code that sets up a
game never has to know which Player subclass or which
DecisionStrategy belongs to each kind of player.

For example, createDealer() always returns an AutomatedPlayer
injected with a DealerStrategy. If a new kind of player is
added later (for example, one with an aggressive strategy),
only PlayerFactory needs a new method; the Game class and the
rest of the setup code stay unchanged.

### 3. Observer Pattern

The Observer pattern lets other parts of the program react to
game events without the Game class depending on them. The
GameListener interface defines onCardDealt(), onPlayerStand(),
and onPlayerBust(). Game is the subject: it keeps a list of
listeners, registered through addListener() and
removeListener(), and notifies every listener whenever a card
is dealt or a player's turn ends.

ConsoleGameListener is the first concrete observer and prints
each event to the console. Later, other observers such as a
statistics tracker or a graphical display can be added by
implementing GameListener and registering them with Game,
without modifying Game itself.
