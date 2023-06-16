package org.practice.Anagrams;

//https://www.geeksforgeeks.org/minimum-cost-make-two-strings-identical/

/**
 * Given two strings X and Y, and two values costX and costY.
 * We need to find minimum cost required to make the given two strings identical.
 * We can dequeue characters from both the strings. The cost of deleting a character from string X is costX and from Y is costY.
 * Cost of removing all characters from a string is same.
 *
 * This problem is a variation of Longest Common Subsequence ( LCS ).
 * The idea is simple, we first find the length of longest common subsequence of strings X and Y.
 * Now subtracting len_LCS with lengths of individual strings gives us number of characters to be removed to make them identical.
 */
public class MinCost {

}
