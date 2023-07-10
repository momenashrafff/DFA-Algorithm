# DFA Algorithm

This repository contains an implementation of the DFA (Deterministic Finite Automaton) algorithm developed as a University project at German International University (GIU).

## How to Use

To use the DFA algorithm, follow these steps:

1. Define the DFA properties:
   - Create an ArrayList of strings representing the states of the DFA.
   - Create an ArrayList of strings representing the input alphabet.
   - Create an ArrayList of Transition objects representing the state transitions.
   - Set a start state as a string.
   - Create an ArrayList of strings representing the accepting states of the DFA.

2. Create a DFA object by using the DFA class constructor and passing the defined properties as arguments.

3. Interact with the DFA using the available methods:
   - `display()`: Display the states, alphabet, transitions, start state, and accept states of the DFA.
   - `isLanguageDFA(input)`: Check if a given input string is accepted by the DFA.
   - `mergeDFA(secondDFA, isUnion)`: Merge the current DFA with another DFA, specifying the merge type as union or intersection.
   - `getNextState(currentState, input)`: Get the next state based on the current state and input symbol.

4. Use the main method for demonstration purposes or create custom test cases.

## Example

Here's an example of how to use the DFA algorithm:

```java
// Define the DFA properties
ArrayList<String> states = new ArrayList<>();
// Add states to the states ArrayList

ArrayList<String> alphabet = new ArrayList<>();
// Add input symbols to the alphabet ArrayList

ArrayList<Transition> transitions = new ArrayList<>();
// Create Transition objects to represent the state transitions

String startState = "q0";
// Set the start state of the DFA

ArrayList<String> acceptStates = new ArrayList<>();
// Add accepting states to the acceptStates ArrayList

// Create a DFA object
DFA dfa = new DFA(states, alphabet, transitions, startState, acceptStates);

// Use the available methods
dfa.display();

String input = "abab";
String result = dfa.isLanguageDFA(input);
System.out.println("Input: " + input);
System.out.println("Result: " + result);
