//https://www.geeksforgeeks.org/largest-rectangle-under-histogram/

//Java program to find maximum rectangular area in linear time 
package Matrix;
import java.util.Stack; 

public class LargestAreaHistogram
{ 
	
	static int getMaxArea(int hist[], int n) 
	{ 
		 
		Stack<Integer> s = new Stack<>(); 
		
		int max_area = 0; 
		int top; 
		int area_with_top; // To store area with top bar as the smallest bar 
	
		
		int i = 0; 
		while (i < n) 
		{ 
			// If this bar is higher than the bar on top stack, push it to stack 
			if (s.empty() || hist[s.peek()] <= hist[i]) 
				s.push(i++); 
	
			// If this bar is lower than top of stack, then calculate area of rectangle 
			// with stack top as the smallest (or minimum height) bar. 'i' is 
			// 'right index' for the top and element before top in stack is 'left index' 
			else
			{ 
				top = s.peek(); // store the top index 
				s.pop(); // pop the top 
	
				// Calculate the area with hist[tp] stack as smallest bar 
				area_with_top = hist[top] * (s.empty() ? i : i - s.peek() - 1); 
	
				// update max area, if needed 
				if (max_area < area_with_top) 
					max_area = area_with_top; 
			} 
		} 
	
		// Now pop the remaining bars from stack and calculate area with every 
		// popped bar as the smallest bar 
		while (!s.empty()) 
		{ 
			top = s.peek(); 
			s.pop(); 
			area_with_top = hist[top] * (s.empty() ? i : i - s.peek() - 1); 
	
			if (max_area < area_with_top) 
				max_area = area_with_top; 
		} 
	
		return max_area; 

	} 
	
	
	public static void main(String[] args) 
	{ 
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 }; 
		//System.out.println("Maximum area is " + getMaxArea(hist, hist.length)); 
		int maxArea=getMaxAreaHistoGram(hist, hist.length);
		System.out.println(maxArea);
	}

	private static int getMaxAreaHistoGram(int[] hist, int n) {
		int maxArea=0;
		Stack<Integer> st= new Stack<>();
		int top;
		int topElementArea=0;

		int i=0;
		while(i<n){
			if(st.isEmpty()||hist[st.peek()]<=hist[i]){
				st.push(i++);
			}
			else{
				top=st.peek();
				st.pop();

				topElementArea=hist[top]*(st.isEmpty()?i:(i-st.peek()-1));

				maxArea=Math.max(topElementArea, maxArea);
			}
		}
		if(!st.isEmpty()){
			top=st.peek();
			st.pop();

			topElementArea=hist[top]*(st.isEmpty()?i:(i-st.peek()-1));

			maxArea=Math.max(topElementArea, maxArea);
		}

		return maxArea;
	}
}