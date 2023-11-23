import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        Button[] buttons = new Button[10];
        Finger[] fingers = new Finger[2];
        fingers[0] = new Finger(3, 0);
        fingers[1] = new Finger(3, 2);
        buttons[0] = new Button(3, 1);
        for (int i = 1; i <= 9; i++) {
            buttons[i] = new Button((i-1) / 3, (i-1) % 3);
        }
        
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                fingers[0].x = buttons[num].x;
                fingers[0].y = buttons[num].y;
            }
            else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                fingers[1].x = buttons[num].x;
                fingers[1].y = buttons[num].y;
            }
            else {
                if (isLeft(fingers, buttons[num], hand)) {
                    sb.append("L");
                    fingers[0].x = buttons[num].x;
                    fingers[0].y = buttons[num].y;
                } else {
                    sb.append("R");
                    fingers[1].x = buttons[num].x;
                    fingers[1].y = buttons[num].y;
                }
            }
        }
        
        return sb.toString();
    }
    
    private static boolean isLeft(Finger[] fingers, Button button, String hand) {
        int dist1 = distance(fingers[0].x, fingers[0].y, button.x, button.y);
        int dist2 = distance(fingers[1].x, fingers[1].y, button.x, button.y);
        
        if (dist1 < dist2) return true;
        else if (dist1 > dist2) return false;
        else {
            if (hand.equals("left")) return true;
            return false;
        }
    }
    
    private static int distance(int x1, int y1, int x2, int y2) {
        return (Math.abs(x2 - x1) + Math.abs(y2 - y1));
    }
    
    static class Button {
        int x, y;
        
        public Button(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static class Finger {
        int x, y;
        
        public Finger(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}