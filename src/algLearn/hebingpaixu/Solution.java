package algLearn.hebingpaixu;

public class Solution {
    public void mergeSort(int[] array,int left,int right){
        int middle=(left+right)/2;
        if(left<right){
            int[] bArray=new int[array.length];
            mergeSort(array,left,middle);
            mergeSort(array,middle+1,right);
            merge(array,bArray,left,middle,right);
            copy(bArray,array,left,right);
        }
    }

    private void copy(int[] bArray, int[] array, int left, int right) {
        for (int i = left; i <right ; i++) {
            array[i]=bArray[i];
        }
    }

    private void merge(int[] array, int[] bArray, int left, int middle, int right) {
        int i=left,j=middle+1,k=left;
        while (i<=middle && j<=right){
            if(array[i]<=array[j]){
                bArray[k++]=array[i++];
            }else {
                bArray[k++]=array[j++];
            }
        }
        if(i>middle){
            for (int l = j; l <=right ; l++) {
                bArray[k++]=array[l];
            }
        }else {
            for (int l = i; l <=middle ; l++) {
                bArray[k++]=array[l];
            }
        }
    }
}
