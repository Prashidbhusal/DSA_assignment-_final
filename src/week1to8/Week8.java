package week1to8;
import java.util.*;


public class Week8 {
    private int pos=0;
    public String getFormula(String formula) {
        StringBuilder res = new StringBuilder();
        Map<String, Integer> finalFormula = countAtoms(formula.toCharArray());
        for (String element: finalFormula.keySet()) {
            res.append(element);
            int count = finalFormula.get(element);
            if (count > 1) {
                res.append("" + count);
            }
        }
        return res.toString();
    }
    private Map<String, Integer> countAtoms(char[] f) {
        Map<String, Integer> solved = new TreeMap<String, Integer>();
        while (pos != f.length) {
            if (f[pos] == '(') {
                pos++;
                Map<String, Integer> tmp = countAtoms(f);
                int count = getCount(f);
                for (Map.Entry<String, Integer> entry : tmp.entrySet())
                    solved.put(entry.getKey(),entry.getValue() * count);
            }
            else if (f[pos] == ')') {
                ++pos;
                return solved;
            }
            else {
                String name = getName(f);
                solved.put(name,getCount(f));
            }
        }
        return solved;
    }
    private String getName(char[] f) {
        String name = "" + f[pos];
        pos++;
        while (pos < f.length && 'a' <= f[pos] && f[pos] <= 'z') {
            name += f[pos];
            pos++;
        }
        return name;
    }
    private int getCount(char[] f) {
        int count = 0;
        while (pos < f.length && '0' <= f[pos] && f[pos] <= '9') {
            count = count * 10 + (f[pos] - '0');
            pos++;
        }
        return count == 0 ? 1 : count;
    }

    public static void main(String[] args) {
        Week8 obj= new Week8();
        String res = obj.getFormula("Mg(OH)2");
        System.out.println(res);
    }
}