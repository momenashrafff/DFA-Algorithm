import java.util.*;

public class DFA {

    ArrayList<String> states;
    ArrayList<String> alphabet;
    ArrayList<Transition> transitions;
    String startState;
    ArrayList<String> acceptStates;

    public DFA(ArrayList<String> states, ArrayList<String> alphabet, ArrayList<Transition> transitions,
               String startState, ArrayList<String> acceptStates) {

        this.states = states;
        this.alphabet = alphabet;
        this.transitions = transitions;
        this.startState = startState;
        this.acceptStates = acceptStates;

    }

    public void display() {
        System.out.println("states");
        System.out.println(this.states);
        System.out.println("alphabet");
        System.out.println(this.alphabet);
        System.out.println("transition states");
        for (Transition trans : this.transitions) {
            trans.printTransition();
        }
        System.out.println("startState");
        System.out.println(this.startState);
        System.out.println("acceptStates");
        System.out.println(this.acceptStates);
    }

    public String isLanguageDFA(String input) {
        String currState = startState;
        for (int i = 0; i < input.length(); i++) {
            boolean foundTransition = false;
            String s = "" + input.charAt(i);
            if (!alphabet.contains(s))
                return "Invalid String";

            for (Transition t : transitions) {
                if (t.input.equals(s) && t.currentState.contains(currState)) {
                    currState = t.nextState;
                    foundTransition = true;
                    break;
                }
            }
            if (!foundTransition)
                return "Rejected";
        }
        if (acceptStates.contains(currState))
            return "Accepted";
        return "Rejected";
    }
    public DFA mergeDFA(DFA secondDFA, boolean isUnion) {
        ArrayList<String> newStates = new ArrayList<>();
        ArrayList<Transition> newTransitions = new ArrayList<>();
        ArrayList<String> newAcceptStates = new ArrayList<>();

        String newStartState = "{" + this.startState + "," + secondDFA.startState + "}";
        newStates.add(newStartState);

        int index = 0;
        while (index < newStates.size()) {
            String currentStatePair = newStates.get(index);
            String[] currentStateSplit = currentStatePair.substring(1, currentStatePair.length() - 1).split(",");
            String state1 = currentStateSplit[0];
            String state2 = currentStateSplit[1];

            if (isUnion) {
                if (this.acceptStates.contains(state1) || secondDFA.acceptStates.contains(state2)) {
                    newAcceptStates.add(currentStatePair);
                }
            } else {
                if (this.acceptStates.contains(state1) && secondDFA.acceptStates.contains(state2)) {
                    newAcceptStates.add(currentStatePair);
                }
            }

            for (String inputSymbol : this.alphabet) {
                String nextState1 = this.getNextState(state1, inputSymbol);
                String nextState2 = secondDFA.getNextState(state2, inputSymbol);
                String nextStatePair = "{" + nextState1 + "," + nextState2 + "}";

                newTransitions.add(new Transition(currentStatePair, inputSymbol, nextStatePair));

                if (!newStates.contains(nextStatePair)) {
                    newStates.add(nextStatePair);
                }
            }

            index++;
        }

        return new DFA(newStates, this.alphabet, newTransitions, newStartState, newAcceptStates);
    }
    public String getNextState(String currentState, String input) {
        for (Transition t : this.transitions) {
            if (t.currentState.equals(currentState) && t.input.equals(input)) {
                return t.nextState;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String parse = "q0;q1;d#0;1#q0,0,d;q0,1,q1;q1,0,q0;q1,1,q0;d,0,d;d,1,d#q0#q0;q1";
        DFA dfa1 = Main.generateDFA(parse);

        String parse2 = "s0;s1;s2;s3#0;1#s0,0,s2;s0,1,s1;s1,0,s3;s1,1,s3;s2,0,s1;s2,1,s1;s3,0,s1;s3,1,s1#s0#s2;s3";
        DFA dfa2 = Main.generateDFA(parse2);

        DFA mergedDFA = dfa1.mergeDFA(dfa2, true);
        mergedDFA.display();
    }

}
