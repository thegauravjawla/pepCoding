import java.util.*;
public class fractionalKnapsack
{
    static class Item implements Comparable<Item>
    {
        int w;
        int v;
        float rate;
        Item(int w, int v)
        {
            this.w = w;
            this.v = v;
            this.rate = (float)v/w;
        }
        public int compareTo(Item other)
        {
            if(this.rate < other.rate)
            {
                return 1;
            }
            else if(this.rate > other.rate)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }
    static float maxValue(Item[] items, int c)
    {
        int ans = 0;
        for(int i = 0; i < items.length && c != 0; i++)
        {
            if(items[i].w <= c)
            {
                c-=items[i].w;
                ans+=items[i].v;
            }
            else
            {
                ans+=(items[i].rate)*c;
                c=0; 
            }
        }
        return ans;
    } 
    public static void main(String[] args) 
    {
        int[] w = {10, 40, 20, 30};
        int[] v = {60, 40, 100, 120};
        int c = 50;
        Item[] items = new Item[w.length];
        for(int i = 0; i < w.length; i++)
        {
            items[i] = new Item(w[i], v[i]);
        }
        Arrays.sort(items);

        float ans = maxValue(items, c);
        System.out.println(ans);
    }
}