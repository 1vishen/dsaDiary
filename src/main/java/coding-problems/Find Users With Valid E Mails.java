# Write your MySQL query statement below

/*
REGEXP in SQL is used for pattern matching on strings, similar to regular expressions in programming.
It allows defining character classes and special operators that control how text is matched:

Regex special symbols in SQL (REGEXP):

[]  → Character class, matches any one character inside the brackets.
      Example: [A-Z] matches "A" or "M" or "Z"; [0-9] matches "3" or "7".
^   → Anchor for start of string, ensures the match begins at the very first character.
      Example: ^abc matches "abc123" but not "123abc".
$   → Anchor for end of string, ensures the match finishes at the very last character.
      Example: xyz$ matches "123xyz" but not "xyz123".
*   → Quantifier meaning zero or more occurrences of the preceding character or group.
      Example: a* matches "", "a", "aa", "aaa".
+   → Quantifier meaning one or more occurrences of the preceding character or group.
      Example: a+ matches "a", "aa", "aaa" but not "".
?   → Quantifier meaning zero or one occurrence of the preceding character or group.
      Example: a? matches "" or "a" but not "aa".
{n,m} → Quantifier meaning between n and m occurrences of the preceding character or group.
        Example: a{2,4} matches "aa", "aaa", "aaaa" but not "a" or "aaaaa".
.   → Wildcard that matches any single character (except newline).
      Example: a.c matches "abc", "a-c", "a9c".
\   → Escape character, used to treat special symbols literally.
      Example: \. matches a literal dot ".", not "any character"; \\d matches a digit.

These operators make REGEXP powerful for validating formats like emails, phone numbers, or custom patterns.
Use REGEXP when substring or LIKE checks become too complex or verbose.
*/

        select user_id, name, mail
from Users
/* REGEXP BINARY enforces case-sensitive matching in MySQL */
/*
where mail regexp binary '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\\.com$';
this gives this error:- Character set 'utf8mb3_general_ci' cannot be used in conjunction with 'binary' in call to regexp_like.
where cast(mail as binary) regexp '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\\.com$';
Character set 'binary' cannot be used in conjunction with 'utf8mb4_general_ci' in call to regexp_like.
*/
where mail COLLATE utf8mb3_bin regexp '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\\.com$';

