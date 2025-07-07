package icu.xiamu.code6;

import com.sun.java.accessibility.util.TopLevelWindowListener;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // return process1(nums);
        // return process2(nums);
        // return process3(nums);
        return process4(nums);
    }

    /**
     * 双指针
     *
     * @param nums 数组
     * @return 答案
     */
    private List<List<Integer>> process4(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        // 使用一个 for 循环，固定第一个元素 nums[i]。i 的范围是从 0 到 nums.length - 2 (因为需要至少两个后续元素)。
        for (int i = 0; i < nums.length - 2; i++) {

            // 跳过重复的 nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 优化：如果当前 nums[i] 已经大于 0，则后续不可能找到和为 0 的组合
            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳过重复的 nums[left] 和 nums[right]
                    while (left < right && nums[left+1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right-1] == nums[right]) {
                        right--;
                    }

                    // 移动指针继续寻找
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }

    /**
     * Hash法
     *
     * @param nums 数组
     * @return 答案
     */
    private List<List<Integer>> process3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        // Map<Integer, Integer> map = IntStream.range(0, nums.length).boxed().collect(Collectors.toMap(index -> index, index -> nums[index]));
        Map<Integer, Integer> map = IntStream.range(0, nums.length).boxed().collect(Collectors.toMap(index -> nums[index], index -> index, (existingValue, newValue) -> newValue));


        for (int i = 0; i < nums.length - 1; i++) {

            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int kNum = -(nums[i] + nums[j]);
                Integer kIndex = map.get(kNum);
                if (kIndex != null && kIndex > j) {
                    result.add(Arrays.asList(nums[i], nums[j], kNum));
                }
            }
        }

        return result.stream().map(l -> {
            List<Integer> integers = new ArrayList<>(l);
            Collections.sort(integers);
            return integers;
        }).distinct().toList();
    }

    private List<List<Integer>> process2(int[] nums) {
        if (nums.length < 3) {
            return null;
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();


        for (int mid = 0; mid < nums.length; mid++) {
            if (nums[mid] > 0) break;
            if (mid > 0 && nums[mid] == nums[mid - 1]) continue;
            int left = mid + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    while (left < right && nums[left] == nums[right]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }

        return result;
    }

    /**
     * 超时
     *
     * @param nums 数组
     * @return 答案
     */
    private List<List<Integer>> process1(int[] nums) {
        if (nums.length < 3) {
            return null;
        }

        Arrays.sort(nums);

        // int i = 0;
        // int j = 1;
        // int k = 2;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = i + 2; k < nums.length; k++) {
                    if (i != j && j != k && i != k && nums[i] + nums[j] == -nums[k]) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return new ArrayList<>(result.stream()
                // 1. 对每个内部列表进行排序
                .map(l -> {
                    List<Integer> mutableList = new ArrayList<>(l); // 创建可变副本
                    Collections.sort(mutableList); // 对副本排序
                    return mutableList; // 返回排序后的副本
                })
                // 2. 将排序后的列表转换为字符串表示以进行去重
                //    这里使用 Collectors.joining(",") 将列表元素用逗号连接成字符串
                .collect(Collectors.toMap(
                        l -> l.stream().map(Object::toString).collect(Collectors.joining(",")),
                        l -> l,
                        (existing, replacement) -> existing
                ))
                .values());
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        // System.out.println(new Solution().threeSum(new int[]{0, 1, 1}));
        // System.out.println(new Solution().threeSum(new int[]{0, 0, 0}));
        System.out.println(new Solution().threeSum(new int[]{2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10}));
        // System.out.println(new Solution().threeSum(new int[]{0, 0, 0, 0}));
    }
}