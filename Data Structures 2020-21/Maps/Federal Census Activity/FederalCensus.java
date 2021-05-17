import java.util.*;
import java.io.*;

public class FederalCensus {
    static ArrayList<Citizen> cList;
    static TreeMap<String, Citizen> cMap;
    public static void main(String[] args) {
        cList = new ArrayList<>();
        cMap = new TreeMap<>();

        try {
            File fileName = new File("/Users/melvinrajendran/Documents/Data Structures 2020-21/Maps/Federal Census Activity/FedCensus1930_CambriaCountyPA.txt");
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String text;

            while ((text = input.readLine()) != null) {
                if (text.length() > 2 && text.substring(0, 2).equals("17")) {
                    String firstName = text.substring(71, 88).trim();
                    String lastName = text.substring(55, 71).trim();
                    String street = text.substring(20, 36).trim();
                    String relation = text.substring(88, 108).trim();
                    String rentOrOwn = text.substring(108, 109).trim();
                    String gender = text.substring(133, 134).trim();
                    String maritalStatus = text.substring(151, 156).trim();
                    String birthplace = text.substring(173, 190).trim();
                    String fatherBirthplace = text.substring(190, 207).trim();
                    String motherBirthplace = text.substring(207, 224).trim();
                    String motherTongue = text.substring(224, 235).trim();
                    String occupation = text.substring(252, 274).trim().substring(0, 1).toUpperCase() + text.substring(252, 274).trim().substring(1).toLowerCase();
                    String industry = text.substring(274, 303).trim();
                    String transcriberRemarks = text.substring(342).trim();
                    int streetNum;
                    try {
                        streetNum = Integer.parseInt(text.substring(36, 45).trim());
                    } catch (NumberFormatException e) {
                        streetNum = -1;
                    }
                    int ageAtFirstMarriage;
                    try {
                        ageAtFirstMarriage = Integer.parseInt(text.substring(156, 162).trim());
                    } catch (NumberFormatException e) {
                        ageAtFirstMarriage = -1;
                    }
                    int yearImmigrated;
                    try {
                        yearImmigrated = Integer.parseInt(text.substring(235, 241).trim());
                    } catch (NumberFormatException e) {
                        yearImmigrated = -1;
                    }
                    String ageStr = text.substring(143, 151).trim();
                    double age;
                    try {
                        age = Double.parseDouble(ageStr);
                    } catch (NumberFormatException e) {
                        if (ageStr.charAt(0) == '.' || ageStr.equals("un")) {
                            age = -1;
                        } else if (ageStr.charAt(1) == ' ' && ageStr.contains("/")) {
                            String whole = ageStr.substring(0, ageStr.indexOf(" "));
                            double decimal;
                            if (ageStr.substring(ageStr.indexOf(" ") + 1, ageStr.indexOf("/")).contains("*"))
                                decimal = 0.5;
                            else {
                                String numerator = ageStr.substring(ageStr.indexOf(" ") + 1, ageStr.indexOf("/"));
                                String denominator = ageStr.substring(ageStr.indexOf("/") + 1);
                                decimal = Double.parseDouble(numerator) / Double.parseDouble(denominator);
                            }
                            age = Double.parseDouble(whole) + decimal;
                        } else if (ageStr.contains("*")) {
                            age = Double.parseDouble(ageStr.substring(0, ageStr.indexOf("*")));
                        } else {
                            String numerator = ageStr.substring(0, ageStr.indexOf("/"));
                            String denominator = ageStr.substring(ageStr.indexOf("/") + 1);
                            age = Double.parseDouble(numerator) / Double.parseDouble(denominator);
                        }
                    }
                    String propertyValueStr = text.substring(113, 121);
                    if (propertyValueStr.charAt(0) == '$')
                        propertyValueStr = propertyValueStr.substring(1);
                    double propertyValue = 0;
                    try {
                        propertyValue = Double.parseDouble(propertyValueStr);
                    } catch (NumberFormatException e) {
                        if (propertyValueStr.contains("/")) {
                            String whole = propertyValueStr.substring(0, propertyValueStr.indexOf(" "));
                            String numerator = propertyValueStr.substring(propertyValueStr.indexOf(" ") + 1, propertyValueStr.indexOf("/"));
                            String denominator = propertyValueStr.substring(propertyValueStr.indexOf("/") + 1);
                            propertyValue = Double.parseDouble(whole) + Double.parseDouble(numerator) / Double.parseDouble(denominator);
                        }
                    }
                    boolean attendedSchool = text.substring(162, 167).trim().equals("Yes");
                    boolean canRead = text.substring(167, 173).trim().equals("Yes");
                    
                    Citizen citizen = new Citizen(firstName, lastName, street, relation, rentOrOwn, gender, maritalStatus, birthplace, fatherBirthplace, motherBirthplace, motherTongue, occupation, industry, transcriberRemarks, streetNum, ageAtFirstMarriage, yearImmigrated, age, propertyValue, attendedSchool, canRead);
                    cList.add(citizen);
                }
            }

            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = cList.size() - 1; i >= 0; i--)
            if (cList.get(i).getFirstName().equals(".") && cList.get(i).getLastName().equals("."))
                cList.remove(i);
        Collections.sort(cList);

        for (Citizen c : cList)
            System.out.println(c);
        System.out.println();

        printStreetCitizenMap();
        System.out.println();

        printBirthplaceAgeMap();
        System.out.println();

        printMotherTongueNameMap();
        System.out.println();

        printOccupationFatherBirthplaceMap();
        System.out.println();

        printGenderRemarksMap();
        System.out.println();

        printRentOwnMap();
        System.out.println();

        // My personal TreeMap
        printRentOrOwnOccupationMap();
    }

