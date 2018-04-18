import java.util.HashMap;
import java.util.Scanner;

public class EquationClass {

    public static char CONSTANT_FRONT_BRACKET = '(';
    public static char CONSTANT_BACK_BRACKET = ')';

    public static String CONSTANT_EQUATION = "equationString";
    public static String CONSTANT_COUNT = "count";
    public static String CONSTANT_RESULT = "result";

    public static char CONSTANT_AND = '^';
    public static char CONSTANT_OR = 'v';
    public static char CONSTANT_NOT = '~';

    public static HashMap<String, String> equationMapper = new HashMap<>();

    public static void main(String args[]) {

        print("Enter the equation");
        String equation = scanData();
        print(new String("Substring").substring(3));
        print("Equation==" + equation);
        getAllParams(equation);
        print(equationMapper.values().toString());


        equationMapper.put(CONSTANT_EQUATION, equation);
        equationMapper.put(CONSTANT_COUNT, String.valueOf(equation.length()));
        equationMapper.put(CONSTANT_RESULT, "");
        equationMapper = recrusiveEquation(equationMapper);
        print("Final data==" + equationMapper.get(CONSTANT_RESULT));
    }

    private static void getAllParams(String equation) {
        equation = equation.replace("(", "");
        equation = equation.replace(")", "");
        equation = equation.replace("^", "");
        equation = equation.replace("v", "");
        equation = equation.replace("~", "");

        for (int i = 0; i < equation.length(); i++) {
            if (!equationMapper.containsKey(String.valueOf(equation.charAt(i)))) {
                equationMapper.put(String.valueOf(equation.charAt(i)), scanData());
            }
        }
    }

    private static HashMap<String, String> recrusiveEquation(HashMap<String, String> equationMapper) {

        int count = Integer.parseInt(equationMapper.get(CONSTANT_COUNT));
        String equationString = equationMapper.get(CONSTANT_EQUATION);


        if (equationString == null || equationString.length() <= 1) {
            return equationMapper;
        }

        for (int i = 0; i < equationString.length(); i++) {

            if (equationString.charAt(i) == CONSTANT_FRONT_BRACKET || equationString.charAt(i) == CONSTANT_BACK_BRACKET) {
                equationMapper.put(CONSTANT_EQUATION, equationString.substring(i+1));
                equationMapper.put(CONSTANT_RESULT, String.valueOf(Boolean.parseBoolean(recrusiveEquation(equationMapper).get(CONSTANT_RESULT))));
                return equationMapper;
            } else if (equationString.charAt(i) == CONSTANT_AND) {

                if (equationString.charAt(i + 1) == CONSTANT_FRONT_BRACKET || equationString.charAt(i + 1) == CONSTANT_BACK_BRACKET || equationString.charAt(i + 1) == CONSTANT_NOT || equationString.charAt(i + 1) == CONSTANT_OR) {
                    equationMapper.put(CONSTANT_EQUATION, equationString.substring(i+1));
                    equationMapper.put(CONSTANT_RESULT, getComparedValue(equationString.charAt(i - 1), equationString.charAt(i + 1), 0));
                    equationMapper.put(CONSTANT_RESULT, String.valueOf(Boolean.logicalAnd(Boolean.parseBoolean(equationMapper.get(CONSTANT_RESULT)), Boolean.parseBoolean(recrusiveEquation(equationMapper).get(CONSTANT_RESULT)))));
                    return recrusiveEquation(equationMapper);
                } else {
                    //equationMapper.put(CONSTANT_RESULT, getComparedValue(equationString.charAt(i - 1), equationString.charAt(i + 1), 0));
                    equationMapper.put(CONSTANT_EQUATION, equationString.substring(i + 2));
                    equationMapper.put(CONSTANT_RESULT, String.valueOf(Boolean.logicalAnd(Boolean.parseBoolean(equationMapper.get(CONSTANT_RESULT)), Boolean.parseBoolean(equationMapper.get(String.valueOf(equationString.charAt(i + 1)))))));
                    return recrusiveEquation(equationMapper);
                }
            } else if (equationString.charAt(i) == CONSTANT_OR) {

                if (equationString.charAt(i + 1) == CONSTANT_FRONT_BRACKET || equationString.charAt(i + 1) == CONSTANT_BACK_BRACKET || equationString.charAt(i + 1) == CONSTANT_NOT || equationString.charAt(i + 1) == CONSTANT_AND) {
                    equationMapper.put(CONSTANT_EQUATION, equationString.substring(i+1));
                    equationMapper.put(CONSTANT_RESULT, getComparedValue(i>=1?equationString.charAt(i - 1):equationString.charAt(i), equationString.charAt(i + 1), 1));
                    equationMapper.put(CONSTANT_RESULT, String.valueOf(Boolean.logicalOr(Boolean.parseBoolean(equationMapper.get(CONSTANT_RESULT)), Boolean.parseBoolean(recrusiveEquation(equationMapper).get(CONSTANT_RESULT)))));
                    return recrusiveEquation(equationMapper);
                } else {
                    equationMapper.put(CONSTANT_EQUATION, equationString.substring(i + 2));
                   // equationMapper.put(CONSTANT_RESULT, getComparedValue(equationString.charAt(i - 1), equationString.charAt(i + 1), 1));
                    equationMapper.put(CONSTANT_RESULT, String.valueOf(Boolean.logicalOr(Boolean.parseBoolean(equationMapper.get(CONSTANT_RESULT)), Boolean.parseBoolean(equationMapper.get(String.valueOf(equationString.charAt(i + 1)))))));
                    return recrusiveEquation(equationMapper);
                }


            } else if (equationString.charAt(i) == CONSTANT_NOT) {
                if (equationString.charAt(i + 1) == CONSTANT_FRONT_BRACKET || equationString.charAt(i + 1) == CONSTANT_BACK_BRACKET || equationString.charAt(i + 1) == CONSTANT_OR || equationString.charAt(i + 1) == CONSTANT_AND) {
                    equationMapper.put(CONSTANT_EQUATION, equationString.substring(i + 1));
                    equationMapper.put(CONSTANT_RESULT, getComparedValue(i>=1?equationString.charAt(i - 1):equationString.charAt(i), equationString.charAt(i + 1), 2));
                    equationMapper.put(CONSTANT_RESULT, String.valueOf(!Boolean.parseBoolean(recrusiveEquation(equationMapper).get(CONSTANT_RESULT))));
                    return recrusiveEquation(equationMapper);
                } else {
                    equationMapper.put(CONSTANT_EQUATION, equationString.substring(i + 1));
                    equationMapper.put(CONSTANT_RESULT, getComparedValue(equationString.charAt(i), equationString.charAt(i), 2));
                    return recrusiveEquation(equationMapper);
                }
            } else {
                equationMapper.put(CONSTANT_EQUATION, equationString.substring(i + 1));
                equationMapper.put(CONSTANT_RESULT, equationMapper.get(String.valueOf(equationString.charAt(i))));
                return recrusiveEquation(equationMapper);
            }
        }

        return recrusiveEquation(equationMapper);
    }

