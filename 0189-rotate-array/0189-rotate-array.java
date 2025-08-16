class Solution {
    //optimal solution
    public void rotate(int[] nums, int k) {
        k=k%nums.length; //number of rotations
        reverse(nums, 0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);  
    }
    static void reverse(int[] nums, int i , int j){
        while(i<j){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}
