package 算法与数据结构.排序;

import org.junit.Test;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * @author: kangkang.lv
 * @date: 18-4-11 下午2:02
 */
public class SortTest {


    @Test
    public void test01(){
        int[] arr = {3,5,1,6,7,11,16};
        //insertSort(arr);
        //bubbleSort(arr);
        //selectionSort(arr);
        //quickSort(arr,0,arr.length-1);
        shellSort(arr);
        for (int i = 0;i<arr.length;i++){
            System.out.printf(arr[i]+" ");
        }
    }

    /**
     * 插入排序
     * ***把后面未排序的第一个(记录数值)跟前面一排序的从后向前比较 比有序数a小,则a向后移动
     *
     * 步骤:
     * 1.从第一个元素开始，该元素可以认为已经被排序；
     * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 5.将新元素插入到该位置后；
     * 6.重复步骤2~5。
     * @param arr
     */
    public void insertionSort(int[] arr){
        int cur;
        int j;
        for (int i=1;i<arr.length;i++){
            cur = arr[i];
            j=i;
            for (;j>0 && cur < arr[j-1];j--){
                arr[j] = arr[j-1];
            }
            arr[j] = cur;
        }
    }


    /**
     * 希尔排序
     *
     * 参考:https://www.cnblogs.com/chengxiao/p/6104371.html
     *
     * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，
     * 当增量减至1时，整个文件恰被分成一组，算法便终止
     *
     * @param arr
     */
    public void shellSort(int[] arr){
        int temp;
        for (int step = arr.length/2;step > 0;step = step/2){
            for (int i = step;i<arr.length;i+=step){
                temp = arr[i];
                int j = i;
                for (;j >= step && temp < arr[j-step];j-=step){
                    arr[j] = arr[j-step];
                }
                arr[j] = temp;
            }
        }
    }

    public static void sort1(int []arr){
                 //增量gap，并逐步缩小增量
                 for(int gap=arr.length/2;gap>0;gap/=2){
                         //从第gap个元素，逐个对其所在组进行直接插入排序操作
                         for(int i=gap;i<arr.length;i++){
                                 int j = i;
                                 int temp = arr[j];
                                 if(arr[j]<arr[j-gap]){
                                          while(j-gap>=0 && temp<arr[j-gap]){
                                                 //移动法
                                                 arr[j] = arr[j-gap];
                                                 j-=gap;
                                             }
                                         arr[j] = temp;
                                     }
                             }
                     }
             }

    /**
     * 冒泡排序
     * 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 3.针对所有的元素重复以上的步骤，除了最后一个；
     * 4.重复步骤1~3，直到排序完成。
     * @param arr
     */
    public void bubbleSort(int[] arr){
        for (int i = 0;i<arr.length;i++){
            for (int j = 0;j<arr.length-i-1 ;j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * ***从为排序组中选出个最小(记录下标)的排到前面有序列的最后,
     *
     *
     * 1.初始状态：无序区为R[1..n]，有序区为空；
     * 2.第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * 3.n-1趟结束，数组有序化了。
     * @param arr
     */
    public void selectionSort(int[] arr){
        int k;
        for (int i=0;i<arr.length-1;i++){
            k = i;
            for (int j = k+1;j<arr.length;j++){
                if (arr[k] > arr[j]){
                    k = j;
                }
            }
            if (k != i){
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 快速排序
     *
     * 参考:
     *  https://blog.csdn.net/vayne_xiao/article/details/53508973
     *  https://blog.csdn.net/code_ac/article/details/74158681
     *
     * @param arr
     * @param start
     * @param end
     */
    public void quickSort(int[] arr,int start,int end){
        if (end > start){
            int i_start = start;
            int i_end = end;
            int p = arr[start];
            while (i_end !=i_start){
                while (i_end !=i_start && arr[i_end] >= p){
                    i_end--;
                }
                while (i_end !=i_start && arr[i_start] <= p){
                    i_start++;
                }
                if (i_end != i_start){
                    swap(arr,i_start,i_end);
                }else{
                    swap(arr,start,i_end);
                }
            }
            quickSort(arr,start,i_end-1);
            quickSort(arr,i_end+1,end);
        }
    }

    public void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
