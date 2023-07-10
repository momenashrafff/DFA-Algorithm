# DFA-Algorithm

This repository contains an implementation of the DFA (Deterministic Finite Automaton) algorithm in Java. DFA is a mathematical model used in computer science and automata theory to recognize and process strings based on a set of states and transitions.

## Usage

To use the DFA algorithm, follow the instructions below:

1. Define the states of the DFA by providing a semicolon-separated list of state names. The states should be specified before the first hashtag (#).

2. Define the alphabet symbols of the DFA by providing a semicolon-separated list of symbols. The symbols should be specified after the first hashtag and before the second hashtag.

3. Define the transitions of the DFA by providing a semicolon-separated list of transitions. Each transition consists of three elements separated by commas: the current state, the current symbol of the input string, and the next state. Transitions should be specified after the second hashtag and before the third hashtag. Multiple transitions can be defined for different state-symbol combinations.

4. Specify the start state of the DFA after the third hashtag.

5. Specify the accept states of the DFA after the last hashtag. Accept states are separated by semicolons.

Below is an example of how to use the DFA algorithm in the `Main` class:

```java
public class Main {
    public static void main(String[] args) {
        String parse = "q0;q1;d#0;1#q0,0,d;q0,1,q1;q1,0,q0;q1,1,q0;d,0,d;d,1,d#q0#q0;q1";
        DFA dfa1 = generateDFA(parse);
        System.out.println(dfa1.isLanguageDFA("abab"));       // Output: Rejected
        System.out.println(dfa1.isLanguageDFA("10111011"));  // Output: Accepted
        System.out.println(dfa1.isLanguageDFA(""));           // Output: Accepted
        System.out.println(dfa1.isLanguageDFA("10011110"));  // Output: Rejected
    }
}
```
In the example above, a DFA object `dfa1` is created by parsing the provided string input using the `generateDFA` method. The `isLanguageDFA` method is then used to check if various input strings are accepted by the DFA. The results ("Accepted" or "Rejected") are printed to the console.

## Classes

### Main
The `Main` class is the entry point of the program. It demonstrates how to use the DFA algorithm by creating a DFA object, `dfa1`, and using the `isLanguageDFA` method to check if various input strings are accepted by the DFA. The results are printed to the console.

The `Main` class provides the following methods:

- `generateDFA`: Parses the input string to create a DFA object.
- `main`: The main method where the DFA object is created, and the `isLanguageDFA` method is used to check input strings.

### Transition
The `Transition` class represents a transition in the DFA. It has three properties: `currentState`, `nextState`, and `input`. Transitions can be printed using the `printTransition` method.

### DFA
The `DFA` class represents a Deterministic Finite Automaton. It has the following properties:

- `states`: An ArrayList of strings representing the states of the DFA.
- `alphabet`: An ArrayList of strings representing the alphabet symbols of the DFA.
- `transitions`: An ArrayList of `Transition` objects representing the transitions of the DFA.
- `startState`: A string representing the start state of the DFA.
- `acceptStates`: An ArrayList of strings representing the accept states of the DFA.

The `DFA` class provides the following methods:

- `display`: Prints the states, alphabet, transitions, start state, and accept states of the DFA.
- `isLanguageDFA`: Determines if a given input string is accepted by the DFA.
- `mergeDFA`: Merges two DFAs together based on the specified operation (union or intersection).
