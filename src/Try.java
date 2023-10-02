/**
 * aklsjdfkjads;f.
 * */
public class Try {
    //        String example = "United Arab Emirates Dirham (AED)";
//        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(example);
//        while(m.find()) {
//            System.out.println(m.group(1));
//        }

    // Matcher m = Pattern.compile(".*\\bsuch\\b+" + this.nP + "([^" + this.nP + "])").matcher(this.line);
    // Matcher m = Pattern.compile(".*\\bsuch\\b+\\s*+<+n+p+>+" + "([^<]+/+n+p+>)").matcher(this.line);
    // Matcher m = Pattern.compile("\\{.*?\\}").matcher("mrewrwegsg {text in between braces}
    // njanfjaenfjie a {text in between braces}");
//        Matcher m = Pattern.compile(".*\\bsuch\\b+\\s*+<+n+p+\\>.*?" +"\\<").matcher(toS);
//        while (m.find()) {
//            System.out.println(m.group());
//            System.out.println(m.group().subSequence(1, m.group().length()-1));
//        }


    //                    //add to map if doesn't exist
//                    this.hypernymToHyponymMap.putIfAbsent(this.hypernym.getName(),
//                            new QuickSortNumberArray());

    //        /*call function to get file of all hypernyms and Hyponyms*/
//        CreateHypernymDatabase data = new CreateHypernymDatabase();
//        String[] arg = new String[2];
//        arg[0] = corpus;
//        arg[1] = "outputForDiscoverHypernym.txt";
//        data.main(arg);
//        Map<String, QuickSortNumberArray> map = data.getMap();
//        //run through all keys and find stuff from lemma


//    C:\\Users\\97250\\IdeaProjects\\ass7\\data\\corpus
//    C:\\Users\\97250\\IdeaProjects\\ass7\\try


