package wyy;

import java.util.*;

public class Demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        HashSet<Integer>[] lan = new HashSet[m];
        for (int i = 0; i < m; i++) {
            lan[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            for (int j = 0; j < k; j++) {
                int lang = in.nextInt();
                lan[lang - 1].add(i);
            }
        }

        int[] c = new int[n];
        Arrays.fill(c, 0);

        for (int i = 0; i < m; i++) {
            Set<Integer> people = lan[i];

            if (people.size() > 1) {
                for (int person : people) {
                    c[person] = 1;
                }
            }
        }

        // todo

        // FIXME

        // FIXME

        // HACK

        // XXX

        int min = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] == 0) {
                min++;
            }
        }

        System.out.println(min);
    }
}
/*
3 3
1 1
1 2
1 3
 */

/*Set<Integer> commonLanguages = new HashSet<>();
        Set<Integer> allLanguages = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            Set<Integer> personLanguage = new HashSet<>();

            for (int j = 0; j < k; j++) {
                int language = in.nextInt();
                personLanguage.add(language);
                allLanguages.add(language);
            }

            if (i == 0) {
                commonLanguages.addAll(personLanguage);
            } else {
                commonLanguages.retainAll(personLanguage);
            }
        }

        int Csize = commonLanguages.size();
        int ASize = m - allLanguages.size();
        int result = Csize + ASize;
        System.out.println(result);*/