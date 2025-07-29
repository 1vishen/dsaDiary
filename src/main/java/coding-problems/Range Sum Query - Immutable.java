class NumArray {
  int[] numsSum;
  int sum = 0;

  public NumArray(int[] nums) {
      numsSum = new int[nums.length + 1]; //nums is immutable, cant change it
      for(int i = 0; i < nums.length; i++) {
          numsSum[i + 1] = numsSum[i] + nums[i]; //numsSum[0] is always 0 so it wont change anything
      }
  }

  public int sumRange(int left, int right) {
      return numsSum[right + 1] - numsSum[left];
  }
}

/**
* Your NumArray object will be instantiated and called as such:
* NumArray obj = new NumArray(nums);
* int param_1 = obj.sumRange(left,right);
*/