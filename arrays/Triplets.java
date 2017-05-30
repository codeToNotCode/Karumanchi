package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class Triplets {
	 public int solve(String[] a) {
         ArrayList<Double> A = new ArrayList<>();
        ArrayList<Double> B = new ArrayList<>();
        ArrayList<Double> C = new ArrayList<>();
        
        for(int i = 0; i<a.length; i++){
            double num = Double.parseDouble(a[i]);
            if( num>0.0 && num< 2.0/3.0)
                A.add(num);
            else if (num>=2.0/3.0 && num<=1.0)
                B.add(num);
            else if( num > 1.0 && num < 2.0)
                C.add(num);
        }
        
        //Case 1: 
        int res=0;
        if(A.size()>=3)
        {
            ArrayList<Double> buck1MaxList = getMaxOrMin(A,3,true); 
            double m=0;
            for(int i=0;i<buck1MaxList.size();i++)
                 m+=buck1MaxList.get(i);
            if(m>1.0)
            {
                res=1;
                return res;
            }

        }
        
        //Case 2:
        if(A.size()>=2 && B.size()>=1)
        {
            ArrayList<Double> maxList = getMaxOrMin(A,2,true); 
            double m1=0;
            for(int i=0;i<maxList.size();i++)
                 m1+=maxList.get(i);
            for(int i=0;i<B.size();i++)
            {
                if(1-m1<B.get(i)&&B.get(i)<2-m1)
                {
                    res=1;return res;
                }

            }
        }
        
        //Case 3:
        if(A.size()>=2&&C.size()>=1)
        {
            ArrayList<Double> minList = getMaxOrMin(A,2,false); //used to get min 2 elements in O(n) time
            double m2=0;
            for(int i=0;i<minList.size();i++)
                m2+=minList.get(i);

            double min=minElement(C);
            if(m2+min<2.0)
            {
                res=1;
                return res;
            }
        }

        //Case 4
        if(B.size()>=2&&A.size()>=1)
        {
            ArrayList<Double> minList = getMaxOrMin(B,2,false);
            double m3=0;
            for(int i=0;i<minList.size();i++) 
                m3+=minList.get(i);
            for(int i=0;i<A.size();i++)
            {
                if(A.get(i)<2-m3)
                {
                    res=1;
                    return res;
                }
            }
        }

        //Case 5:
        if(A.size()>=1&&B.size()>=1&&C.size()>=1)
        {
            double min1=minElement(A);
            double min2=minElement(B);
            double min3=minElement(C);
            if(min1+min2+min3<2&&min1+min2+min3>1)
            {
                res=1;
                return res;
            }
        }
        return res;       
    }
    
    private ArrayList<Double> getMaxOrMin(ArrayList<Double> list, int n, boolean wantMax){
        ArrayList<Double> result = new ArrayList<>();
        Collections.sort(list);
        for(int i = 0; i<n; i++){
            if(wantMax)
                result.add(list.get(list.size()-i-1));
            else
                result.add(list.get(i));
        }
        return result;
    }
    private double minElement(ArrayList<Double> list){
        double min = list.get(0);
        for(int i = 0; i<list.size(); i++)
            min = Math.min(min, list.get(i));
        return min;
    }
    public static void main(String[] args) {
		Triplets t = new Triplets();
		String[] nums = {"0.651154", "0.105475", "2.154505", "1.901806", "0.950285", "0.934355", "0.165230", "1.337531" };
		System.out.println(t.solve(nums));
	}
}