    /**/

//            Map<String, QuickSortNumberArray> hypernymToHyponymMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
//
//            for (String key : out.getMap().keySet()) {
//                hypernymToHyponymMap.put(key, out.getMap().get(key));
//            }
//
//            /*sort each HyponymList in map*/
//            for (String key: hypernymToHyponymMap.keySet()) {
//               hypernymToHyponymMap.get(key).quickSortArray(
//                        hypernymToHyponymMap.get(key).getSize() - 1, 0);
//
//                /*print to file*/
//                System.out.print(key + ":");
//                //create first hyponym flag
//                boolean firstHyponym = true;
//                //print all hyponyms and how many times they appeared
//                for (AppearanceCounter h : hypernymToHyponymMap.
//                        get(key).getAppearanceCounterList()) {
//                    if (firstHyponym) {
//                        System.out.print(" " + h.getName()
//                                + " (" + h.getCounter() + ")");
//                    } else {
//                        System.out.print(", " + h.getName()
//                                + " (" + h.getCounter() + ")");
//                    }
//                    firstHyponym = false;
//                }
//                System.out.println();
//            }

//            /*sort each HyponymList in map*/
//            for (String key: out.getMap().keySet()) {
//                out.getMap().get(key).quickSortArray(
//                        out.getMap().get(key).getSize() - 1, 0);

//                /*print to file*/
//                System.out.print(key + ":");
//                //create first hyponym flag
//                boolean firstHyponym = true;
//                //print all hyponyms and how many times they appeared
//                for (AppearanceCounter h : out.getMap().
//                        get(key).getAppearanceCounterList()) {
//                    if (firstHyponym) {
//                        System.out.print(" " + h.getName()
//                                + " (" + h.getCounter() + ")");
//                    } else {
//                        System.out.print(", " + h.getName()
//                                + " (" + h.getCounter() + ")");
//                    }
//                    firstHyponym = false;
//                }
//                System.out.println();
//            }


//     Comparator<String> caseInsensitiveThenNaturalOrder = String
//            .CASE_INSENSITIVE_ORDER
//            .thenComparing(Comparator.naturalOrder());
//    Comparator<String> myComparator = (s1, s2) -> {
//        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
//            int compare = caseInsensitiveThenNaturalOrder
//                    .compare(s1.substring(i, i + 1), s2.substring(i, i + 1));
//            if (compare != 0) return compare;
//        }
//        return Integer.compare(s1.length(), s2.length());
//    };
//
//    /**
//     * This method prints end result to file.
//     * @param detector detector holding map
//     * @param outFile file to print to
//     * */
//    public void printToFile(DetectNP detector, String outFile) {
//        try {
//
//            OutFormat out = new OutFormat(detector.getMap());
//            out.reformatMap();
//            System.out.println("num of hypernyms: " + out.getMap().size());//**********************************
//            //set output stream
//            File myFile = new File(outFile);
//            PrintStream fileOut = new PrintStream(myFile);
//            System.setOut(fileOut);
//
//            /*create array of keys- and sort them*/
//            String[] hy = new String[out.getMap().size()];
//            int i = 0;
//            for (String key : out.getMap().keySet()) {
//                hy[i] = key;
//                i++;
//            }
//            Arrays.sort(hy, myComparator); // sort keys;
//
//            /*print keys in sorted order*/
//            for (String key: hy) {
//                out.getMap().get(key).quickSortArray(out.getMap().
//                        get(key).getSize() - 1, 0);
//
//                /*print to file*/
//                System.out.print(key + ":");
//                //create first hyponym flag
//                boolean firstHyponym = true;
//                //print all hyponyms and how many times they appeared
//                for (AppearanceCounter h : out.getMap().
//                        get(key).getAppearanceCounterList()) {
//                    if (firstHyponym) {
//                        System.out.print(" " + h.getName()
//                                + " (" + h.getCounter() + ")");
//                    } else {
//                        System.out.print(", " + h.getName()
//                                + " (" + h.getCounter() + ")");
//                    }
//                    firstHyponym = false;
//                }
//                System.out.println();
//            }
//        } catch (IOException e) {
//            System.out.println("an error accrued");
//        }
//    }

//        this.nP = "\\s*+<+n+p+>+([^<]*+\\s*)*+<+/+n+p+>";
//        this.hyponymPattern = this.nP + "(\\s*+,+" + this.nP + ")*"
//                + "(\\s*(\\band\\b | \\bor\\b)+" + this.nP + "){0,1}";
//       /**
//     * This method initializes the patterns.
//     * */
//    public void initializePatterns() {
//        this.patterns = new ArrayList<>();
//        //create pattern 1
//        String patternOne =  this.nP + "+,{0,1}+\\s*\\bsuch as\\b+\\s*"
//                + this.hyponymPattern;
//        this.patterns.add(patternOne); // add pattern to list
//        // create pattern two
//        String patternTwo = "\\bsuch\\b+" + this.nP + "+\\s*+\\bas\\b"
//                + this.hyponymPattern;
//        this.patterns.add(patternTwo); // add pattern to list
//        // create pattern three
//        String patternThree = this.nP + "+,{0,1}+\\s*\\bincluding\\b+\\s*"
//                + this.hyponymPattern;
//        this.patterns.add(patternThree); // add pattern to list
//        // create pattern four
//        String patternFour = this.nP + "+,{0,1}+\\s*\\bespecially\\b+\\s*"
//                + this.hyponymPattern;
//        this.patterns.add(patternFour); // add pattern to list
//    }

//     /**
//     * This constructor saves line to detect.
//     * @param l line to save
//     * */
//    public DetectNP(String l) {
//        this.line = l;
//        this.nP = "<+n+p+>+([^<]*+\\s*)*+<+/+n+p+>";
//        this.hyponymPattern = this.nP + "( +(,+ )?+" + this.nP + ")*"
//                + "(( +,)?+ +(\\band\\b | \\bor\\b)+ +" + this.nP + "){0,1}";
//        this.isFirst = true;
//        this.hypernymToHyponymMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
//        this.initializePatterns();
//    }
    //    Comparator<String> caseInsensitiveThenNaturalOrder
//            = String.CASE_INSENSITIVE_ORDER.thenComparing(
//                    Comparator.naturalOrder());
//    Comparator<String> myComparator = (s1, s2) -> {
//        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
//            int compare = caseInsensitiveThenNaturalOrder
//                    .compare(s1.substring(i, i + 1), s2.substring(i, i + 1));
//            if (compare != 0) return compare;
//        }
//        return Integer.compare(s1.length(), s2.length());
//    };
}
