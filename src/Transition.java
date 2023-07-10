public class Transition {

    String currentState;
    String nextState;
    String input;

    public Transition(String currentState , String input , String nextState ) {

        this.currentState = currentState;
        this.nextState = nextState;
        this.input = input;

    }

    public void printTransition() {

        System.out.println(  "("+ this.currentState  + ","  + this.input   + "," + this.nextState + ")"  );

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stube
        Transition x = new Transition("s0" , "a" , "s1");
        System.out.println("DFA Transition");
        x.printTransition();

    }

}
