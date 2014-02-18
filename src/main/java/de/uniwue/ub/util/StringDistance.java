package de.uniwue.ub.util;

public class StringDistance {
  private static StringDistance instance = null;

  private StringDistance() {
  }

  /**
   * @return instance of this class.
   */
  public static StringDistance getInstance() {
    if (instance == null)
      instance = new StringDistance();

    return instance;
  }

  public int levenshtein(String a, String b) {
    int[] costs = new int[b.length() + 1];

    for (int j = 0; j < costs.length; j++)
      costs[j] = j;

    for (int i = 1; i <= a.length(); i++) {
      costs[0] = i;
      int nw = i - 1;

      for (int j = 1; j <= b.length(); j++) {
        int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]),
            a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
        nw = costs[j];
        costs[j] = cj;
      }
    }

    return costs[b.length()];
  }
}
