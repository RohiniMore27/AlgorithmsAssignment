package com.app.algorithm.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.util.ArrayUtils;

import com.app.algorithm.pojo.Area;
import com.app.algorithm.pojo.Rectangle;

@RestController
public class AlgorithmController {

	private static final Logger log = LoggerFactory.getLogger(AlgorithmController.class);
	
	@Autowired
	Rectangle rectangle;

	// http://localhost:7358/prime?num=7
	@GetMapping("/prime")
	public Integer isPrime(@RequestParam Integer num) {
		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				count++;
			}
		}
		if (count == 2) {
			log.info(num + " is prime number");
			return 1;
		} else {
			log.info(num + " is not prime number");
			return 0;
		}

	}

	// http://localhost:7358/getPrimeNoList?num=10
	@GetMapping("/getPrimeNoList")
	public ArrayList<Integer> sieveOfEratosthenes(@RequestParam Integer num) {
		int count;

		ArrayList<Integer> primeList = new ArrayList<Integer>();
		for (int i = 1; i <= num; i++) {
			count = 0;
			for (int j = 1; j <= num; j++) {
				if (i % j == 0) {
					count++;
				}
			}
			if (count == 2) {
				primeList.add(i);
			}
		}
		log.info("prime numbers less than equal to " + num + " are " + primeList);
		return primeList;
	}

	
	@GetMapping("/fact")
	public Integer findFact(@RequestParam Integer num) {
		int fact=1;
		
		for (int i = num; i > 0; i--) 
		{
			fact=fact*i;
			
		}
		log.info("factorial of "+num+" is "+fact);
		return fact;
	}
	
	
	// http://localhost:7358/getPrimeNoList?num=10
		@GetMapping("/nthFibonacci")
		public Integer nthFibonacci(@RequestParam Integer num) {
			int fno=0,sno=1,tno=0;
			if (num == 0)
			      return fno;
			      if (num == 1)
			      return sno;
			for (int i = 2; i <= num; i++) 
			{
				tno=fno+sno;
				fno=sno;
				sno=tno;
				
			}
			log.info(num +"th fibonacci number is :" + tno);
			return tno;
		}
		
		@GetMapping("/fiboSeries")
		public ArrayList<Integer> Series(@RequestParam Integer num) {
			 ArrayList<Integer>list=new ArrayList<>();
			int fno=0,sno=1,tno=0;
			if (num == 0)
			{
				list.add(fno);
			      return list;
			}
			  if (num == 1)
			  {
			    	  list.add(sno);
			    	  return list;
			   }
			  list.add(fno);
			  list.add(sno);
			for (int i = 2; i <num; i++) 
			{
				tno=fno+sno;
				fno=sno;
				sno=tno;
				list.add(tno);
			}
			log.info("fibonacci series upto "+num +" is :"+ list);
			return list;
		}

		
		@GetMapping("/findDiff")
		public Integer findDiff(@RequestParam Integer num) {
			String str=String.valueOf(num);
			char[] ch=str.toCharArray();
			int extraAmt=0;
			for (int i = 0; i <ch.length; i++) 
			{
				if(ch[i]=='6')
				{
					ch[i]='9';
				}
				else if(ch[i]=='9')
				{
					ch[i]='6';
				}
			}
			Integer diffNum=Integer.parseInt(new String(ch));
			log.info("confused number :"+ diffNum);
			if(diffNum>num)
			{
				extraAmt = diffNum-num;
			}
			else
			{
				extraAmt=num-diffNum;
			}
			log.info("maximum extra possible amount is:"+ extraAmt);
			return extraAmt;
		}
	
	// http://localhost:7358/anagram?s1=cddgk&s2=gcd
	@GetMapping("/anagram")
	public Integer remAnagram(@RequestParam String s1, @RequestParam String s2) 
	{		
		char[] ch = s2.toCharArray();
		StringBuilder sb = new StringBuilder(s1);
		for (int i = 0; i < ch.length; i++) 
		{
			int index = s1.indexOf(ch[i]); // find the index of s2 string char in s1
			if (index != -1) // if value found
			{
				sb = sb.deleteCharAt(index);
			}
		}
		log.info("character needs to be removed from s1 " + sb.toString());
		return sb.length();
	}
	
	
	
	@GetMapping("/isPalindrome")
	public Integer isPalindrome(@RequestParam String s1) 
	{		
		StringBuilder sb = new StringBuilder(s1);
		sb.reverse();
		if(sb.toString().equals(s1))
		{
			log.info("string is palindrome"+sb.toString());
			return 1;
		}
		else
		{
			log.info("string is not palindrome"+sb.toString());			
			return 0;
		}
		
	}
	
	@GetMapping("/isNoPalindrome")
	public String is_Palindrome(@RequestParam Integer n) 
	{		
		String s1=String.valueOf(n);
		StringBuilder sb = new StringBuilder(s1);
		sb.reverse();
		if(sb.toString().equals(s1))
		{
			log.info("string is palindrome"+sb.toString());
			return "Yes";
		}
		else
		{
			log.info("string is not palindrome"+sb.toString());			
			return "No";
		}
	}

	// http://localhost:7358/immediateSmaller?n=5&arrList=5, 6, 2, 3, 1, 7 op :
	// [-1,2,-1,1,-1,-1]
	@GetMapping("/immediateSmaller")
	public ArrayList<Integer> immediateSmaller(@RequestParam Integer n, @RequestParam("arrList") ArrayList<Integer> arr)
	{
		ArrayList<Integer> updatedList = new ArrayList<>(n);
		int j = 0;
		for (int i = 0; i < n; i++)
		{
			j = i + 1;
			if (arr.get(j) < arr.get(i)) 
			{
				updatedList.add(arr.get(j));
			} else 
			{
				updatedList.add(-1);
			}
		}
		updatedList.add(-1);
		log.info("updated arrayList " + updatedList);

		return updatedList;

	}

	@GetMapping("/thirdLargest")
	public Integer thirdLargest(@RequestParam("arrList") ArrayList<Integer> arr) 
	{
		Collections.sort(arr);
		log.info("After sorting array " + arr);
		Integer thirdLargestElement = arr.get(arr.size() - 3);
		log.info("third largest  element is " + thirdLargestElement);

		return thirdLargestElement;
	}

	@GetMapping("/secondLargest")
	public Integer print2largest(@RequestParam("arrList") TreeSet<Integer> set) {

		log.info("After sorting set in desending order " + set.descendingSet());
		  List<Integer> arr = new ArrayList<>(set.descendingSet());
		  int  secondLargestElement=arr.get(1); // first element at 0th index
			log.info("second largest  element is " + secondLargestElement);
			return secondLargestElement;
	}
	
	@GetMapping("/minAnd2ndMin")
	public Map<String,Integer> minAnd2ndMinElement(@RequestParam("arrList") TreeSet<Integer> set)
	{
		Map<String,Integer> smallestEle=new HashMap<>();
		log.info("array without duplicate element" + set);
		  List<Integer> arr = new ArrayList<>(set);
		  smallestEle.put("smallest", arr.get(0));
		  smallestEle.put("secondSmallest", arr.get(1));
			log.info("smallest and secondSmallest element is " + smallestEle);
			return smallestEle;
	}
	
	@GetMapping("/kthSmallest")
	public Integer kthSmallestElement(@RequestParam Integer k,@RequestParam("arrList") TreeSet<Integer> set)
	{
		log.info("array without duplicate element" + set);
			List<Integer> arr = new ArrayList<>(set);
			log.info(k+"smallest element is " + arr.get(k-1));
			return arr.get(k-1);
	}
	
	//2,4,5,1,7,6,8  op: 2 5 1 7 4 8 6
	@GetMapping("/zigZag")
	public  ArrayList<Integer> zigZag(@RequestParam("arrList") ArrayList<Integer> arr)
	{
		int k = 0,j=0;
		for(int i=0;i<arr.size()-2;i++)
		{
		    i=k;
			j=i+1;
			k=j+1;
	
			if(!(arr.get(i)<arr.get(j)))
			{
				Collections.swap(arr, i, j);
			}
		
			if(!(arr.get(j)>arr.get(k)))
			{
				Collections.swap(arr, j, k);
			}
		
			}
		log.info("Array elements in zigZag fashion " + arr);
		return arr;
		
	}
	
	@GetMapping("/merge")
	public String mergeString(@RequestParam String s1,@RequestParam String s2)
	{
		int maxLen = Math.max(s1.length(), s2.length());
		StringBuilder mergeString = new StringBuilder();
		for (int i = 0; i < maxLen; i++) 
		{
			if (i < s1.length())
			{
				mergeString = mergeString.append(s1.charAt(i));
			}

			if (i < s2.length()) 
			{
				mergeString = mergeString.append(s2.charAt(i));
			}

		}
		log.info("String after merging alternatively" + mergeString.toString());

		return mergeString.toString();
	}
	
	//String s1="AXY" String s2="ADXCPY"

	@GetMapping("/subsequence")
	public boolean isSubsequence(@RequestParam String s1,@RequestParam String s2)
	{
		char charArray[]=s2.toCharArray();
		StringBuilder subSeqString = new StringBuilder(s2);
		for (int i = 0; i < charArray.length; i++) 
		{
			//check char from s2 is present in s1
			int index=s1.indexOf(charArray[i]);		
			//if not present then remove that char from s2
			if(index==-1)  
			{
				subSeqString=subSeqString.deleteCharAt(s2.indexOf(charArray[i]));
				s2=subSeqString.toString();
				log.info("index is "+i+" and CHAR IS " + charArray[i]);	
			}
		}
		if(s1.equals(s2))
		{
			log.info(s1 +" S1 string is subsequence of s2 string "+s2);	
			return true;
		}
		else
		{
			log.info(s1 +" S1 string is not subsequence of s2 string "+s2);				
			return false;
		}
	}
	
	//abcioau
	@GetMapping("/isGoodorBad")
	public Integer isGoodorBad(@RequestParam String str1)
	{
	//	char charArray[]=str.toCharArray();
		long vCount=0;
		long consCount=0;
		boolean flag=false;
		int consEndIndex=5,vowlEndIndex=3; 
		Set<Character> vowlSet=new HashSet<>(Arrays.asList('a','e','i','o','u'));
		String str=str1.toLowerCase();
		if(str1.contains("?"))
		{
			str=str1.replace('?', 'a');
		}
		for(int i=0;i<str.length();i++)
		{
			
			if(consEndIndex<=str.length())
			{
				String substr = str.substring(i, consEndIndex);
				log.info("substring : " + substr);
				
				for (char c : substr.toCharArray()) {
					if (vowlSet.contains(c)) {
						vCount++;
					}
				}
				log.info("number of vowels : " + vCount);
				if (vCount >= 5) {
						flag=true;
					break;
				}

				vCount = 0;
				consEndIndex++;
			}
			
			if(vowlEndIndex<=str.length())
			{
				String substr = str.substring(i, vowlEndIndex);
				log.info("substring : " + substr);
				
				for (char c : substr.toCharArray()) {
					if (!vowlSet.contains(c)) {
						consCount++;
					}
				}
				log.info("number of consonant " + consCount);
				if (consCount >= 3) {
					flag=true;
					break;
				}

				consCount = 0;
				vowlEndIndex++;
			}
		}
		
		
		if(flag)
		{
			log.info("The String contain more than 3 consonants or  more than 5 vowels together. So, it's a BAD string");
			
			return 1;
		}		
		log.info("The String doesn't contain more than 3 consonants or  more than 5 vowels together. So, it's a GOOD string");
		return 0;
	
	}
	
	
	@GetMapping("/firstAndLast")
	public ArrayList<Integer> firstAndLastOccurenceOfX(@RequestParam Integer n,@RequestParam Integer k, @RequestParam("arrList") ArrayList<Integer> arr)
	{
		ArrayList<Integer> indexList = new ArrayList<>(n);
		int firstIndex = -1,lastIndex=-1;
		for (int i = 0; i < n; i++)
		{
			if (arr.get(i)==k) 
			{			
				if(firstIndex==-1)
				{
					firstIndex=i;
				}
				lastIndex=i;
			}
		}
		indexList.add(firstIndex);
		indexList.add(lastIndex);
		log.info("first and last occurence of X " + indexList);

		return indexList;

	}
	
	
	

	@GetMapping("/equilibriumPoint")
	public Integer equilibriumPoint( @RequestParam("arrList") ArrayList<Integer> arr)
	{
		int equilibriumIndex = -1,leftSum=0,rightSum=0,eqlbrmIndex=0;
		for (int i = 0; i <arr.size()-2; i++)
		{
			eqlbrmIndex=i+1;
			leftSum=leftSum+arr.get(i);
			
			log.info("some of all the elements before the index  "+ eqlbrmIndex +" is "+ leftSum);

			for(int j=eqlbrmIndex+1;j<arr.size();j++)
			{
				rightSum=rightSum+arr.get(j);
			}
			
				log.info("some of all the elements after the index  "+ eqlbrmIndex +" is "+ rightSum);
						
			if(leftSum==rightSum)
			{
				equilibriumIndex=eqlbrmIndex;
				log.info("first Equilibrium point of given array is " + equilibriumIndex);
				
				return equilibriumIndex;
			}
			rightSum=0;
			
		}
		
		log.info("no such Equilibrium point exist in given array " + equilibriumIndex);
				
		return equilibriumIndex;

	}
	
	
	
	@GetMapping("/isFrequencyUnique")
	public boolean isFrequencyUnique(@RequestParam("arrList") ArrayList<Integer> arr)
	{
		//// arr =[1, 1, 2, 5, 5
		int count=0;
		TreeSet<Integer> set = new TreeSet<>(arr); //after adding to set arr =1,2,5
		ArrayList<Integer> newList=new ArrayList<>();
		newList.addAll(set);	
		set.clear();
		for (int i = 0; i <newList.size(); i++) 
		{
				
			for(int j=0;j<arr.size();j++)
			{
				if(newList.get(i)==arr.get(j))
				{
					count++;
				}
			}
			log.info("frequence of number  "+ newList.get(i) +" in array is "+ count);
	
			set.add(count); //added frequency in set so that only unique freq will add 
			count=0;
		}
		log.info("frequency set size "+ set.size());
		log.info("unique element array  size "+ newList.size());
		
		if(newList.size()==set.size())
		{
			log.info("frequency of the elements in the array is unique");			
			return true;
		}
		else
		{
			log.info("frequency of the elements in the array is not unique");
			return false;
		}
					

	}
	
	
	@GetMapping("/MissingNumber")
	public Integer MissingNumber(@RequestParam Integer n, @RequestParam("arrList") ArrayList<Integer> arr)
	{
		int missingNumber=-1;
	//	ArrayList<Integer> missingNoList=new ArrayList<>();
		for (int i = 1; i <=n; i++)
		{
			
			if (!arr.contains(i)) 
			{			
				missingNumber=i;
			//	missingNoList.add(i);   multiple missing number
			}
		}
		log.info("missing number is" + missingNumber);

		return missingNumber;

	}
	
	
	
