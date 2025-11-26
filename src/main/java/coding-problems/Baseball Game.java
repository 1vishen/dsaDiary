class Solution {
    public int calPoints(String[] operations) {
        /* this seems to require a stack like data str, but since stack only provides 
        efficient access to last element and not second last we will use arraylist */

        List<Integer> record = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            int n = record.size();
            String op = operations[i];

            switch (op) {
                case "+":
                    /* problem states that all operations will be valid so we will
                    never run in a case where we need to do + but i < 2 etc */
                    record.add(record.get(n - 1) + record.get(n - 2));
                    break;

                case "D":
                    record.add(record.get(n - 1) * 2);
                    break;

                case "C":
                    record.remove(n - 1);
                    break;

                /* since we know only 4 distinct cases are possible we know that if
                its neither of above 3 its an integer so default case is this: */
                default:
                    record.add(Integer.parseInt(op));
                    break;
            }
        }

        int result = 0;
        for (int num : record) {
            result += num;
        }
        return result;
    }
}
