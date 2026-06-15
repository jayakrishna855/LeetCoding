class Solution:
    def isSumEqual(self, firstWord: str, secondWord: str, targetWord: str) -> bool:
        letter_to_num = {chr(i): str(i - ord('a')) for i in range(ord('a'), ord('k'))}
        
        # Convert each word to its numerical value by joining the mapped numbers
        num_first_word = int("".join(letter_to_num[char] for char in firstWord))
        num_second_word = int("".join(letter_to_num[char] for char in secondWord))
        num_target_word = int("".join(letter_to_num[char] for char in targetWord))
        
        # Check if the sum of the first two words equals the third word
        return num_first_word + num_second_word == num_target_word
        