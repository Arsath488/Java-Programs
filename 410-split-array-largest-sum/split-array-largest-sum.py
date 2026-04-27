class SplitArrayLargestSum:
    def splitArray(self, nums: list[int], k: int) -> int:
        def can_split(max_sum):
            current_sum = 0
            splits = 1
            for num in nums:
                if current_sum + num > max_sum:
                    splits += 1
                    current_sum = num
                    if splits > k:
                        return False
                else:
                    current_sum += num
            return True

        left = max(nums)
        right = sum(nums)
        res = right

        while left <= right:
            mid = left + (right - left) // 2
            if can_split(mid):
                res = mid
                right = mid - 1
            else:
                left = mid + 1
        return res

class Solution(SplitArrayLargestSum):
    pass
