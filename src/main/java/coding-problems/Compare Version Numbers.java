class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1;
        String[] arr2;

        arr1 = version1.split("\\.+");
        arr2 = version2.split("\\.+");

        int i = 0;
        for(; i < Math.min(arr1.length, arr2.length); i++) {
            int n1 = Integer.parseInt(arr1[i]);
            int n2 = Integer.parseInt(arr2[i]);

            if(n1 < n2) return -1;
            else if(n1 > n2) return 1;
        }
        // if arr1 is longer
        while(i < arr1.length) {
            int n1 = Integer.parseInt(arr1[i]);

            if(n1 < 0) return -1;
            else if(n1 > 0) return 1;
            i++;
        }
        // if arr2 is longer
        while(i < arr2.length) {
            int n2 = Integer.parseInt(arr2[i]);

            if(0 < n2) return -1;
            else if(0 > n2) return 1;
            i++;
        }
        return 0;
    }
}