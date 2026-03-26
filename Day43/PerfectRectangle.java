import java.util.*;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> set = new HashSet<>();
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        int area = 0;
        
        for (int[] r : rectangles) {
            int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
            
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);
            
            area += (x2 - x1) * (y2 - y1);
            
            String[] corners = {
                x1 + " " + y1,
                x1 + " " + y2,
                x2 + " " + y1,
                x2 + " " + y2
            };
            
            for (String c : corners) {
                if (!set.add(c)) {
                    set.remove(c);
                }
            }
        }
        
        // Check area
        int bigArea = (maxX - minX) * (maxY - minY);
        if (area != bigArea) return false;
        
        
        if (set.size() != 4) return false;
        
        if (!set.contains(minX + " " + minY) ||
            !set.contains(minX + " " + maxY) ||
            !set.contains(maxX + " " + minY) ||
            !set.contains(maxX + " " + maxY)) {
            return false;
        }
        
        return true;
    }
}