import java.util.*;

class Solution {
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Person> graph = new HashMap<>();
        int[] answer = new int[enroll.length];
        
        graph.put("-", new Person("-"));
        for (int i = 0; i < enroll.length; ++i)
            graph.put(enroll[i], new Person(enroll[i]));
        
        for (int i = 0; i < referral.length; ++i)
            graph.get(enroll[i]).parent = graph.get(referral[i]);
        
        for (int i = 0; i < seller.length; ++i)
            addProfit(graph.get(seller[i]), amount[i] * 100);
        
        for (int i = 0; i < enroll.length; ++i)
            answer[i] = graph.get(enroll[i]).profit;
        
        return answer;
    }
    
    public void addProfit(Person person, int profit) {
        int profit_for_parent = profit / 10;
        if (profit_for_parent > 0 && person.parent != null) {
            person.profit += profit - profit_for_parent;
            addProfit(person.parent, profit_for_parent);
        } else {
            person.profit += profit;
        }
    }
    
    static class Person {
        String name;
        Person parent;
        int profit;
        public Person(String name) {
            this.name = name;
            this.parent = null;
            this.profit = 0;
        }
    }
}