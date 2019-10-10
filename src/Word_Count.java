package INF727;
import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.toMap;


public class Word_Count {

    public static void main(String[] args) throws IOException {
    public
        long startTime = System.currentTimeMillis();
        String datafilepath = "src/Forrestier_mayotte.txt";
        //String datafilepath = "src/codePN.txt";
        // "https://github.com/legifrance/Les-codes-en-vigueur"

        HashMap<String, Integer> hmap = new HashMap<>();

        BufferedReader bfr = new BufferedReader(new FileReader(new File(datafilepath)));

        String str = null;

        while ((str = bfr.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(str, " \t\n\r\f,.:;?![]'");
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken();
                if (hmap.containsKey(word)) {
                    int newval = hmap.get(word) + 1;
                    hmap.replace(word, newval);
                } else {
                    hmap.put(word, 1);
                }
            }
        }

        List<Map.Entry<String,Integer>> words_count = new ArrayList<>(hmap.entrySet());
        Collections.sort(words_count, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() == e2.getValue())
                       return e1.getKey().compareTo(e2.getKey());
                else
                   return -e1.getValue().compareTo(e2.getValue());
            }
        });

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
        System.out.println(words_count);
    }}
// set = collections dobjets indexes par une cle de hashage ==>> bcp plus rapide a rechercher qu'une liste
    // comparator est une interface














