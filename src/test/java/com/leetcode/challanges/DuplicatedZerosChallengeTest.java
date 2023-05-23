package com.leetcode.challanges;

import com.leetcode.challanges.array.DuplicatedZerosChallenge;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicatedZerosChallengeTest {
  @Test
  void duplicateZerosLogN() {
    int arr[] = {1,2,0,8,0,6,7};
    int expected [] = {1,2,0,0, 8,0,0};
    int[] ints = DuplicatedZerosChallenge.duplicateZerosLogN(arr);
    assertThat(ints).isEqualTo(expected);
  }

  @Test
  void duplicateZerosON() {
    int arr[] = {1,2,0,8,0,6,7,9};
    int expected [] = {1,2,0,0,8,0,0,6};
    int[] ints = DuplicatedZerosChallenge.duplicateZerosON(arr);
    assertThat(ints).isEqualTo(expected);
  }
}