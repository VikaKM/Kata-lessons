import java.util.HashMap;
import java.util.Map;

public class Transform {
    private static final Map<Integer, String> edinicy = new HashMap<>();
    private static final Map<Integer, String> decyatki = new HashMap<>();

    static {
        edinicy.put(1, "I");
        edinicy.put(2, "II");
        edinicy.put(3, "III");
        edinicy.put(4, "IV");
        edinicy.put(5, "V");
        edinicy.put(6, "VI");
        edinicy.put(7, "VII");
        edinicy.put(8, "VIII");
        edinicy.put(9, "IX");
        edinicy.put(10, "X");

        decyatki.put(1, "X");
        decyatki.put(2, "XX");
        decyatki.put(3, "XXX");
        decyatki.put(4, "XL");
        decyatki.put(5, "L");
        decyatki.put(6, "LX");
        decyatki.put(7, "LXX");
        decyatki.put(8, "LXXX");
        decyatki.put(9, "XC");
        decyatki.put(10, "C");

    }


    public static String transformToRoman(int i) throws Exception {
        String romanFull = null;
        if (i <= 10) {
            if (i <= 0) {
                System.out.println("Результат в римской системе исчисления не может быть меньше или равным 0");
                throw new Exception();
            } else {
                romanFull = edinicy.get(i);
            }
        } else if (i < 100) {
            String n = String.valueOf(i);
            int dec = Integer.parseInt(String.valueOf(n.charAt(0)));
            int edin = Integer.parseInt(String.valueOf(n.charAt(1)));

            romanFull = (edin == 0) ? decyatki.get(dec) : (decyatki.get(dec) + edinicy.get(edin));

        } else if (i == 100) {
            romanFull = decyatki.get(10);
        }

        return romanFull;
    }
}