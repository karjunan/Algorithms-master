function pivot(arr,left,right) {

     var pivot = left;
     var left = left + 1;
     var right = right;

     while( right >= left) {
          while(arr[left] < arr[pivot] && left <= right) {
               console.log("------------left Movement"+ arr[left]);
               left++;
          }
          while(arr[right] > arr[pivot] && left <= right) {
               console.log("right movement => "+ arr[right])
               right--;
          }

          if(arr[left] > arr[pivot] && arr[right] < arr[pivot] && left <= right ) {
               var temp = arr[left];
               arr[left] = arr[right];
               arr[right] = temp;
     
          }
          // console.log(arr);
     }
     console.log("Right location => "+ right)
     var temp = arr[right];
     arr[right] = arr[pivot];
     arr[pivot] = temp;
     console.log("iterating")
     return right;
}

function quickSort(arr,left,right) {

     if(left < right) {
          var p = pivot(arr,left,right);
          
          quickSort(arr,left,p-1);
          console.log(arr);
          quickSort(arr,p+1,right);
          console.log(arr);
     }

     return arr;

}

// let arr = [3,44,38,5,47,15,36,26,27,2,46,4,19,50,48]
let arr = [8,5,2,9,5,6,3]
let result = quickSort(arr,0,arr.length);
console.log(result);
