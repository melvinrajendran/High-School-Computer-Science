import java.util.*;

public class HashSetTreeSet {
    public static void main(String[] args) {
        ArrayList<HashSet> hashSetList = new ArrayList<>();

        int numSets = (int)(Math.random() * 11) + 2;
        for (int i = 0; i < numSets; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            while (hashSet.size() < 10)
                hashSet.add((int)(Math.random() * 30) + 1);
            hashSetList.add(hashSet);
        }

        Set<Integer> intersectionSet = new HashSet<>(), unionSet = new HashSet<>(), evenIntersectionSet = new HashSet<>(), evenUnionSet = new HashSet<>();
        for (int i = 0; i < hashSetList.size(); i++) {
            Set<Integer> currentHashSet = hashSetList.get(i);
            if (i == 0) {
                intersectionSet.addAll(currentHashSet);
                unionSet.addAll(currentHashSet);
                evenIntersectionSet.addAll(currentHashSet);
                evenUnionSet.addAll(currentHashSet);
            } else {
                intersectionSet = getIntersection(intersectionSet, currentHashSet);
                unionSet = getUnion(unionSet, currentHashSet);
                evenIntersectionSet = getEvenIntersection(evenIntersectionSet, currentHashSet);
                evenUnionSet = getEvenUnion(evenUnionSet, currentHashSet);
            }
        }

        System.out.println("HashSets of Random Integers:");
        for (HashSet set : hashSetList)
            System.out.println(set);
        System.out.println("\nIntersection of all Sets: \n" + intersectionSet);
        System.out.println("\nUnion of all Sets: \n" + unionSet);
        System.out.println("\nEven Intersection of all Sets: \n" + evenIntersectionSet);
        System.out.println("\nEven Union of all Sets: \n" + evenUnionSet);

        
    }

    public static Set<Integer> getIntersection(Set<Integer> setOne, Set<Integer> setTwo) {
        Set<Integer> intersectionSet = new HashSet<>();
        intersectionSet.addAll(setOne);
        intersectionSet.retainAll(setTwo);
        return intersectionSet;
    }

    public static Set<Integer> getUnion(Set<Integer> setOne, Set<Integer> setTwo) {
        Set<Integer> unionSet = new HashSet<>();
        unionSet.addAll(setOne);
        unionSet.addAll(setTwo);
        return unionSet;
    }

    public static Set<Integer> getEvenIntersection(Set<Integer> setOne, Set<Integer> setTwo) {
        Set<Integer> intersectionSet = getIntersection(setOne, setTwo);
        Iterator<Integer> iterator = intersectionSet.iterator();
        while (iterator.hasNext()) {                
            int value = iterator.next();
            if (value % 2 == 1)
                iterator.remove();
        }
        return intersectionSet;
    }

    public static Set<Integer> getEvenUnion(Set<Integer> setOne, Set<Integer> setTwo) {
        Set<Integer> unionSet = getUnion(setOne, setTwo);
        Iterator<Integer> iterator = unionSet.iterator();
        while (iterator.hasNext()) {                
            int value = iterator.next();
            if (value % 2 == 1)
                iterator.remove();
        }
        return unionSet;
    }
}
