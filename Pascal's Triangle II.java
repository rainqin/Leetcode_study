public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> parent = new ArrayList<Integer>();
        row(rowIndex, parent, result);
        return result;        
    }
    
    public ArrayList<Integer> row(int line, ArrayList<Integer> parent, ArrayList<Integer> result) {
        if (line == 0) {
            result.add(1);
            return result;
        } else if (line == 1) {
            result.add(1);
            result.add(1);
            return result;
        } else {
            parent.addAll(row(line - 1, parent, result));
            result.clear();
            result.add(1);
            for (int i = 0; i < line - 1; i++) {
                result.add(parent.get(i) + parent.get(i + 1));
            }
            result.add(1);
            parent.clear();
            return result;
        }
    }
}