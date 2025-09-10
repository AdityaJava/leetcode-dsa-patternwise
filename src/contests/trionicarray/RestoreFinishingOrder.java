package contests.trionicarray;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RestoreFinishingOrder {
  public int[] recoverOrder(int[] order, int[] friends) {
    Set<Integer> friendSet = Arrays.stream(friends).boxed().collect(Collectors.toSet());
    int[] finishOrder = new int[friends.length];
    int k = 0;
    for (int i = 0; i < order.length; i++) {
      if (friendSet.contains(order[i])) {
        finishOrder[k++] = order[i];
      }
    }
    return finishOrder;
  }

  public static void main(String[] args) {

  }
}