    private static String getComparedValue(char valueOne, char valueTwo, int flag) {
        String value = "";
        switch (flag) {
            case 0:
               
                return (valueTwo==CONSTANT_AND||valueTwo==CONSTANT_OR||valueTwo==CONSTANT_NOT)? equationMapper.get(valueTwo):((valueTwo==CONSTANT_NOT||valueOne==CONSTANT_AND||valueOne==CONSTANT_OR)? equationMapper.get(valueTwo):String.valueOf(Boolean.logicalAnd(Boolean.parseBoolean(equationMapper.get(String.valueOf(valueOne))), Boolean.parseBoolean(equationMapper.get(String.valueOf(valueTwo))))));
                //return String.valueOf(Boolean.logicalAnd(Boolean.parseBoolean(equationMapper.get(String.valueOf(valueOne))), Boolean.parseBoolean(equationMapper.get(String.valueOf(valueTwo)))));
            case 1:
               return (valueTwo==CONSTANT_AND||valueTwo==CONSTANT_OR||valueTwo==CONSTANT_NOT)? equationMapper.get(valueOne):((valueTwo==CONSTANT_NOT||valueOne==CONSTANT_AND||valueOne==CONSTANT_OR)? equationMapper.get(valueTwo):String.valueOf(Boolean.logicalOr(Boolean.parseBoolean(equationMapper.get(String.valueOf(valueOne))), Boolean.parseBoolean(equationMapper.get(String.valueOf(valueTwo))))));
              
               // return String.valueOf(Boolean.logicalOr(Boolean.parseBoolean(equationMapper.get(String.valueOf(valueOne))), Boolean.parseBoolean(equationMapper.get(String.valueOf(valueTwo)))));
            case 2:
                value = (valueTwo==CONSTANT_AND||valueTwo==CONSTANT_OR||valueTwo==CONSTANT_NOT)?String.valueOf(valueOne):((valueTwo==CONSTANT_NOT||valueOne==CONSTANT_AND||valueOne==CONSTANT_OR)?String.valueOf(valueTwo):"");
                return String.valueOf(Boolean.parseBoolean(equationMapper.get(String.valueOf(value))));
        }
        return equationMapper.get(value);
    }

    private static void print(String data) {
        System.out.println(data);
    }

    private static String scanData() {
        return String.valueOf((new Scanner(System.in).nextLine()));
    }
}
