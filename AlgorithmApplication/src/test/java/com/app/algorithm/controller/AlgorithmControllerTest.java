package com.app.algorithm.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;
import com.app.algorithm.controller.AlgorithmController;
import com.app.algorithm.pojo.Area;
import com.app.algorithm.pojo.Rectangle;

@SpringBootTest
public class AlgorithmControllerTest {

	@InjectMocks
	private AlgorithmController algorithmController;
	
	@Mock
	Rectangle rect;

	@Test
	public void isPrimeTest()
	{
		Integer res=algorithmController.isPrime(7);
		assertEquals(1, res);
	}
	
	@Test
	public void findFactTest()
	{
		Integer res=algorithmController.findFact(5);
		assertEquals(120, res);
	}
	@Test
	public void noIsNotPrimeTest()
	{
		Integer res=algorithmController.isPrime(8);
		assertEquals(0, res);
	}

	@Test
	public void sieveOfEratosthenesTest()
	{
		ArrayList<Integer> exp=new ArrayList<>(Arrays.asList(2,3,5,7));
		ArrayList<Integer> res=algorithmController.sieveOfEratosthenes(10);
		assertEquals(exp, res);
	}
	
	@Test
	public void nthFibonacciTest()
	{
		Integer res=algorithmController.nthFibonacci(8);
		assertEquals(21, res);
	}
	
	@Test
	public void SeriesTest()
	{
		ArrayList<Integer> exp=new ArrayList<>(Arrays.asList(0,1,1,2,3,5,8,13));
		ArrayList<Integer> res=algorithmController.Series(8);
		assertEquals(exp, res);
	}
	
	
	@Test
	public void findDiffTest()
	{
		Integer res=algorithmController.findDiff(68);
		assertEquals(30, res);
	}
	
	@Test
	public void findDiff2Test()
	{
		Integer res=algorithmController.findDiff(968);
		assertEquals(270, res);
	}
	
	@Test
	public void remAnagramTest()
	{
		Integer res=algorithmController.remAnagram("cddgk","gcd");
		assertEquals(2, res);
	}
	

	@Test
	public void isPalindromeTest()
	{
		Integer res=algorithmController.isPalindrome("cbc");
		assertEquals(1, res);
	}
	
	@Test
	public void stringIsNotPalindromeTest()
	{
		Integer res=algorithmController.isPalindrome("abcd");
		assertEquals(0, res);
	}
	
	@Test
	public void is_NoPalindromeTest()
	{
		String res=algorithmController.is_Palindrome(555);
		assertEquals("Yes", res);
	}
	
	@Test
	public void is_NoNotPalindrome()
	{
		String res=algorithmController.is_Palindrome(456);
		assertEquals("No", res);
	}
	
