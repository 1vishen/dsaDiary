# Write your MySQL query statement below

/*
LENGTH() measures the length of a string in bytes.
CHAR_LENGTH() measures the length of a string in characters.
*/

select tweet_id
from Tweets
where char_length(content) > 15;
