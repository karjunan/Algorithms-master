function pivot(arr, i, j) {
    if(i === j) {
        return j;
    }
    var pivot = i;
    i = i+1;
    while( i <= j ) {
      
        while(arr[i] <= arr[pivot]) {
            i++;
        }
        while(arr[j] > arr[pivot]) {
            j--;
        }

        if( i < j ) {
            var temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
       }
      
    }
    console.log("Value of j => ", j, arr[j]);
    var temp = arr[pivot];
    arr[pivot] = arr[j];
    arr[j] = temp;
    console.log(arr);
    return j
}

function quickSort(array,left,right) {
     if( left >= right ) {
         console.log( "Left and Right => " + left , right);
         return array;
     }

     
     var position = pivot(array,left,right)
     quickSort(array,left,position-1);
     quickSort(array,position+1,right);
     return array;
}

// let arr = [3,44,38,5,47,15,36,26,27,2,46,4,19,50,4];
// let arr = [8,5,2,9,5,6,3]
// let arr = [1]
// let arr = [1, 2];
// let arr = [2, 1];
// let arr = [1, 3, 2];
// let arr = [3, 1, 2];
// let arr = [1, 2, 3];
let arr = [-4,5,10,8,-10,-6,-4,-2,-5,3,5,-4,-5,-1,1,6,-7,-6,-7,8]
// let arr = [-7, 2, 3, 8, -10, 4, -6, -10, -2, -7, 10, 5, 2, 9, -9, -5, 3, 8]
// let arr = [5, -2, 2, -8, 3, -10, -6, -1, 2, -2, 9, 1, 1];
// let arr = [2,-2,-6,-10,10,4,-8,-1,-8,-4,7,-4,0,9,-9,0,-9,-9,8,1,-4,4,8,5,1,5,0,0,2,-10]

// let arr = [ 8, 5, 2, 9, 5, 6, 3 ]
let result = quickSort(arr,0,arr.length-1);
console.log(result);