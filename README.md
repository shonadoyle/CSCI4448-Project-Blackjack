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

