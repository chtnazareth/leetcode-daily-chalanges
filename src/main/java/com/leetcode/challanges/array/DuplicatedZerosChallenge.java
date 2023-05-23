/**
 *  Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 *  Note that elements beyond the length of the original array are not written.
 *  Do the above modifications to the input array in place
 *  (For this exercise the array will be returned to be used on tes)
 *
 *  Example 1: *
 *   Input: arr = [1,0,2,3,0,4,5,0]
 *   Output: [1,0,0,2,3,0,0,4]
 *   Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 *  Example 2: *
 *   Input: arr = [1,2,3]
 *   Output: [1,2,3]
 *   Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 *     1 <= arr.length <= 104
 *     0 <= arr[i] <= 9
 */

package com.leetcode.challanges.array;


import java.util.Arrays;

public class DuplicatedZerosChallenge {
  /**
   * Este método percorre a matriz de inteiros do final para o início. Para cada elemento, verifica se é zero. Se for,
   * tenta duplicar esse zero deslocando os elementos restantes para a direita. No entanto, de acordo com as restrições
   * do problema, elementos além do comprimento da matriz original não são considerados, portanto, se houver qualquer
   * deslocamento, o último elemento será descartado.
   *
   * Isso efetivamente duplica cada zero no array, exceto os que estão no final do array.
   * Isso é feito para se manter de acordo com a restrição de que elementos além do comprimento da matriz original não são escritos.
   * *******************************************************************************************************************
   *
   * A complexidade de tempo do algoritmo é O(n^2). Isso ocorre porque, para cada zero no array, podemos potencialmente
   * ter que deslocar todos os elementos à direita do zero. No pior caso, se todos os elementos do array forem zeros,
   * precisaríamos de uma quantidade de tempo proporcional ao quadrado do tamanho do array para executar a função,
   * portanto, a complexidade de tempo é O(n^2).
   *
   * A complexidade de espaço do algoritmo é O(1), o que significa que a quantidade de memória usada pelo algoritmo
   * não aumenta com o tamanho do array de entrada. O algoritmo modifica o array de entrada no local e não usa nenhuma
   * estrutura de dados adicional cujo tamanho depende do tamanho do array de entrada. Portanto,
   * a complexidade do espaço é constante.
   * *******************************************************************************************************************
   *
   * @param arr - int array
   * @return arr with the duplicated zeros
   */
  public static int []  duplicateZerosLogN(int[] arr) {
    // O tamanho do array original
    int n = arr.length;
    // Percorrendo o array de trás para frente
    for (int i = n - 1; i >= 0; i--) {
      // Se o elemento atual é zero
      if (arr[i] == 0) {
        // Deslocando todos os elementos à direita do zero atual para a direita
        for (int j = n - 1; j > i; j--) {
          arr[j] = arr[j - 1];
        }
        // Se o próximo índice ainda está dentro da matriz,
        // setamos o próximo índice para zero, duplicando o zero atual
        if (i < n - 1) {
          arr[i + 1] = 0;
        }
      }
    }
    return arr;
  }

  /**
   * Na primeira passagem, contamos os zeros. Se encontramos um zero no fim da matriz durante essa passagem,
   * o tratamos de maneira especial, porque não há espaço para duplicá-lo.
   *
   * Na segunda passagem, começamos a mover os elementos a partir do último zero que será duplicado.
   * Se encontramos um zero, o duplicamos. Se encontramos um elemento diferente de zero, apenas o movemos para a posição correta.
   *********************************************************************************************************************
   *
   * Esta solução tem complexidade de tempo O(n) porque fazemos apenas duas passagens pelo array,
   * independentemente do número de zeros que ele contém.
   *
   * A complexidade de espaço continua sendo O(1), porque ainda estamos modificando o array de entrada no local
   * e não estamos usando estruturas de dados adicionais que dependem do tamanho do array de entrada.
   * @param arr
   * @return
   */
  public static int []  duplicateZerosON(int[] arr) {
    // Obtém o tamanho do array
    int n = arr.length;

    // Contador para o número de zeros
    int numZeros = 0;

    // Primeira passagem: contar os zeros
    for (int i = 0; i < n - numZeros; i++) {
      // Se o elemento atual é zero
      if (arr[i] == 0) {
        // Se o zero está no final da matriz, ele é tratado de maneira especial
        if (i == n - numZeros - 1) {
          // Definir o último elemento como zero
          arr[n - 1] = 0;
          // Diminuir o tamanho efetivo da matriz
          n--;
          // Interromper o loop
          break;
        }
        // Incrementar o contador de zeros
        numZeros++;
      }
    }
    System.out.println("Numero de zeros: " + numZeros);

    // Segunda passagem: mover os elementos
    int last = n - numZeros - 1;

    System.out.println(Arrays.toString(arr));
    System.out.println("last: " + last);
    for (int i = last; i >= 0; i--) {
      System.out.println("i : " + i);
      // Se o elemento atual é zero
      if (arr[i] == 0) {
        // Duplicar o zero
        arr[i + numZeros] = 0;
        numZeros--;
        arr[i + numZeros] = 0;
      } else {
        // Mover o elemento não-zero para a posição correta
        arr[i + numZeros] = arr[i];
      }
      System.out.println(Arrays.toString(arr));
    }
    return arr;
  }
}
