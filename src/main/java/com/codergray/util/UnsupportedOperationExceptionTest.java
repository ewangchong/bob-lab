package com.codergray.util;

import java.util.*;

public class UnsupportedOperationExceptionTest {

	public static void main(String[] args) {
//		List<People> pList = new ArrayList<People>();
//		pList.add(new People("Bob",30));
//		pList.add(new People("Billy",28));
		People[] pArray = new People[2];
		pArray[0] = new People("Bob",30);
		pArray[1] = new People("Billy", 28);
		
		List<People> pList = new Vector<People>(Arrays.asList(pArray));

		Iterator<People> iter = pList.iterator();
		while (iter.hasNext())
		{
			People ppl = (People)iter.next();
			System.out.println(ppl);
			ppl.setName("Chong");
		}
		
		iter = pList.iterator();
		while (iter.hasNext())
		{
			People ppl = (People)iter.next();
			System.out.println(ppl);
			ppl.setName("Chen");
		}
	}

}