    public static void printStreetCitizenMap() {
        TreeMap<String, TreeSet<Citizen>> streetCitizenMap = new TreeMap<>();
        for (Citizen c : cList) {
            if (!streetCitizenMap.containsKey(c.getStreet()))
                streetCitizenMap.put(c.getStreet(), new TreeSet<Citizen>());
            streetCitizenMap.get(c.getStreet()).add(c);
        }
        Iterator<String> iter = streetCitizenMap.keySet().iterator();
        while (iter.hasNext()) {
            String street = iter.next();
            System.out.println(street + ":");
            TreeSet<Citizen> temp = streetCitizenMap.get(street);
            for (Citizen c : temp)
                System.out.println("\t" + c);
        }
    }
    
    public static void printBirthplaceAgeMap() {
        TreeMap<String, PriorityQueue<Double>> birthplaceAgeMap = new TreeMap<>();
        for (Citizen c : cList) {
            if (!birthplaceAgeMap.containsKey(c.getBirthplace()))
                birthplaceAgeMap.put(c.getBirthplace(), new PriorityQueue<Double>());
            birthplaceAgeMap.get(c.getBirthplace()).add(c.getAge());
        }
        Iterator<String> iter = birthplaceAgeMap.keySet().iterator();
        while (iter.hasNext()) {
            String birthplace = iter.next();
            System.out.println(birthplace + ":");
            PriorityQueue<Double> temp = birthplaceAgeMap.get(birthplace);
            System.out.print("[");
            while (!temp.isEmpty()) {
                double age = temp.poll();
                if (age >= 0) {
                    if (temp.peek() != null)
                        System.out.print(age + ", ");
                    else
                        System.out.print(age);
                }
            }
            System.out.println("]");
        }
    }

    public static void printMotherTongueNameMap() {
        TreeMap<String, ArrayList<String>> motherTongueNameMap = new TreeMap<>();
        for (Citizen c : cList) {
            if (!motherTongueNameMap.containsKey(c.getMotherTongue()))
                motherTongueNameMap.put(c.getMotherTongue(), new ArrayList<String>());
            motherTongueNameMap.get(c.getMotherTongue()).add(c.getFirstName() + " " + c.getLastName());
        }
        Iterator<String> iter = motherTongueNameMap.keySet().iterator();
        while (iter.hasNext()) {
            String motherTongue = iter.next();
            System.out.println(motherTongue + ":");
            ArrayList<String> temp = motherTongueNameMap.get(motherTongue);
            for (String c : temp)
                System.out.println("\t" + c);
        }
    }

