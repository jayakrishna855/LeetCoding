class Solution {
    public int minimumPushes(String word) {
        // int[] count = new int[26];
        // int unique = 0, ans = 0;
        // for(char c: word.toCharArray()){
        //     if(count[c-97]==0) unique+=1;
        //     count[c-97]+=1;
        // }
        // for(int i=0;i<26;i++){
        //     if(count[i]==0) count[i] = Integer.MAX_VALUE;
        // }
        // Arrays.sort(count[i]);
        // int i = 0;
        // while(unique>=8){
        //     int pushes = Math.ceil(unique/8);
        //     ans+=(pushes*count[i]);
        //     unique--;
        //     i++;
        // }

         int[] hashTable = new int[26];

        for(char ch : word.toCharArray()){
            hashTable[ch - 'a']++;
        }

        int minPushing = 0;

        Arrays.sort(hashTable);

        for(int i = 25, pushCnt = 0; i >= 0; i--){
            int currEleIdx = 25 - i;

            if(currEleIdx % 8 == 0)
                pushCnt++;

            minPushing += hashTable[i] * pushCnt;
        }

        return minPushing;


        

    }
}