//	1, 5, 7, -1, 5
	@GetMapping("/getPairsCount")
	public Integer getPairsCount(@RequestParam Integer n,@RequestParam Integer k, @RequestParam("arrList") ArrayList<Integer> arr)
	{
		int count=0;
		for (int i = 0; i <n; i++)
		{
			for (int j = i+1; j <n; j++)
			{
			if (arr.get(i)+arr.get(j)==k) 
			{			
				count++;
			}
			}
		}
		log.info("number of pairs of elements in the array whose sum is equal to"+ k+ "is"+count);

		return count;

	}
	
	
	//[7, 8,9,10,2,8]
	@GetMapping("/stockBuySell")
	public Collection<ArrayList<Integer>> stockBuySell(@RequestParam("arrList") ArrayList<Integer> arr)
	{
		
		int buyday=-1, sellDay=-1,k=0,buyAmount,sellAmount;
		HashMap<Integer, ArrayList<Integer>>map=new HashMap<>();
		ArrayList<Integer>list=new ArrayList<>();
		for(int i=0;i<arr.size()-1;i++) 
		{
			
			if ((arr.get(i) < arr.get(i+1)))
			{
				if (buyday == -1) {
					buyday = i;										
					list.add(buyday);
				}
				sellDay=i+1;
				if(sellDay==arr.size()-1)
				{
				
					list.add(sellDay);
					map.put(k++, list);
					log.info("buyday and sellday is (" + buyday+","+sellDay+")");
				}				
			} 
			else {		

				log.info("buyday and sellday is (" + buyday+","+sellDay+")");
				if (buyday != -1) {
				list.add(sellDay);					
				map.put(k++, list);
				}
				buyday=-1;
				sellDay=-1;
				list=new ArrayList<>();
				}
		
		}
		log.info("pairs of buy and sell day"+map.values());

		return map.values();

	}
	
	
	
	@GetMapping("/stockBuySellMaxProfit")
	public int stockBuySellMaxProfit(@RequestParam("arrList") ArrayList<Integer> arr)
	{
		
		int buyday=-1, sellDay=-1,k=0,buyAmount = 0,sellAmount = 0,maxProfit=0,profit=0;
	
		for(int i=0;i<arr.size()-1;i++) 
		{
			
			if ((arr.get(i) < arr.get(i+1)))
			{
				if (buyday == -1) {
					buyday = i;
					buyAmount=arr.get(buyday);					
				}
				sellDay=i+1;
				if(sellDay==arr.size()-1)
				{
					sellAmount=arr.get(sellDay);
					profit=sellAmount-buyAmount;
					maxProfit=maxProfit+profit;
					log.info("buyday and sellday is (" + buyday+","+sellDay+")");					
		
				}				
			} 
			else {		

				log.info("buyday and sellday is (" + buyday+","+sellDay+")");
				
				if (buyday != -1) 
				{				
				sellAmount=arr.get(sellDay);				
				profit=sellAmount-buyAmount;				
				maxProfit=maxProfit+profit;
				}
				
				buyday=-1;
				sellDay=-1;
			
				}
			
		}
		
		log.info("max profit is "+maxProfit);
		return maxProfit;
		

	}
	@GetMapping("/uniqueSubSets")
	public TreeSet<ArrayList<Integer>> allSubSets( @RequestParam("arrList") ArrayList<Integer> originalList)
	{
		int n=originalList.size();
		ArrayList<Integer> list1=new ArrayList<>();
		ArrayList<Integer> list2=new ArrayList<>();
		HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
		int ele;
		int key=0;
		map.put(key++, new ArrayList<>());
		map.put(key++, originalList);
		for (int i = 0; i <originalList.size(); i++)
		{
			list1.add(originalList.get(i));
			map.put(key++, new ArrayList<>(list1));
			list1.clear();
			for (int j = i+1; j <originalList.size(); j++)
			{
				list1.add(originalList.get(i));
				list1.add(originalList.get(j));
				map.put(key++, new ArrayList<>(list1));
				log.info("set"+map.values());
				list1.clear();
			}
			
			if(n>=0)
			{
				list2.addAll(originalList);
				ele=list2.get(n-1);
				log.info("ele"+ele);
				list2.remove(Integer.valueOf(ele));
				map.put(key++, new ArrayList<>(list2));
				n--;			
			}
			list1.clear();
			list2.clear();
		}
		
		TreeSet<ArrayList<Integer>> treeSet = new TreeSet<>(Comparator.comparing(Object::hashCode));
		 treeSet.addAll(map.values());
	     		log.info(" unique subsets  "+treeSet);
		return treeSet;

	}
	
	
	
	@GetMapping("/countSubsets")
	public long countSubsets( @RequestParam("arrList") ArrayList<Integer> originalList)
	{

		TreeSet<ArrayList<Integer>> uniqueSubset = allSubSets(originalList);
		
		long count = uniqueSubset.stream().filter(list -> list.stream().allMatch(element -> element % 2 == 0)).count();
		log.info(count +" number of subsets is having even numbers and all are distinct ");
		
		return count-1;
	}
	@PostMapping("/calculateArea")
	public int calculate_Area(@RequestBody ArrayList<Area> arr )
	{
		int currentArea=0,maxArea=0,index=0;
		for(int i=0;i<arr.size();i++)
		{
			Area area=arr.get(i);
			log.info("length : "+area.getLength()+" breadth : "+area.getBreadth());
			currentArea=rectangle.getarea(area.getLength(),area.getBreadth());
			log.info("currentArea : "+currentArea);
			if(maxArea<currentArea)
			{
				maxArea=currentArea;
				index=i;
			}
		}
		log.info("Out of all rectangles, Rectangle "+index+" has the maximum area = "+maxArea);
		return maxArea;		
	}
	
	@GetMapping("/addMinChar")
	public int addMinChar(@RequestParam String str)
	{
		String removedChar="";
		String s1;
		int count=0;
		if(new StringBuilder(str).reverse().toString().equals(str))
		{
			log.info("String is palindrome "+str);			
		}
		else
		{
		for(int i=str.length()-1;i>0;i--)
		{
			
			removedChar=removedChar+str.charAt(i);
			s1=removedChar+str;
			count++;
			if(s1.equals(new StringBuilder(s1).reverse().toString()))
			{
				log.info(removedChar +" needs to be added to the front of string to make palindrome");				
				log.info("String is palindrome "+s1);
				break;
				
			}
			else
			{
				int startIndex=removedChar.length();
				s1.substring(startIndex);
				log.info("After substring originalString "+s1);
			}
		}	
			
	}
		log.info("minimum "+count+" characters to be added to the front of string to make palindrome");
		return count;
	
	}	
	
	//{6, -3, -10, 0, 2}
	@GetMapping("/maxProduct")
	public  int maxProduct(@RequestParam("arrList") ArrayList<Integer> arr)
	{
		int maxProduct=0;
		List<Integer>list = null;
		int n=arr.size();
		for(int i=0;i<arr.size();i++)
		{
			list=arr.subList(0, n);
			log.info("list " + list);
			Integer product=list.stream().reduce(1, (a, b) -> a * b);
		
			if(maxProduct<product)
			{
				maxProduct=product;
				log.info("Subarray with maximum product is "+list+" which gives maxProduct " + maxProduct);
				
			}
			n--;
		}
		
		return maxProduct;
		
	}
	//1,2,3,4,5
	@GetMapping("/subSet")
	public  int subSet(@RequestParam("arrList") ArrayList<Integer> arr)
	{
		
		ArrayList<Integer>list = null;
		int n=arr.size();
		TreeSet<ArrayList<Integer>>set=new TreeSet<>();
		for(int i=arr.size();i>0;i--)
		{
			list=arr;
			list.remove(i);
			//set.add((ArrayList<Integer>) list);
			log.info("list " + list);
			for(int j=0;j<arr.size();j++)
			{
				
				list=arr;
				list.remove(j);
				log.info("list " + list);
			}
			
		}
		
		return 0;
		
	}
}
