package greed;

import java.util.HashMap;

public class Greed {
	
	public static void main(String[] args) {
		System.out.println(Greed.greedy(new int[]{5,1,3,4,1}));
	}
	
	
// solution 3
	 public static int greedy(int[] dice){
	        int res = 0;
//	        count results for each die
	        int[] count = new int[]{0, 0, 0, 0, 0, 0};
//	        score for 1 and 5 
	        int[] weight = new int[]{100, 0, 0, 0, 50, 0};
//	        score for triple values
	        int[] weight3 = new int[]{1000, 200, 300, 400, 500, 600};
// counting
	        for (int die : dice) count[die-1]++;
// calculating
	        for (int i = 0; i < count.length; i++) res+=(count[i]/3*weight3[i]) + (count[i]%3 * weight[i]);

	        return res;
	  }
	
//	 solution 2
	public static int greedy2(int[] dice) {
//		instantiate an array of int, which counts number of each die points
	    int n[] = new int[7];
	    for (int d : dice) n[d]++;
	    
//	    counting total price
	    return n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;
	  }
	
	
//	tooooo complicated
	static int sum = 0;
	
	public static int greedy1(int[] dice){
		sum =0;
		
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();	    
		for(int i =0; i < dice.length; i++) {
			if(map.get(Integer.valueOf(dice[i])) == null) {
				map.put(Integer.valueOf(dice[i]), Integer.valueOf(1));
			}else {
				Integer val =  map.get(dice[i]);
				map.put(Integer.valueOf(dice[i]), ++val);
			}
			
	    }
		
		map.forEach((k,v) -> {if(v>3) {
			sum += (calculate(k,3) + calculate(k,v-3));
		}else {
			sum +=  calculate(k,v);
		}
		});
		
	    return sum;
	  }
	
	public static int calculate(int a, int b) {
		switch(b) {
		  case 1:
		    if(a == 5) {
		    	return 50;
		    }else if(a == 1) {
		    	return 100;
		    }else {
		    	return 0;
		    }
		  case 2:
			  if(a == 5) {
			    	return 50*2;
			    }else if(a == 1) {
			    	return 100*2;
			    }else {
			    	return 0;
			    }
		  case 3:
			  if(a == 1) {
			    	return 1000;
			   }else {
				   return a*100;
			   }
		}
		return 0;
	}
}