	@Test
	public void immediateSmallerTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(5, 6, 2, 3, 1, 7));
		ArrayList<Integer> exp=new ArrayList<>(Arrays.asList(-1,2,-1,1,-1,-1));
		ArrayList<Integer> res=algorithmController.immediateSmaller(5,arr);
		assertEquals(exp, res);
	}
	
	@Test
	public void thirdLargestTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(5, 6, 2, 3, 1, 7));
		Integer res=algorithmController.thirdLargest(arr);
		assertEquals(5, res);
	}
	
	@Test
	public void print2largestTest()
	{
		TreeSet<Integer> arr=new TreeSet<>(Arrays.asList(5, 6, 2, 3, 1, 7));
		Integer res=algorithmController.print2largest(arr);
		assertEquals(6, res);
	}
	
	
	@Test
	public void minAnd2ndMinElementTest()
	{
		TreeSet<Integer> arr=new TreeSet<>(Arrays.asList(5, 6, 2, 3, 1, 7));
		Map<String, Integer> res=algorithmController.minAnd2ndMinElement(arr);
		assertEquals(1, res.get("smallest"));
		assertEquals(2, res.get("secondSmallest"));
	}
	
	
	@Test
	public void kthSmallestElementTest()
	{
		TreeSet<Integer> arr=new TreeSet<>(Arrays.asList(5, 6, 2, 3, 1, 7));
		Integer res=algorithmController.kthSmallestElement(4,arr);
		assertEquals(5, res);		
	}
	
	@Test
	public void mergeStringTest()
	{
		String res=algorithmController.mergeString("abc", "pqr");
		assertEquals("apbqcr", res);
	}
	
		
	@Test
	public void isSubsequenceTest()
	{
		boolean res=algorithmController.isSubsequence("AXY", "ADXCPY");
		assertEquals(true, res);
	}
	
	@Test
	public void notSubsequenceTest()
	{
		boolean res=algorithmController.isSubsequence("AXY", "YADXCP");
		assertEquals(false, res);
	}
			
	@Test
	public void goodStringTest()
	{
		Integer res=algorithmController.isGoodorBad("abcioau");
		assertEquals(0, res);
	}
	
	@Test
	public void badStringTest()
	{
		Integer res=algorithmController.isGoodorBad("??abcioaue");
		assertEquals(1, res);
	}
	
	@Test
	public void firstAndLastOccurenceOfXTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,2,3,4,4,4,4,5));
		ArrayList<Integer> res=algorithmController.firstAndLastOccurenceOfX(7, 4, arr);
		assertEquals(3, res.get(0));
		assertEquals(6, res.get(1));
	}
	
		
	@Test
	public void equilibriumPointTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,3,5,2,2));
		Integer res=algorithmController.equilibriumPoint(arr);
		assertEquals(2, res);		
	}
	
	
	
	@Test
	public void isFrequencyNotUniqueTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1, 1, 2, 5, 5));
		boolean res=algorithmController.isFrequencyUnique(arr);
		assertEquals(false, res);		
	}
	
	@Test
	public void isFrequencyUniqueTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1, 1, 1,2, 5, 5));
		boolean res=algorithmController.isFrequencyUnique(arr);
		assertEquals(true, res);		
	}
	
	
	
	@Test
	public void MissingNumberTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,2,3,5));
		Integer res=algorithmController.MissingNumber(5, arr);
		assertEquals(4, res);		
	}
	
		
	@Test
	public void getPairsCountTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,5,7,1));
		Integer res=algorithmController.getPairsCount(4, 6, arr);
		assertEquals(2, res);		
	}
	
	
	
	@Test
	public void stockBuySellTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(7, 8,9,10,2,8));
		Collection<ArrayList<Integer>> res=algorithmController.stockBuySell(arr);
		assertNotNull(res);	
	}
	
	
	@Test
	public void stockBuySellMaxProfitTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(7, 8,9,10,2,8));
		int res=algorithmController.stockBuySellMaxProfit(arr);
		assertEquals(9,res);	
	}
	
	
	@Test
	public void calculate_AreaTest()
	{
		Area a1=new Area();
		a1.setLength(4);
		a1.setBreadth(5);
		Area a2=new Area();
		a2.setLength(8);
		a2.setBreadth(5);
		ArrayList<Area> arr=new ArrayList<>();
		arr.add(a1);
		arr.add(a2);
		
		Mockito.when(rect.getarea(a1.getLength(), a1.getBreadth())).thenReturn(40);
		Integer res=algorithmController.calculate_Area(arr);
		assertEquals(40, res);		
	}
	
	
	
	@Test
	public void addMinCharTest()
	{
		Integer res=algorithmController.addMinChar("abcd");
		assertEquals(3, res);
	}
	
	@Test
	public void zigZagTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(2,4,5,1,7,6,8));
		ArrayList<Integer> exp=new ArrayList<>(Arrays.asList(2, 5, 1, 7, 4, 8, 6));
		ArrayList<Integer> res=algorithmController.zigZag(arr);
		assertEquals(exp, res);
	}
	
	@Test
	public void maxProductTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(6, -3, -10, 0, 2));
		int res=algorithmController.maxProduct(arr);
		assertEquals(180, res);
	}
	
	@Test
	public void allSubSetsTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,2,2));
		TreeSet<ArrayList<Integer>> res=algorithmController.allSubSets(arr);
		assertNotNull(res);
	}
	
	@Test
	public void countSubsetsTest()
	{
		ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,2,2));
		long res=algorithmController.countSubsets(arr);
		assertEquals(2,res);
	}
}