    public static void printOccupationFatherBirthplaceMap() {
        TreeMap<String, HashSet<String>> occupationFatherBirthplaceMap = new TreeMap<>();
        for (Citizen c : cList) {
            if (!occupationFatherBirthplaceMap.containsKey(c.getOccupation()))
                occupationFatherBirthplaceMap.put(c.getOccupation(), new HashSet<String>());
            occupationFatherBirthplaceMap.get(c.getOccupation()).add(c.getFatherBirthplace());
        }
        Iterator<String> iter = occupationFatherBirthplaceMap.keySet().iterator();
        while (iter.hasNext()) {
            String occupation = iter.next();
            System.out.println(occupation + ":");
            HashSet<String> temp = occupationFatherBirthplaceMap.get(occupation);
            Iterator<String> hashIter = temp.iterator();
            while (hashIter.hasNext())
                System.out.println("\t" + hashIter.next());
        }
    }

    public static void printGenderRemarksMap() {
        TreeMap<String, HashSet<String>> genderRemarksMap = new TreeMap<>();
        for (Citizen c : cList) {
            if (!genderRemarksMap.containsKey(c.getGender()))
                genderRemarksMap.put(c.getGender(), new HashSet<String>());
            genderRemarksMap.get(c.getGender()).add(c.getTranscriberRemarks());
        }
        Iterator<String> iter = genderRemarksMap.keySet().iterator();
        while (iter.hasNext()) {
            String gender = iter.next();
            System.out.println(gender + ":");
            HashSet<String> temp = genderRemarksMap.get(gender);
            for (String s : temp)
                System.out.println("\t" + s);
        }
    }

    public static void printRentOwnMap() {
        TreeMap<String, TreeSet<Double>> rentOwnMap = new TreeMap<>();
        for (Citizen c : cList) {
            if (!rentOwnMap.containsKey(c.getRentOrOwn()))
                rentOwnMap.put(c.getRentOrOwn(), new TreeSet<Double>());
            rentOwnMap.get(c.getRentOrOwn()).add(c.getPropertyValue());
        }
        Iterator<String> iter = rentOwnMap.keySet().iterator();
        while (iter.hasNext()) {
            String rentOrOwn = iter.next();
            System.out.println(rentOrOwn + ":");
            TreeSet<Double> temp = rentOwnMap.get(rentOrOwn);
            for (Double c : temp)
                System.out.println("\t" + c);
        }
    }

    public static void printRentOrOwnOccupationMap() {
        TreeMap<String, TreeSet<String>> rentOrOwnOccupationMap = new TreeMap<>();
        for (Citizen c : cList) {
            if (!rentOrOwnOccupationMap.containsKey(c.getRentOrOwn()))
                rentOrOwnOccupationMap.put(c.getRentOrOwn(), new TreeSet<String>());
            rentOrOwnOccupationMap.get(c.getRentOrOwn()).add(c.getOccupation());
        }
        Iterator<String> iter = rentOrOwnOccupationMap.keySet().iterator();
        while (iter.hasNext()) {
            String rentOrOwn = iter.next();
            System.out.println(rentOrOwn + ":");
            TreeSet<String> temp = rentOrOwnOccupationMap.get(rentOrOwn);
            for (String c : temp)
                System.out.println("\t" + c);
        }
    }

    public static class Citizen implements Comparable<Citizen> {
        private String firstName, lastName, street, relation, rentOrOwn, gender, maritalStatus, birthplace, fatherBirthplace, motherBirthplace, motherTongue, occupation, industry, transcriberRemarks;
        private int streetNum, ageAtFirstMarriage, yearImmigrated;
        private double age, propertyValue;
        private boolean attendedSchool, canRead;

        public Citizen(String firstName, String lastName, String street, String relation, String rentOrOwn, String gender, String maritalStatus, String birthplace, String fatherBirthplace, String motherBirthplace, String motherTongue, String occupation, String industry, String transcriberRemarks, int streetNum, int ageAtFirstMarriage, int yearImmigrated, double age, double propertyValue, boolean attendedSchool, boolean canRead) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.street = street;
            this.relation = relation;
            this.rentOrOwn = rentOrOwn;
            this.gender = gender;
            this.maritalStatus = maritalStatus;
            this.birthplace = birthplace;
            this.fatherBirthplace = fatherBirthplace;
            this.motherBirthplace = motherBirthplace;
            this.motherTongue = motherTongue;
            this.occupation = occupation;
            this.industry = industry;
            this.transcriberRemarks = transcriberRemarks;
            this.streetNum = streetNum;
            this.ageAtFirstMarriage = ageAtFirstMarriage;
            this.yearImmigrated = yearImmigrated;
            this.age = age;
            this.propertyValue = propertyValue;
            this.attendedSchool = attendedSchool;
            this.canRead = canRead;
        }
    
