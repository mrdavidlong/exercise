package exercise;

import java.util.*;

/*
Email validation

Pattern: local@domain

Local
Accepts: a..z A..Z 0..9 . _ - + $ #
Max 64 characters

Domain
Series of label(.label)*
Max 253 characters

Label
Accepts: a..z A..Z 0..9 _ -
Max 63 characters

Rules
Local & label start with a..z A..Z 0..9

Example:

email: ozan@uber.com
local: ozan
domain: uber.com
labels: [uber, com]

dave@localhost

1. find @, local, domain
2. for local, loop chars, if find something else return false
3, for domain, split the labels
3 b, for each label check chars


1. assume local, walk and check chars for local
2. while I hit @ sign, I am in the domain part, and I am looking for the chars for the label + . chars


 */

public class ValidateEmail {
  public static void main(String[] args) {
    boolean result = isValidEmail("a@b.c");
    System.out.println(result);
  }
  // Hint:
  // Set<String> h = new HashSet<String>(Arrays.asList("a", "b"));

  
  static Set<String> validCharsForLocalSet = new HashSet<String>(Arrays.asList("a", "b", "c"));

  static Set<String> validCharsForLabelSet = new HashSet<String>(Arrays.asList("a", "b", "c"));
  
  static Set<String> validCharsForDomainSet = new HashSet<String>(Arrays.asList("a", "b", "c", "."));
 
//  Local & label start with a..z A..Z 0..9
  static Set<String> validCharsForLocalDomainStartSet = new HashSet<String>(Arrays.asList("a", "b", "c"));
  
  public static boolean isValidEmail(String email) {
    int state = 1; // local = 1, domain =2
    int localCharCount = 0;
    int domainCharCount = 0;
    int labelCharCount = 0;
    for(int i = 0; i < email.length(); i++) {
      char c = email.charAt(i);
      // check a..z A..Z 0..9 . _ - + $ #

      if (c == '@') {
        state = 2;
        continue;
      }
      
      //local
      if (state == 1) {
        if (localCharCount == 0) {
          if (!validCharsForLocalDomainStartSet.contains(c)) {
            return false;
          }
        }
        localCharCount++;
        if (localCharCount > 64) {
          return false;
        }
        if (!validCharsForLocalSet.contains(c)) {
          return false;
        }
      }
       
      if (state == 2) {
        if (domainCharCount == 0) {
          if (!validCharsForLocalDomainStartSet.contains(c)) {
            return false;
          }
        }
        labelCharCount++;
        if (c == '.') {
          labelCharCount = 0;
        }
        if (labelCharCount > 63) {
          return false;
        }                                 
              
        domainCharCount++;
        if (domainCharCount > 253) {
          return false;
        }
        if (!validCharsForDomainSet.contains(c)) {
          return false;
        }
      }
    }
    return true;
  }
      
      
  
}