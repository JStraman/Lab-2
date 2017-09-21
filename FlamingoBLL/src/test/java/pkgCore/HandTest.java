package pkgCore;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandTest {

	//passes you back the score for that hand
	public int[] HandHelper(ArrayList<Card> cards) {
			
		int[] result = null;

		try {
			
			//	c = structure of class 'Hand'
			Class<?> c = Class.forName("pkgCore.Hand");

			//	the arguments for 'AddCard' is an instance of Card
			Class[] cArgsAddCard = new Class[1];
			cArgsAddCard[0] = pkgCore.Card.class;

			//	Create an instance of Hand
			Object inst = c.newInstance();

			//	Find the method 'AddCard' in Hand
			// This makes it accessible ONLY for testing purposes, not by anyone else
			Method mAddCard = c.getDeclaredMethod("AddCard", cArgsAddCard);
			
			//	Make the private method accessible 
			mAddCard.setAccessible(true);
			
			//	Invoke the AddCard method for each card passed into this method
			for (Card card: cards)
			{
				mAddCard.invoke(inst, card);
			}
			
			//	Find the method 'ScoreHand' in 'Hand'
			Method mScore = c.getDeclaredMethod("ScoreHand", null);
			
			//	Invoke 'ScoreHand'.  It returns an array of integers
			result = (int[]) mScore.invoke(inst, null);

			//	easy way to see each score.  not necessary.. but helps
			for (int i : result) {
				System.out.println(i);
			}
			

		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Test
	public void test1() {
		
		// COMPLETE: Test 2-3-4, score should be 9

		ArrayList<Card> cards = new ArrayList<Card>();
		
		// COMPLETE:  REMOVE THE COMMENTS FROM THE NEXT THREE LINES
		
		cards.add(new Card(eSuit.CLUBS,eRank.TWO));
		cards.add(new Card(eSuit.CLUBS,eRank.THREE));
		cards.add(new Card(eSuit.CLUBS,eRank.FOUR));
		
		int[] score = HandHelper(cards);
		
		//	COMPLETE: Check Score to make sure it's right.  Something close to this:
		assertEquals(score[0],9);		
		//System.out.println(score[0]);
	}

	@Test
	public void test2() {
		// COMPLETE: Test 2-3-J, score should be 15
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS,eRank.TWO));
		cards.add(new Card(eSuit.CLUBS,eRank.THREE));
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],15);		
		//System.out.println(score[0]);
	}

	@Test
	public void test3() {
		// COMPLETE: Test 2-3-J-J, score should be 25
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS,eRank.TWO));
		cards.add(new Card(eSuit.CLUBS,eRank.THREE));
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],25);		
		//System.out.println(score[0]);
	}

	@Test
	public void test4() {
		// COMPLETE: Test J-A, score should be 21
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		
		int[] score = HandHelper(cards);
		
		//System.out.println("Should be 21: " + score[0]);
		//System.out.println("Should be 11: " + score[1]);
		assertEquals(score[0],21);		
	}

	@Test
	public void test5() {
		// COMPLETE: Test J-A-A, score should be 12
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],12);		
	}

	@Test
	public void test6() {
		// COMPLETE: Test J-A-A-A, score should be 13
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));		
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],13);		
	}
	
	@Test
	public void test7() {
		//	COMPLETE: Test A-A-A-A-2, score should be 6 or 16
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));		
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.TWO));
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],6);	
		assertEquals(score[1],16);
	}

}
