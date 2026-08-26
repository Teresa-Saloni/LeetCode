class RandomizedSet {

    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {

        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {

        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int last = list.get(list.size() - 1);

        // Move last element into the removed element's position
        list.set(index, last);

        // Update last element's index
        map.put(last, index);

        // Remove last element
        list.remove(list.size() - 1);

        // Remove val from map
        map.remove(val);

        return true;
    }

    public int getRandom() {

        int index = random.nextInt(list.size());

        return list.get(index);
    }
}