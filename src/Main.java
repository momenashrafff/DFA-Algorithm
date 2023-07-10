import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static DFA generateDFA(String parse) {
        String[] parts = parse.split("#");

        String[] statesStrings = parts[0].split(";");
        String[] alphabetStrings = parts[1].split(";");
        String[] transitionsStrings = parts[2].split(";");
        String[] acceptStatesStrings = parts[4].split(";");

        ArrayList<String> states = new ArrayList<>();
        Collections.addAll(states, statesStrings);

        ArrayList<String> alphabet = new ArrayList<>();
        Collections.addAll(alphabet, alphabetStrings);

        ArrayList<Transition> transitions = new ArrayList<>();
        for (String s : transitionsStrings) {
            String[] tmp = s.split(",");
            String currentState = tmp[0];
            String nextState = tmp[1];
            String input = tmp[2];
            Transition transition = new Transition(currentState,nextState,input);
            transitions.add(transition);
        }

        String startState = parts[3];

        ArrayList<String> acceptStates = new ArrayList<>();
        Collections.addAll(acceptStates, acceptStatesStrings);

        return new DFA(states,alphabet,transitions,startState,acceptStates);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String parse = "q0;q1;d#0;1#q0,0,d;q0,1,q1;q1,0,q0;q1,1,q0;d,0,d;d,1,d#q0#q0;q1";
        DFA dfa1 = generateDFA(parse);
        System.out.println(dfa1.isLanguageDFA("abab"));
        System.out.println(dfa1.isLanguageDFA("10111011"));
        System.out.println(dfa1.isLanguageDFA(""));
        System.out.println(dfa1.isLanguageDFA("10011110"));
    }
}
