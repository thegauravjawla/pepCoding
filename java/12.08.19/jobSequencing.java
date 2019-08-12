import java.util.*;
public class jobSequencing
{
    static class Job implements Comparable<Job>
    {
        char name;
        int deadline;
        int profit;
        Job(char name, int deadline, int profit)
        {
            this.name = name;
            this.deadline = deadline;
            this.profit = profit;
        }
        public int compareTo(Job other)
        {
            return other.profit - this.profit;
        }
    }

    static void toDo(Job[] jobs, char[] ans)
    {
        int k = 0;
        for(int i = 0; i < jobs.length || k != ans.length - 1; i++)
        {
            int j = jobs[i].deadline;
            while(j > 0)
            {
                if(ans[j] == 0)
                {
                    ans[j] = jobs[i].name;
                    k++;
                    break;
                }
                else
                {
                    j--;
                }
            }
        }
    }
    public static void main(String[] args) 
    {
        char[] name = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o'};
        int[] deadline = {4, 2, 3, 2, 4, 5, 1, 1, 2, 3, 5, 2, 3, 5, 4};
        int[] profit = {37, 64, 98, 70, 80, 40, 54, 76, 42, 89, 27, 92, 38, 77, 46};
        Job[] jobs = new Job[name.length];
        int totalDays = 0;
        for(int i = 0; i < name.length; i++)
        {
            jobs[i] = new Job(name[i], deadline[i], profit[i]);
            if(totalDays < deadline[i]) totalDays = deadline[i];
        }
        Arrays.sort(jobs);
        char[] ans = new char[totalDays+1];
        toDo(jobs, ans);
        for(int i = 1; i < ans.length; i++)
        {
            System.out.print(ans[i] + " ");
        }
    }
}