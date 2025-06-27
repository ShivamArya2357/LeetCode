package Practice.src.warmup;

public class LeetCode2079 {

    public static void main(String[] args) {

        LeetCode2079 test = new LeetCode2079();
        int[] plants = new int[]{3,2,4,2,1};
        int capacity = 6;
        int ans = test.wateringPlants(plants, capacity);
        System.out.println(ans);
    }

    public int wateringPlants(int[] plants, int capacity) {

        int n = plants.length;
        int ans = 0;
        int i = 0;
        int currCapacity = capacity;
        while (i < n) {
            if (currCapacity >= plants[i]) {
                currCapacity -= plants[i];
                ans++;
            } else {
                ans += 2 * i + 1;
                currCapacity = capacity - plants[i];
            }
            i++;
        }
        return ans;
    }
}
