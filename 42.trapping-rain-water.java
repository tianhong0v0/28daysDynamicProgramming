class Solution {
    public static int trap(int[] height) {
        int total = 0;
        int barLen = height.length;
        int empty = 0;
        for(int h: height){
            if (h == 0) empty++;
        }
        int barCounter = barLen - empty;
        //while there are more than two bar's elevation are not zero
        while(barCounter >= 2){
            //get the index of first and last bar
            int first = getFirst(height);
            int last = getLast(height);
            //tmpBarLen: (current level's bar length)
            //tmpBarNum: (current level's number of bar)
            int tmpBarLen = last - first + 1;
            int tmpBarNum = 0;
            //count the number of water blocks for each level
            for(int i=first; i<=last; i++){
                if(height[i] > 0){
                    tmpBarNum++;
                    height[i]--;
                    if(height[i] == 0){
                        barCounter--;
                    }
                }
            }
            //the number of water blocks for each level is calculated by: 
            //(current level's bar length) - (current level's numerb of bar)
            total = total + tmpBarLen -tmpBarNum;
        }
        return total;   
    }

    //get the index of the first non-zero element in an array
    public static int getFirst(int[] a){
        int res = 0;
        for(int i=0; i<a.length; i++){
            if(a[i]!= 0){
                res = i;
                break;
            }
        }
        return res;
    }
    
    //get the index of the last non-zero element in an array
    public static int getLast(int[] a){
        int res = a.length-1;
        for(int i=a.length-1; i>=0; i--){
            if(a[i]!= 0){
                res = i;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] heights = new int[] {0,10,3,0,2,2,2,4,2,3,10,5,5,1,5,0,1,0};
        System.out.println(trap(heights));
    }
}