        public String getFirstName() {
            return this.firstName;
        }
    
        public String getLastName() {
            return this.lastName;
        }
    
        public String getStreet() {
            return this.street;
        }
    
        public String getRelation() {
            return this.relation;
        }

        public String getRentOrOwn() {
            return this.rentOrOwn;
        }
    
        public String getGender() {
            return this.gender;
        }
    
        public String getMaritalStatus() {
            return this.maritalStatus;
        }
    
        public String getBirthplace() {
            return this.birthplace;
        }
    
        public String getFatherBirthplace() {
            return this.fatherBirthplace;
        }
    
        public String getMotherBirthplace() {
            return this.motherBirthplace;
        }
    
        public String getMotherTongue() {
            return this.motherTongue;
        }
    
        public String getOccupation() {
            return this.occupation;
        }
    
        public String getIndustry() {
            return this.industry;
        }
    
        public String getTranscriberRemarks() {
            return this.transcriberRemarks;
        }
    
        public int getStreetNum() {
            return this.streetNum;
        }
    
        public int getAgeAtFirstMarriage() {
            return this.ageAtFirstMarriage;
        }
    
        public int getYearImmigrated() {
            return this.yearImmigrated;
        }
    
        public double getAge() {
            return this.age;
        }
    
        public double getPropertyValue() {
            return this.propertyValue;
        }
    
        public boolean attendedSchool() {
            return this.attendedSchool;
        }
    
        public boolean canRead() {
            return this.canRead;
        }
        public String toString() {
            return String.format("%-25sAge: %s", lastName + ", " + firstName, age);
        }

        public int compareTo(Citizen other) {
            if (firstName.compareTo(other.getFirstName()) != 0)
                return firstName.compareTo(other.getFirstName());
            if (lastName.compareTo(other.getLastName()) != 0)
                return lastName.compareTo(other.getLastName());
            if (street.compareTo(other.getStreet()) != 0)
                return street.compareTo(other.getStreet());
            if (streetNum < other.getStreetNum())
                return -1;
            if (streetNum > other.getStreetNum())
                return 1;
            if (relation.compareTo(other.getRelation()) != 0)
                return relation.compareTo(other.getRelation());
            if (rentOrOwn.compareTo(other.getRentOrOwn()) != 0)
                return rentOrOwn.compareTo(other.getRentOrOwn());
            if (propertyValue < other.getPropertyValue())
                return -1;
            if (propertyValue > other.getPropertyValue())
                return 1;
            if (gender.compareTo(other.getGender()) != 0)
                return gender.compareTo(other.getGender());
            if (age < other.getAge())
                return -1;
            if (age > other.getAge())
                return 1;
            if (maritalStatus.compareTo(other.getMaritalStatus()) != 0)
                return maritalStatus.compareTo(other.getMaritalStatus());
            if (ageAtFirstMarriage < other.getAgeAtFirstMarriage())
                return -1;
            if (ageAtFirstMarriage > other.getAgeAtFirstMarriage())
                return 1;
            if (birthplace.compareTo(other.getBirthplace()) != 0)
                return birthplace.compareTo(other.getBirthplace());
            if (fatherBirthplace.compareTo(other.getFatherBirthplace()) != 0)
                return fatherBirthplace.compareTo(other.getFatherBirthplace());
            if (motherBirthplace.compareTo(other.getMotherBirthplace()) != 0)
                return motherBirthplace.compareTo(other.getMotherBirthplace());
            if (motherTongue.compareTo(other.getMotherTongue()) != 0)
                return motherTongue.compareTo(other.getMotherTongue());
            if (yearImmigrated < other.getYearImmigrated())
                return -1;
            if (yearImmigrated > other.getYearImmigrated())
                return 1;
            if (occupation.compareTo(other.getOccupation()) != 0)
                return occupation.compareTo(other.getOccupation());
            if (industry.compareTo(other.getIndustry()) != 0)
                return industry.compareTo(other.getIndustry());
            if (transcriberRemarks.compareTo(other.getTranscriberRemarks()) != 0)
                return transcriberRemarks.compareTo(other.getTranscriberRemarks());
            if (attendedSchool)
                return -1;
            if (!attendedSchool)
                return 1;
            return 0;
        }
    }
}
