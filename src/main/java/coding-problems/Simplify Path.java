class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0) return "";

        List<String> nameList = new ArrayList<>(Arrays.asList(path.split("/+")));
        Deque<String> resultStack = new ArrayDeque<>();

        Iterator<String> it = nameList.iterator();
        while (it.hasNext()) {
            String name = it.next();
            // "" "." means stay here
            if (name.equals((".")) || name.equals("")) continue;

            // .. means go up 1 lvl
            else if (name.equals((".."))) {
                if (resultStack.isEmpty()) continue;
                else resultStack.pop();
            } 
            else {
                resultStack.push(name);
            }
        }

        // making string from stack
        StringBuilder result = new StringBuilder();
        for(String n : resultStack) {
            /* normal iterator iterates over resultStack in stack order (last-in-first-out)
            cause push() puts elements at first, which builds the path in reverse. Since we're\
            using push(), the first directory ends up at the bottom of the stack. to fix that
            we insert at first not last */

            // we do "/" + n here cause that was raw dir names remain in stack i.e. cleaner
            result.insert(0, "/" + n);
        }

        // return root dir / when path.length() != 0 but stack was empty
        if(resultStack.isEmpty()) return "/"; 
        else return result.toString();
    }
}